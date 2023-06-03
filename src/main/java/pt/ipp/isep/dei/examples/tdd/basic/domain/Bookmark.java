package pt.ipp.isep.dei.examples.tdd.basic.domain;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Bookmark {

    private URL url;
    private ArrayList<String> tags;
    private int rating;

    public Bookmark(URL url) {
        this.url = url;
        tags = new ArrayList<>();
        this.rating = 0;
    }

    public void addTag(String tag) {
        if(tag.length() < 4){
            throw new IllegalArgumentException("Tag is too short!");
        }
        tags.add(tag);
    }

    public List<String> getTags() {
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
        URI uri;
        try {
            uri = url.toURI();
        } catch (URISyntaxException e) {
            throw new URLSyntaxRuntimeException(e);
        }
        int hash = 7;
        hash = 31 * hash + uri.hashCode();
        return hash;
    }

    public void removeTag(String tagRemove) {
        String tag_to_remove = null;
        for(String tag : tags){
            if(tagRemove.equals(tag)){
                tag_to_remove = tag;
            }
        }
        if(!tag_to_remove.isEmpty()){
            tags.remove(tag_to_remove);
        }
    }
}
