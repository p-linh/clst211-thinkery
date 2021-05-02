package gui;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;

public abstract class GUIPanel extends Observable {
    protected static final int WIDTH = Thinkery.WIDTH - 100;
    protected static final int HEIGHT = Thinkery.HEIGHT - 100;
    protected JPanel panel;
    protected Thinkery thinkery;

    public GUIPanel(Thinkery thinkery) {
        this.thinkery = thinkery;
        panel = new JPanel();
        panel.setBackground(Color.white);
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        addObserver(new PanelDisplayer(thinkery));
    }

    public void setVisible(boolean visible) {
        panel.setVisible(visible);
    }
}
