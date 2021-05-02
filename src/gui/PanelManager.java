package gui;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class PanelManager {
    MainMenu mainMenu;
    PageEditorPanel pageEditorPanel;
    Thinkery thinkery;

    public PanelManager(Thinkery thinkery) {
        this.thinkery = thinkery;
        addPanelsToThinkery();
    }

    private void addPanelsToThinkery() {
        mainMenu = new MainMenu(thinkery);
        addPanel(mainMenu.panel);
        mainMenu.setVisible(true);

        pageEditorPanel = new PageEditorPanel(thinkery);
        addPanel(pageEditorPanel.panel);
        pageEditorPanel.setVisible(false);
    }

    public void addPanel(JPanel panel) {
        thinkery.addPanel(panel);
    }


}
