package mchat;

import javax.swing.*;

class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // >>> USE IN-MEMORY LOGIN FOR NOW <<<
            AuthService auth = new InMemoryAuthService();
            new LoginFrame(auth).setVisible(true);
        });
    }
}