package pt.ipp.isep.dei.examples.tdd.basic.domain;

import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

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
        List<String> taglist = bookmark.getTags();
        int result = taglist.size();

        // Assert
        assertEquals(expected, result);
        assertEquals(expected2, taglist);
    }

    @Test
    public void TagCheckIfLengthIs3CharactersThrowsException() throws MalformedURLException {
        // Arrange
        Bookmark bookmark = new Bookmark(new URL("https://www.orf.at/"));

        // Act & Assert
        assertThrows(IllegalArgumentException.class,
                () -> bookmark.addTag("123"));
    }
    @Test
    public void TagCheckIfLengthIs4Characters() throws MalformedURLException {
        // Arrange
        Bookmark bookmark = new Bookmark(new URL("https://www.orf.at/"));

        // Act & Assert
        bookmark.addTag("1234");
    }

    @Test
    public void TagCheckIfLengthIs5Characters() throws MalformedURLException {
        // Arrange
        Bookmark bookmark = new Bookmark(new URL("https://www.orf.at/"));

        // Act & Assert
        bookmark.addTag("12345");
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

    @Test
    public void BookmarkEqualsReturnFalseWrongObjectType() throws MalformedURLException {
        // Arrange
        boolean expected = false;
        String wrongtype = "Test";
        Bookmark bm = new Bookmark(new URL("https://www.orf.at/"));


        // Act
        boolean result = bm.equals(wrongtype);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void BookmarkEqualsTrue() throws MalformedURLException {
        // Arrange
        boolean expected = true;
        Bookmark bm1 = new Bookmark(new URL("https://www.orf.at/"));
        Bookmark bm2 = new Bookmark(new URL("https://www.orf.at/"));


        // Act
        boolean result = bm1.equals(bm2);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void BookmarkHashCode() throws MalformedURLException, URISyntaxException {
        // Arrange
        URL url = new URL("https://www.orf.at/");
        URI uri = url.toURI();
        Bookmark bm1 = new Bookmark(url);
        int expected = 31 * 7 + (uri == null ? 0 : uri.hashCode());

        // Act
        int result = bm1.hashCode();

        // Assert
        assertEquals(expected, result);
    }

}
