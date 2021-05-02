package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBar extends JMenuBar implements ActionListener {

    public MenuBar() {
        super();
        makeFileMenu();
    }

    public void makeFileMenu() {
        JMenu menu = new JMenu("File");
        this.add(menu);

        JMenuItem saveOption = new JMenuItem("Save");
        menu.add(saveOption);
        saveOption.addActionListener(this);
        saveOption.setActionCommand("save");

        JMenuItem loadOption = new JMenuItem("Load");
        menu.add(loadOption);
        loadOption.addActionListener(this);
        loadOption.setActionCommand("load");
    }



    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
