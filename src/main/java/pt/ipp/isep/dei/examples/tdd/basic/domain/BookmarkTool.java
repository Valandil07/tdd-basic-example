package pt.ipp.isep.dei.examples.tdd.basic.domain;

import java.util.ArrayList;

public class BookmarkTool {
    private ArrayList<Bookmark> bookmarklist;
    public BookmarkTool() {
        bookmarklist = new ArrayList<Bookmark>();
    }

    public ArrayList<Bookmark> getBookmarkList() {
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
}
