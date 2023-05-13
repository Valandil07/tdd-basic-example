package pt.ipp.isep.dei.examples.tdd.basic.domain;

import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BookmarkTest {
    @Test
    public void createBookmarkCreatedBookmark() throws MalformedURLException {
        Bookmark bookmark = new Bookmark(new URL("https://www.orf.at/"));
    }

    @Test
    public void invalidURLThrowsException(){
        assertThrows(MalformedURLException.class, () -> new Bookmark(new URL("xxx")));
    }

    @Test
    public void addTagToBookmark() throws MalformedURLException {
        // Arrange
        Bookmark bookmark = new Bookmark(new URL("https://www.orf.at/"));
        // Act & Assert
        bookmark.addTag("News");
    }

    @Test
    public void checkIfTwoTagsAreAddedToBookmark() throws MalformedURLException {
        // Arrange
        int expected = 2;
        Bookmark bookmark = new Bookmark(new URL("https://www.orf.at/"));
        bookmark.addTag("News");
        bookmark.addTag("Sports");

        // Act
        ArrayList<String> taglist = bookmark.getTags();
        int result = taglist.size();

        // Assert
        assertEquals(expected, result);
    }
}
