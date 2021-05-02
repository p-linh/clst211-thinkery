package gui;

import model.Notebook;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;

public class DataHandler {
    private static final String SAVE_LOCATION = "./data/thinkery.json";
    private JsonReader jsonReader;
    private JsonWriter jsonWriter;
    private Thinkery thinkery;

    public DataHandler(Thinkery thinkery) {
        jsonReader = new JsonReader(SAVE_LOCATION);
        jsonWriter = new JsonWriter(SAVE_LOCATION);
        this.thinkery = thinkery;
    }

    public void saveNotebook() {
        try {
            jsonWriter.open();
            jsonWriter.write(thinkery.notebook);
            jsonWriter.close();
            thinkery.notebookDisplay.updateList(thinkery.notebook);
            System.out.println("saved");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public void loadNotebook() {
        try {
            Notebook notebook = jsonReader.read();
            thinkery.setNotebook(notebook);
            thinkery.notebookDisplay.updateList(notebook);
        } catch (IOException e) {
            System.out.println("Could not load");
        }
    }
}
