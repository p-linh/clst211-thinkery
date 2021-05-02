package gui;

import model.Prompt;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class PanelDisplayer implements Observer {
    private Thinkery thinkery;

    public PanelDisplayer (Thinkery thinkery) {
        this.thinkery = thinkery;

    }
    @Override
    public void update(Observable o, Object arg) {

        switch ((String) arg) {
            case "custom":
                String input;
                try {
                    input = customPromptInput();
                } catch (NullPointerException e) {
                    return;
                }
                Prompt customPrompt = new Prompt("Custom Topic", input);
                setPanelsForPromptSelection(customPrompt);
                break;

            case "apology":
                String apologyQuestion = randomizePrompt(Prompt.apologyPrompts);
                Prompt apologyPrompt = new Prompt("Apology", apologyQuestion);
                setPanelsForPromptSelection(apologyPrompt);
                break;

            case "symposium":
//                String symposiumQuestion = Prompt.symposiumPrompts[1];
                String symposiumQuestion = randomizePrompt(Prompt.symposiumPrompts);
                Prompt symposiumPrompt = new Prompt("Symposium", symposiumQuestion);
                setPanelsForPromptSelection(symposiumPrompt);
                break;

            case "phaedrus":
                String phaedrusQuestion = randomizePrompt(Prompt.phaedrusPrompts);
                Prompt phaedrusPrompt = new Prompt("Phaedrus", phaedrusQuestion);
                setPanelsForPromptSelection(phaedrusPrompt);
                break;

            case "republic24":
                String republic24Question = randomizePrompt(Prompt.republic24Prompts);
                Prompt republic24Prompt = new Prompt("Republic 2-4", republic24Question);
                setPanelsForPromptSelection(republic24Prompt);
                break;

            case "republic57":
                String republic57Question = randomizePrompt(Prompt.republic57Prompts);
                Prompt republic57Prompt = new Prompt("Republic 5-7", republic57Question);
                setPanelsForPromptSelection(republic57Prompt);
                break;

            case "view":
                thinkery.mainMenu.setVisible(false);
                thinkery.notebookDisplay.setVisible(true);
                break;

            case "back":
                GUIPanel panel = (GUIPanel) o;
                panel.setVisible(false);
                thinkery.mainMenu.setVisible(true);
                break;

            case "back from notebook":
                thinkery.notebookDisplay.setVisible(false);
                thinkery.mainMenu.setVisible(true);
                break;

            case "begin from start screen":
                thinkery.startScreen.setVisible(false);
                thinkery.mainMenu.setVisible(true);
                break;

        }
    }

    private String customPromptInput() {
        String input = JOptionPane.showInputDialog(thinkery.mainMenu.panel, "Please enter a prompt you'd like to explore");
        if (input == null || input.equals("")) {
            throw new NullPointerException();
        }
        return input;
    }

    private String randomizePrompt(String prompts[]) {
        final Random random = new Random();
        int index = random.nextInt(prompts.length);
        String question = prompts[index];
        JOptionPane.showMessageDialog(thinkery.mainMenu.panel, "Your Prompt is: " + question);
        return question;
    }

    private void setPanelsForPromptSelection(Prompt prompt) {
        thinkery.pageEditorPanel.setPrompt(prompt);
        thinkery.mainMenu.setVisible(false);
        thinkery.pageEditorPanel.setVisible(true);
    }
}
