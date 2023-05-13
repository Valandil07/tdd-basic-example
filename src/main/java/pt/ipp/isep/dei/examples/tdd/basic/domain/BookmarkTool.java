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
        bookmarklist.add(bookmark);
        System.out.println("Test for Webhook");
    }
}
