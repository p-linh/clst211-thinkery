package gui;

import model.Notebook;
import model.Page;
import model.Prompt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PageEditorPanel extends GUIPanel implements ActionListener {
    protected JTextPane textPane;
    protected Page page;
//    public Notebook notebook;

    protected JLabel topicLabel;
    protected JLabel promptLabel;
    protected JButton backButton;
    protected JButton saveButton;

    public PageEditorPanel(Thinkery thinkery) {
        super(thinkery);
//        panel.setLayout(new BorderLayout());
//        notebook = new Notebook();
//        this.notebook = thinkery.notebook;

        page = new Page();
        makePromptLabel();
        makeTextBox();
        makeButtons();
    }

    protected void makeButtons() {
        backButton = new JButton("Back");
        backButton.setActionCommand("back");
        backButton.addActionListener(this);
        panel.add(backButton);

        saveButton = new JButton("Save");
        saveButton.setActionCommand("save");
        saveButton.addActionListener(this);
        panel.add(saveButton);
    }

    private void makePromptLabel() {
        Font font = new Font("Helvetica", Font.BOLD, 16);

        topicLabel = new JLabel();
        topicLabel.setFont(font);
        topicLabel.setPreferredSize(new Dimension(WIDTH-200, 20));
        panel.add(topicLabel);

        promptLabel = new JLabel();
        promptLabel.setFont(font);
        promptLabel.setPreferredSize(new Dimension(WIDTH-200, 75));
        panel.add(promptLabel);
    }

    public void setPrompt(Prompt prompt) {
        page.setPrompt(prompt);
        updatePanel();
    }

    public void updatePanel() {
        topicLabel.setText("Topic: " + page.prompt.topic);
        promptLabel.setText("<html>Prompt: " + page.prompt.question + "</html>");
        textPane.setText("");
    }

    protected void makeTextBox() {
        textPane = new JTextPane();
        textPane.setCaretPosition(0);
        textPane.setMargin(new Insets(5,5,5,5));
        textPane.setFont(new Font("Helvetica", Font.PLAIN, 12));

        JScrollPane scrollPane = new JScrollPane(textPane);
        scrollPane.setPreferredSize(new Dimension(WIDTH, HEIGHT-200));

       panel.add(scrollPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "back":
                setChanged();
                notifyObservers(e.getActionCommand());
                break;

            case "save":
                page.setText(textPane.getText());
                thinkery.notebook.addPage(page);
                page = new Page();
                thinkery.dataHandler.saveNotebook();
                break;
        }
    }
}
