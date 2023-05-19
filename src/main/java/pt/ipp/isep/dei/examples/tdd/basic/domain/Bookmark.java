package pt.ipp.isep.dei.examples.tdd.basic.domain;

import java.net.URL;
import java.util.ArrayList;

public class Bookmark {

    private URL url;
    private ArrayList<String> tags;
    private int rating;

    public Bookmark(URL url) {
        this.url = url;
        tags = new ArrayList<String>();
        this.rating = 0;
    }

    public void addTag(String tag) {
        if(tag.length() < 4){
            throw new IllegalArgumentException("Tag is too short!");
        }
        tags.add(tag);
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public int getRating() {
        return rating;
    }

    public URL getURL() {
        return url;
    }

    public void increaseRating() {
        rating+=1;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Bookmark)) {
            return false;
        }

        Bookmark b = (Bookmark) obj;
        return url.toString().equals(b.getURL().toString());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (url == null ? 0 : url.hashCode());
        return hash;
    }
}
