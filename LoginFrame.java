package mchat;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

    private final JTextField userField = new JTextField();
    private final JPasswordField passField = new JPasswordField();
    private final JButton loginBtn = new JButton("Login");
    private final AuthService auth;

    // Use resource-based icon
    private final ImageIcon fallbackAvatar =
            ImageUtil.iconFromResource("/images/luigi.png", 50, 50);

    public LoginFrame(AuthService auth) {
        super("Login – Workshop 6");
        this.auth = auth;

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(420, 220);
        setLocationRelativeTo(null);

        JPanel form = new JPanel(new FormLayout());
        ((FormLayout) form.getLayout()).setColumnWidths(120, 220);

        form.add(new JLabel("Username:"));
        form.add(userField);
        form.add(new JLabel("Password:"));
        form.add(passField);
        form.add(new JLabel(""));
        form.add(loginBtn);

        add(form);

        loginBtn.addActionListener(this::attemptLogin);
        getRootPane().setDefaultButton(loginBtn);
    }

    private void attemptLogin(ActionEvent e) {
        String u = userField.getText().trim();
        String p = new String(passField.getPassword());

        if (!auth.authenticate(u, p)) {
            JOptionPane.showMessageDialog(this,
                    "Invalid credentials",
                    "Login Failed",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        String display = auth.getDisplayName(u);

        // try DB image first, then fallback
        ImageIcon avatar = ImageUtil.iconFromBytes(auth.getProfileImageBytes(u), 50, 50);
        if (avatar == null || avatar.getIconWidth() <= 1) {
            avatar = fallbackAvatar;
        }

        new MChatFrame(display, avatar).setVisible(true);
        dispose();
    }
}