package model;

import org.json.JSONObject;
import persistence.Writable;

import java.time.LocalDate;

// represents a page in a notebook
public class Page implements Writable {
    private String text;
    public Prompt prompt;

    public Page() {
        text = "";
        this.prompt = new Prompt("","");
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setPrompt(Prompt prompt) {
        this.prompt = prompt;
    }

    @Override
    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("text", text);
        jsonObject.put("prompt", prompt.toJson());
        return jsonObject;
    }
}
