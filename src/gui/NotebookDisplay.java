package gui;

import model.Notebook;
import model.Page;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NotebookDisplay extends GUIPanel implements ListSelectionListener, ActionListener {
    private DefaultListModel listModel;
    private JList jlist;
    private PageEditorInNoteBook editorPanel;
    private JButton removeButton;

    public NotebookDisplay(Thinkery thinkery) {
        super(thinkery);
        editorPanel = new PageEditorInNoteBook(thinkery);

        makeSplitPane();
    }

    private void makeSplitPane() {
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, makeList(), editorPanel.panel);
        splitPane.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        panel.add(splitPane);
    }

    private JPanel makeList() {
        JPanel listPanel = new JPanel();
        listModel = new DefaultListModel();
        jlist = new JList(listModel);
        jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jlist.setSelectedIndex(0);
        jlist.addListSelectionListener(this);
        JScrollPane scrollPane = new JScrollPane(jlist);
        scrollPane.setPreferredSize(new Dimension(100, HEIGHT-50));
        listPanel.setMinimumSize(new Dimension(100, HEIGHT));
        listPanel.setBackground(Color.white);

        listPanel.add(scrollPane);
        listPanel.add(makeRemoveButton());
        return listPanel;
    }

    private JButton makeRemoveButton() {
        removeButton = new JButton("Remove");
        removeButton.setActionCommand("remove");
        removeButton.addActionListener(this);
        removeButton.setEnabled(false);
        return removeButton;
    }


    public void updateList(Notebook notebook) {

        if (!notebook.isEmpty()) {
            listModel.clear();
            for (Page p : notebook) {
                String text = p.getText();
                listModel.addElement(text.substring(0, Math.min(text.length(), 6)) + "...");
            }
        } else {
            listModel.clear();
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int index = jlist.getSelectedIndex();
        if (!e.getValueIsAdjusting()) {
            if (index == -1) {
                removeButton.setEnabled(false);
                editorPanel.saveButton.setEnabled(false);
            }
            removeButton.setEnabled(true);
            editorPanel.saveButton.setEnabled(true);
        } else {
            editorPanel.updatePanel(thinkery.notebook.getAtIndex(index));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("remove")) {
            int index = jlist.getSelectedIndex();
            listModel.remove(index);
            thinkery.notebook.removeAtIndex(index);
            thinkery.dataHandler.saveNotebook();
            int size = listModel.getSize();

            if (size == 0) {
                removeButton.setEnabled(false);
                editorPanel.updatePanel(new Page());
            } else {
                if (index == listModel.getSize()) {
                    index--;
                    editorPanel.updatePanel(thinkery.notebook.getAtIndex(index));
                }
            }

            jlist.setSelectedIndex(index);
            jlist.ensureIndexIsVisible(index);
        }
    }
}
