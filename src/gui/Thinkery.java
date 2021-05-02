package gui;

import model.Notebook;

import javax.swing.*;
import java.awt.*;

public class Thinkery {
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 700;
    private JFrame frame;
    private JPanel mainPanel;
    Notebook notebook;
    MainMenu mainMenu;
    PageEditorPanel pageEditorPanel;
    NotebookDisplay notebookDisplay;
    StartScreen startScreen;
    DataHandler dataHandler;

    public Thinkery() {
        setUpWindow();
        notebook = new Notebook();
        addPanelsToFrame();
        dataHandler = new DataHandler(this);
        dataHandler.loadNotebook();
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }

    private void setUpWindow() {
        frame = new JFrame("The Thinkery");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

//        MenuBar menuBar = new MenuBar();
//        frame.setJMenuBar(menuBar);

        mainPanel = new JPanel();
        mainPanel.setBackground(Color.white);
    }

    private void addPanelsToFrame() {
        mainMenu = new MainMenu(this);
        addPanel(mainMenu.panel);

        pageEditorPanel = new PageEditorPanel(this);
        addPanel(pageEditorPanel.panel);

        notebookDisplay = new NotebookDisplay(this);
        addPanel(notebookDisplay.panel);

        startScreen = new StartScreen(this);
        addPanel(startScreen.panel);
        startScreen.panel.setVisible(true);
    }

    public void addPanel(JPanel panel) {
        frame.setContentPane(mainPanel);
        mainPanel.add(panel);
        panel.setVisible(false);
        mainPanel.repaint();
        mainPanel.revalidate();
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Thinkery();
            }
        });
    }
}
