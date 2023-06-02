package pt.ipp.isep.dei.examples.tdd.basic.domain;

import java.util.ArrayList;
import java.util.List;

public class BookmarkTool {
    private ArrayList<Bookmark> bookmarklist;
    public BookmarkTool() {
        bookmarklist = new ArrayList<>();
    }

    public List<Bookmark> getBookmarkList() {
        return bookmarklist;
    }

    public void addBookmark(Bookmark bookmark) {
        boolean duplicate = false;
        for (Bookmark bm:bookmarklist) {
            if(bm.equals(bookmark)){
                bm.increaseRating();
                duplicate = true;
            }
        }
        if (!duplicate){
            bookmarklist.add(bookmark);
        }
    }

    public List<Bookmark> filterByKeyword(String keyword) {
        if(keyword.length() < 4){
            throw new IllegalArgumentException("Keyword is too short!");
        }
        List<String> tags;
        ArrayList<Bookmark> result = new ArrayList<>();

        for (Bookmark bm:bookmarklist) {
            tags = bm.getTags();
            if(tags.contains(keyword)){
                result.add(bm);
            }
        }
        return result;
    }
}
