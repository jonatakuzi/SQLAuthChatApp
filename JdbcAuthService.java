package mchat;

import java.sql.*;

public class JdbcAuthService implements AuthService {
    private final String url, user, pass;

    public JdbcAuthService(String url, String user, String pass) {
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

    private Connection conn() throws SQLException {
        return DriverManager.getConnection(url, user, pass);
    }

    @Override
    public boolean authenticate(String username, String password) {
        String sql = "SELECT COUNT(*) FROM DL27Login WHERE username=? AND password=?";
        try (Connection c = conn(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getInt(1) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String getDisplayName(String username) {
        String sql = "SELECT display_name FROM DL27Login WHERE username=?";
        try (Connection c = conn(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return username;
    }

    @Override
    public byte[] getProfileImageBytes(String username) {
        String sql = "SELECT photo FROM DL27Login WHERE username=?";
        try (Connection c = conn(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getBytes(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}