package mchat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MChatFrame extends JFrame {

    private final JPanel chatPanel = new JPanel();
    private final JScrollPane scroll;
    private final JTextField input = new JTextField();
    private final JButton send = new JButton("Send");
    private final JButton refresh;
    private final ImageIcon avatar;   // current user (Luigi)
    private final String username;    // current username (guest)

    public MChatFrame(String username, ImageIcon avatar) {
        super("MChat");
        this.avatar = avatar;
        this.username = username;

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(420, 680);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // ==== CHAT AREA ====
        chatPanel.setLayout(new BoxLayout(chatPanel, BoxLayout.Y_AXIS));
        scroll = new JScrollPane(chatPanel);
        // hide vertical scrollbar like example
        scroll.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
        add(scroll, BorderLayout.CENTER);

        // ==== CONTROL PANEL (absolute layout) ====
        JPanel control = new JPanel(null);
        control.setPreferredSize(new Dimension(420, 60));

        input.setBounds(10, 10, 260, 40);
        send.setBounds(280, 10, 80, 40);

        refresh = new JButton(
                ImageUtil.iconFromResource("/images/refresh.png", 40, 40)
        );
        refresh.setBounds(365, 10, 40, 40);

        control.add(input);
        control.add(send);
        control.add(refresh);
        add(control, BorderLayout.SOUTH);

        // ==== LOAD OTHER AVATARS ====
        ImageIcon questionIcon = ImageUtil.iconFromResource("/images/bowser.png", 50, 50); // use whatever
        ImageIcon bowserIcon   = ImageUtil.iconFromResource("/images/bowser.png", 50, 50);
        ImageIcon yoshiIcon    = ImageUtil.iconFromResource("/images/yoshi.jpg", 50, 50);
        ImageIcon marioIcon    = ImageUtil.iconFromResource("/images/mario.jpg", 50, 50);

        // ==== SAMPLE MESSAGES TO MATCH EXAMPLE ====
        addMessageRight(avatar, username, "Sounds good...");

        addMessageLeft(questionIcon, "Guest-10",
                "A Chn123 database was created on the AWS (SQL Server) in an IST 220 " +
                        "class, which was populated with data of lessons, characters, and " +
                        "character composition info.");

        addMessageRight(avatar, username,
                "This method changes layout-related information, and therefore,");

        addMessageLeft(bowserIcon, "Guest-5",
                "Adds the specified component to this container.\n" +
                        "* This is a convenience method for {@link ...}");

        addMessageLeft(yoshiIcon, "Guest-3",
                "This method changes layout-related information, and therefore, " +
                        "invalidates the component hierarchy. If the container has already been");

        addMessageLeft(marioIcon, "Guest-0",
                "To make both the databank class and the new DAO class both capable of " +
                        "providing the data, an interface is created, which requires three methods " +
                        "to get data of lessons, characters, and character composition from whichever source.");

        addMessageRight(avatar, username, "That's it!");

        // ==== WIRE UP INPUT ====
        send.addActionListener(this::sendMessage);
        input.addActionListener(this::sendMessage);
        refresh.addActionListener(e -> scrollDown());
    }

    // public helper used for user-sent messages
    private void addMessageRight(ImageIcon avatarIcon, String name, String text) {
        addMessage(avatarIcon, name, text, true);
    }

    private void addMessageLeft(ImageIcon avatarIcon, String name, String text) {
        addMessage(avatarIcon, name, text, false);
    }

    private void addMessage(ImageIcon avatarIcon, String name, String text, boolean right) {
        MessageBubble bubble = new MessageBubble(avatarIcon, name, text, 380, right);
        chatPanel.add(bubble);
        chatPanel.add(Box.createVerticalStrut(8));
        chatPanel.revalidate();
        chatPanel.repaint();
        scrollDown();
    }

    private void sendMessage(ActionEvent e) {
        String msg = input.getText().trim();
        if (msg.isEmpty()) return;
        // user messages go on the right using current avatar + username
        addMessageRight(avatar, username, msg);
        input.setText("");
    }

    private void scrollDown() {
        SwingUtilities.invokeLater(() -> {
            JScrollBar bar = scroll.getVerticalScrollBar();
            bar.setValue(bar.getMaximum());
        });
    }
}