package pt.ipp.isep.dei.examples.tdd.basic.domain;

import java.net.URL;
import java.util.ArrayList;

public class Bookmark {
    private URL url;
    private ArrayList<String> tags;

    public Bookmark(URL url) {
        this.url = url;
        tags = new ArrayList<String>();
    }

    public void addTag(String tag) {
        tags.add(tag);
    }

    public ArrayList<String> getTags() {
        return tags;
    }
}
