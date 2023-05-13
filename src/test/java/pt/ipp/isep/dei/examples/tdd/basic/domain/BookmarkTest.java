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
        String tag1 = "News";
        String tag2 = "Sports";
        int expected = 2;
        ArrayList<String> expected2 = new ArrayList<>();
        expected2.add(tag1);
        expected2.add(tag2);
        Bookmark bookmark = new Bookmark(new URL("https://www.orf.at/"));
        bookmark.addTag(tag1);
        bookmark.addTag(tag2);

        // Act
        ArrayList<String> taglist = bookmark.getTags();
        int result = taglist.size();

        // Assert
        assertEquals(expected, result);
        assertEquals(expected2, taglist);
    }

    @Test
    public void checkIfTagShorterThan4CharactersThrowsException() throws MalformedURLException {
        // Arrange
        Bookmark bookmark = new Bookmark(new URL("https://www.orf.at/"));

        // Act & Assert
        assertThrows(IllegalArgumentException.class,
                () -> bookmark.addTag("Web"));
    }

    @Test
    public void ensureDuplicateBookmarkIncreasesRating() throws MalformedURLException {
        // Arrange
        int expected = 1;
        BookmarkTool bmt = new BookmarkTool();
        Bookmark bm = new Bookmark(new URL("https://www.orf.at/"));
        bmt.addBookmark(bm);

        // Act
        bmt.addBookmark(bm);
        int result = bmt.getBookmarkList().get(0).getRating();

        // Assert
        assertEquals(expected, result);
    }
}
