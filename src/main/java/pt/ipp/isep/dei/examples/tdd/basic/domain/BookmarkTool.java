package pt.ipp.isep.dei.examples.tdd.basic.domain;

import java.util.ArrayList;

public class BookmarkTool {
    private ArrayList bookmarklist;
    public BookmarkTool() {
        bookmarklist = new ArrayList();
    }

    public ArrayList getBookmarkList() {
        return bookmarklist;
    }

    public void addBookmark(Bookmark bookmark) {
        bookmarklist.add(bookmark);
    }
}
