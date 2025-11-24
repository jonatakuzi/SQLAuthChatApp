package mchat;

import java.awt.*;
import java.util.ArrayList;

public class FormLayout implements LayoutManager {
    private int hGap = 8, vGap = 8;
    private int[] colWidths = {120, 220};

    public void setColumnWidths(int label, int field) {
        colWidths = new int[]{label, field};
    }

    @Override public void addLayoutComponent(String name, Component comp) {}
    @Override public void removeLayoutComponent(Component comp) {}

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        int count = parent.getComponentCount();
        int rows = (int) Math.ceil(count / 2.0);
        return new Dimension(colWidths[0] + colWidths[1] + hGap * 3, vGap + rows * (28 + vGap));
    }

    @Override public Dimension minimumLayoutSize(Container parent) { return preferredLayoutSize(parent); }

    @Override
    public void layoutContainer(Container parent) {
        Insets in = parent.getInsets();
        int x = in.left + hGap, y = in.top + vGap, row = 0;
        ArrayList<Component> comps = new ArrayList<>();
        for (Component c : parent.getComponents()) comps.add(c);
        for (int i = 0; i < comps.size(); i += 2) {
            Component l = comps.get(i);
            Component f = (i + 1 < comps.size()) ? comps.get(i + 1) : null;
            int rowY = y + row * (28 + vGap);
            if (l != null) l.setBounds(x, rowY, colWidths[0], 28);
            if (f != null) f.setBounds(x + colWidths[0] + hGap, rowY, colWidths[1], 28);
            row++;
        }
    }
}