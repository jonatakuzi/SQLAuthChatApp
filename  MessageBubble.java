package mchat;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

class MessageBubble extends JPanel {

    public MessageBubble(ImageIcon avatarIcon, String name, String text,
                         int width, boolean alignRight) {

        setLayout(null);
        setOpaque(false);

        // avatar label
        JLabel avatar = new JLabel(avatarIcon);
        avatar.setSize(50, 50);

        // name label
        JLabel nameLabel = new JLabel(name);
        nameLabel.setFont(nameLabel.getFont().deriveFont(Font.BOLD, 12f));

        // message area
        JTextArea area = new JTextArea(text);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setEditable(false);
        area.setOpaque(true);
        area.setBackground(new Color(180, 255, 180)); // light green
        area.setBorder(new EmptyBorder(6, 10, 6, 10));
        area.setFont(area.getFont().deriveFont(12f));

        int maxTextWidth = width - 110;  // room for avatar & margins

        // first set size so preferred height is computed
        area.setSize(new Dimension(maxTextWidth, Short.MAX_VALUE));
        int textHeight = area.getPreferredSize().height;
        int bubbleHeight = textHeight + 12; // padding

        int bubbleWidth = maxTextWidth;

        int topMargin = 8;

        if (alignRight) {
            // avatar on the right
            int avatarX = width - 10 - 50;
            avatar.setLocation(avatarX, topMargin);

            // bubble ending a bit left of avatar
            int bubbleRight = avatarX - 10;
            int bubbleX = bubbleRight - bubbleWidth;
            area.setBounds(bubbleX, topMargin + 16, bubbleWidth, bubbleHeight);
            nameLabel.setBounds(bubbleX, topMargin, bubbleWidth, 16);
        } else {
            // avatar on the left
            int avatarX = 10;
            avatar.setLocation(avatarX, topMargin);

            int bubbleX = avatarX + 50 + 10;
            area.setBounds(bubbleX, topMargin + 16, bubbleWidth, bubbleHeight);
            nameLabel.setBounds(bubbleX, topMargin, bubbleWidth, 16);
        }

        add(avatar);
        add(nameLabel);
        add(area);

        int totalHeight = topMargin + 16 + bubbleHeight + 8;
        setPreferredSize(new Dimension(width, totalHeight));
    }
}