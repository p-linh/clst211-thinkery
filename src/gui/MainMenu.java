package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends GUIPanel implements ActionListener {


    public MainMenu(Thinkery thinkery) {
        super(thinkery);
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        makeLabel();
        makeButtons();
    }

    private void makeLabel() {
        JLabel welcomeLabel = new JLabel("Select a topic to take notes on or create your own.");
        welcomeLabel.setFont(new Font("Helvetica", Font.PLAIN, 24));
        panel.add(welcomeLabel);

        JLabel plato = new JLabel("Topics on Plato");
        plato.setFont(new Font("Helvetica", Font.BOLD, 16));
        panel.add(plato);
        panel.add(Box.createVerticalGlue());

    }

    private void makeButtons() {
        Dimension buttonSize = new Dimension(300, 20);
        Font font = new Font("Helvetica", Font.ITALIC, 14);

        JButton apology = new JButton("The Apology");
        apology.setFont(font);
        apology.setActionCommand("apology");
        apology.addActionListener(this);
        apology.setMaximumSize(buttonSize);
        panel.add(apology);
        panel.add(Box.createVerticalGlue());

        JButton symposium = new JButton("The Symposium");
        symposium.setFont(font);
        symposium.setActionCommand("symposium");
        symposium.addActionListener(this);
        symposium.setMaximumSize(buttonSize);
        panel.add(symposium);
        panel.add(Box.createVerticalGlue());

        JButton phaedrus = new JButton("The Phaedrus");
        phaedrus.setFont(font);
        phaedrus.setActionCommand("phaedrus");
        phaedrus.addActionListener(this);
        phaedrus.setMaximumSize(buttonSize);
        panel.add(phaedrus);
        panel.add(Box.createVerticalGlue());

        JButton republic24 = new JButton("The Republic, Books 2-4");
        republic24.setFont(font);
        republic24.setActionCommand("republic24");
        republic24.addActionListener(this);
        republic24.setMaximumSize(buttonSize);
        panel.add(republic24);
        panel.add(Box.createVerticalGlue());

        JButton republic57 = new JButton("The Republic, Books 5-7");
        republic57.setFont(font);
        republic57.setActionCommand("republic57");
        republic57.addActionListener(this);
        republic57.setMaximumSize(buttonSize);
        panel.add(republic57);
        panel.add(Box.createVerticalGlue());

        JButton custom = new JButton("Custom Topic");
        custom.setFont(font);
        custom.setActionCommand("custom");
        custom.addActionListener(this);
        custom.setMaximumSize(buttonSize);
        panel.add(custom);
        panel.add(Box.createVerticalGlue());

        JButton viewNotebook = new JButton("View Notes");
        viewNotebook.setFont(font);
        viewNotebook.setActionCommand("view");
        viewNotebook.addActionListener(this);
        viewNotebook.setMaximumSize(buttonSize);
        panel.add(viewNotebook);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setChanged();
        notifyObservers(e.getActionCommand());
    }
}
