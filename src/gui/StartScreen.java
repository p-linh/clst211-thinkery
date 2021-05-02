package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartScreen extends GUIPanel implements ActionListener {
    private ImageIcon thinkeryImage;

    public StartScreen(Thinkery thinkery) {
        super(thinkery);
        LayoutManager boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(boxLayout);
        makeLabel();
        loadImage();
        makeButton();
    }

    private void loadImage() {
        String sep = System.getProperty("file.separator");
        thinkeryImage = new ImageIcon(System.getProperty("user.dir")
                + sep + "resources" + sep + "Socrates_in_a_basket.jpg");

        JLabel image = new JLabel(thinkeryImage);
        image.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(image);
        panel.add(Box.createVerticalGlue());
    }

    private void makeButton() {
        JButton begin = new JButton("Begin Thinking");
        begin.setFont(new Font("Helvetica", Font.PLAIN, 14));
        begin.setActionCommand("begin");
        begin.addActionListener(this);
        begin.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(begin);
    }

    private void makeLabel() {
        JLabel welcome = new JLabel("Welcome to The Thinkery");
        welcome.setFont(new Font("Times New Roman", Font.BOLD, 24));
        welcome.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(welcome);
        panel.add(Box.createVerticalGlue());
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        setChanged();
        notifyObservers("begin from start screen");
    }
}
