package mchat;

public interface AuthService {
    boolean authenticate(String username, String password);
    String getDisplayName(String username);
    byte[] getProfileImageBytes(String username);
}