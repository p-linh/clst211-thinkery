package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Notebook implements Writable, Iterable<Page> {
    private List<Page> pages;

    public Notebook() {
        pages = new ArrayList<>();
    }

    public void addPage(Page page) {
        pages.add(page);
    }

    public boolean isEmpty() {
        return pages.isEmpty();
    }

    public int size() {
        return pages.size();
    }

    public void removeAtIndex(int index) {
        pages.remove(index);
    }

    public Page getAtIndex(int index) { return pages.get(index);}

    @Override
    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("pages", pagesToJson());
        return jsonObject;
    }

    private JSONArray pagesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Page page : pages) {
            jsonArray.put(page.toJson());
        }

        return jsonArray;
    }

    @Override
    public Iterator<Page> iterator() {
        return pages.iterator();
    }
}
