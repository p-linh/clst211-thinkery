package persistence;

import model.Notebook;
import model.Page;
import model.Prompt;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    public Notebook read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseNotebook(jsonObject);
    }



    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    private Notebook parseNotebook(JSONObject jsonObject) {
        Notebook notebook = new Notebook();
        parsePages(notebook, jsonObject.getJSONArray("pages"));
        return notebook;
    }

    private void parsePages(Notebook notebook, JSONArray jsonArray) {
        for (Object json : jsonArray) {
            JSONObject nextPage = (JSONObject) json;
            notebook.addPage(parsePage(nextPage));
        }
    }

    // EFFECTS: parses page from JSON object and returns it
    private Page parsePage(JSONObject jsonObject) {
        Page p = new Page();
        String text = jsonObject.getString("text");
        Prompt prompt = parsePrompt(jsonObject.getJSONObject("prompt"));
        p.setText(text);
        p.setPrompt(prompt);
        return p;
    }

    private Prompt parsePrompt(JSONObject jsonObject) {
        String topic = jsonObject.getString("topic");
        String question = jsonObject.getString("question");
        Prompt prompt = new Prompt(topic, question);
        return prompt;
    }


}
