package gui;

import model.Page;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PageEditorInNoteBook extends PageEditorPanel {

    public PageEditorInNoteBook(Thinkery thinkery) {
        super(thinkery);
    }

    private void setPage(Page p) {
        this.page = p;
    }


    public void updatePanel(Page p) {
        setPage(p);
        topicLabel.setText("Topic: " + p.prompt.topic);
        promptLabel.setText("<html>Prompt: " + p.prompt.question + "</html>");
        textPane.setText(p.getText());
    }

    @Override
    protected void makeTextBox() {
        textPane = new JTextPane();
        textPane.setCaretPosition(0);
        textPane.setMargin(new Insets(5,5,5,5));
        textPane.setFont(new Font("Helvetica", Font.PLAIN, 12));

        JScrollPane scrollPane = new JScrollPane(textPane);
        scrollPane.setPreferredSize(new Dimension(WIDTH-100, HEIGHT-200));

        panel.add(scrollPane);
    }

    @Override
    protected void makeButtons() {
        backButton = new JButton("Back");
        backButton.setActionCommand("back from notebook");
        backButton.addActionListener(this);
        panel.add(backButton);

        saveButton = new JButton("Save");
        saveButton.setActionCommand("save from notebook");
        saveButton.addActionListener(this);
        saveButton.setEnabled(false);
        panel.add(saveButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "back from notebook":
                setChanged();
                notifyObservers("back from notebook");
                break;

            case "save from notebook":
                page.setText(textPane.getText());
                thinkery.dataHandler.saveNotebook();
                break;
        }
    }
}
