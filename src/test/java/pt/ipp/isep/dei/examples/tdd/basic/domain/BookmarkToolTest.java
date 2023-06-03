package pt.ipp.isep.dei.examples.tdd.basic.domain;
import org.junit.jupiter.api.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BookmarkToolTest {
    @BeforeAll
    public static void classSetUp() {
        //HACK: for demonstration purposes only
        System.out.println(
                "This is a BookmarkToolTest class method and takes place before any @Test is executed");
    }

    @AfterAll
    public static void classTearDown() {
        //HACK: for demonstration purposes only
        System.out.println(
                "This is a BookmarkToolTest class method and takes place after all @Test are executed");
    }

    @BeforeEach
    public void setUp() {
        //HACK: for demonstration purposes only
        System.out.println(
                "\tThis call takes place before each @Test is executed");
    }

    @AfterEach
    public void tearDown() {
        //HACK: for demonstration purposes only
        System.out.println(
                "\tThis call takes place after each @Test is executed");
    }

    @Test
    @Disabled
    public void failingTest() {
        fail("a disabled failing test");
    }

    @Test
    public void initializingBookmarkToolCreatesBookmarkTool(){
        ArrayList<Bookmark> expected = new ArrayList<Bookmark>();

        BookmarkTool bmt = new BookmarkTool();

        List<Bookmark> result = bmt.getBookmarkList();
        assertEquals(result, expected);
    }



    @Test
    public void addBookmarkToBookmarklistAddsBookmarkToList() throws MalformedURLException {
        ArrayList<Bookmark> expected = new ArrayList<Bookmark>();
        Bookmark bm = new Bookmark(new URL("https://www.orf.at/"));
        expected.add(bm);
        BookmarkTool bmt = new BookmarkTool();

        bmt.addBookmark(bm);

        List<Bookmark> result = bmt.getBookmarkList();
        assertEquals(expected, result);
    }
    @Test
    public void addSecondBookmarkToBookmarklist() throws MalformedURLException {
        ArrayList<Bookmark> expected = new ArrayList<Bookmark>();
        Bookmark bm1 = new Bookmark(new URL("https://www.orf.at/"));
        Bookmark bm2 = new Bookmark(new URL("https://www.derstandard.at"));

        expected.add(bm1);
        expected.add(bm2);
        BookmarkTool bmt = new BookmarkTool();

        bmt.addBookmark(bm1);
        bmt.addBookmark(bm2);

        List<Bookmark> result = bmt.getBookmarkList();
        assertEquals(expected, result);
    }

    @Test
    public void checkIfNoDuplicateBookmarksAreSaved() throws MalformedURLException {
        // Arrange
        ArrayList<Bookmark> expected = new ArrayList<Bookmark>();
        Bookmark bm = new Bookmark(new URL("https://www.orf.at/"));
        expected.add(bm);
        BookmarkTool bmt = new BookmarkTool();

        // Act
        bmt.addBookmark(bm);
        bmt.addBookmark(bm);
        List<Bookmark> result = bmt.getBookmarkList();

        // Assert
        assertEquals(expected, result);
        assertEquals(expected.size(), result.size());
    }

    @Test
    public void filterBookmarksByKeywordWithKeywordLengthOfFour() throws MalformedURLException {
        // Arrange
        BookmarkTool bmt = new BookmarkTool();
        Bookmark bm1 = new Bookmark(new URL("https://www.orf.at/"));
        bm1.addTag("News");
        Bookmark bm2 = new Bookmark(new URL("https://www.reddit.com/"));
        bm2.addTag("News");
        bm2.addTag("Social Media");
        Bookmark bm3 = new Bookmark(new URL("https://www.fh-campuswien.ac.at/"));
        bm3.addTag("Education");
        bmt.addBookmark(bm1);
        bmt.addBookmark(bm2);
        bmt.addBookmark(bm3);

        List<Bookmark> result;
        List<String> keywords = new ArrayList<>();
        keywords.add("News");

        ArrayList<Bookmark> expected = new ArrayList<>();
        expected.add(bm1);
        expected.add(bm2);

        // Act
        result = bmt.filterByKeywords(keywords);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void filterBookmarksByKeywordWithKeywordLengthOfThree() throws MalformedURLException {
        // Arrange
        BookmarkTool bmt = new BookmarkTool();
        Bookmark bm1 = new Bookmark(new URL("https://www.orf.at/"));
        bm1.addTag("News");
        Bookmark bm2 = new Bookmark(new URL("https://www.reddit.com/"));
        bm2.addTag("News");
        bm2.addTag("Social Media");
        Bookmark bm3 = new Bookmark(new URL("https://www.fh-campuswien.ac.at/"));
        bm3.addTag("Education");
        bmt.addBookmark(bm1);
        bmt.addBookmark(bm2);
        bmt.addBookmark(bm3);

        List<String> keywords = new ArrayList<>();
        keywords.add("abc");

        // Act & Assert
        assertThrows(IllegalArgumentException.class,
                () -> bmt.filterByKeywords(keywords));
    }

    @Test
    public void filterBookmarksByKeywordWithKeywordLengthOfFive() throws MalformedURLException {
        // Arrange
        BookmarkTool bmt = new BookmarkTool();
        Bookmark bm1 = new Bookmark(new URL("https://www.orf.at/"));
        bm1.addTag("News");
        bm1.addTag("Sport");
        Bookmark bm2 = new Bookmark(new URL("https://www.reddit.com/"));
        bm2.addTag("News");
        bm2.addTag("Social Media");
        Bookmark bm3 = new Bookmark(new URL("https://www.fh-campuswien.ac.at/"));
        bm3.addTag("Education");
        bmt.addBookmark(bm1);
        bmt.addBookmark(bm2);
        bmt.addBookmark(bm3);

        List<Bookmark> result;
        List<String> keywords = new ArrayList<>();
        keywords.add("Sport");

        ArrayList<Bookmark> expected = new ArrayList<>();
        expected.add(bm1);

        // Act
        result = bmt.filterByKeywords(keywords);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void filterBookmarksByTwoValidKeywords() throws MalformedURLException {
        // Arrange
        BookmarkTool bmt = new BookmarkTool();
        Bookmark bm1 = new Bookmark(new URL("https://www.orf.at/"));
        bm1.addTag("News");
        bm1.addTag("Sport");
        Bookmark bm2 = new Bookmark(new URL("https://www.reddit.com/"));
        bm2.addTag("News");
        bm2.addTag("Social Media");
        Bookmark bm3 = new Bookmark(new URL("https://www.fh-campuswien.ac.at/"));
        bm3.addTag("Education");
        bmt.addBookmark(bm1);
        bmt.addBookmark(bm2);
        bmt.addBookmark(bm3);

        List<Bookmark> result;
        List<String> keywords = new ArrayList<>();
        keywords.add("Social Media");
        keywords.add("News");

        ArrayList<Bookmark> expected = new ArrayList<>();
        expected.add(bm2);

        // Act
        result = bmt.filterByKeywords(keywords);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void filterBookmarksByTwoValidKeywordsAndOneInvalidKeyword() throws MalformedURLException {
        // Arrange
        BookmarkTool bmt = new BookmarkTool();
        Bookmark bm1 = new Bookmark(new URL("https://www.orf.at/"));
        bm1.addTag("News");
        Bookmark bm2 = new Bookmark(new URL("https://www.reddit.com/"));
        bm2.addTag("News");
        bm2.addTag("Social Media");
        Bookmark bm3 = new Bookmark(new URL("https://www.fh-campuswien.ac.at/"));
        bm3.addTag("Education");
        bmt.addBookmark(bm1);
        bmt.addBookmark(bm2);
        bmt.addBookmark(bm3);

        List<String> keywords = new ArrayList<>();
        keywords.add("Social Media");
        keywords.add("abc");
        keywords.add("News");

        // Act & Assert
        assertThrows(IllegalArgumentException.class,
                () -> bmt.filterByKeywords(keywords));
    }

    @Test
    public void filterBookmarksByEmptyKeywordList() throws MalformedURLException {
        // Arrange
        BookmarkTool bmt = new BookmarkTool();
        Bookmark bm1 = new Bookmark(new URL("https://www.orf.at/"));
        bm1.addTag("News");
        Bookmark bm2 = new Bookmark(new URL("https://www.reddit.com/"));
        bm2.addTag("News");
        bm2.addTag("Social Media");
        Bookmark bm3 = new Bookmark(new URL("https://www.fh-campuswien.ac.at/"));
        bm3.addTag("Education");
        bmt.addBookmark(bm1);
        bmt.addBookmark(bm2);
        bmt.addBookmark(bm3);

        List<Bookmark> result;
        List<String> keywords = new ArrayList<>();

        ArrayList<Bookmark> expected = new ArrayList<>();
        expected.add(bm1);
        expected.add(bm2);
        expected.add(bm3);

        // Act
        result = bmt.filterByKeywords(keywords);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void filterBookmarksByMoreKeywordsThanTagsSet() throws MalformedURLException {
        // Arrange
        BookmarkTool bmt = new BookmarkTool();
        Bookmark bm1 = new Bookmark(new URL("https://www.orf.at/"));
        bm1.addTag("News");
        Bookmark bm2 = new Bookmark(new URL("https://www.reddit.com/"));
        bm2.addTag("News");
        bm2.addTag("Social Media");
        Bookmark bm3 = new Bookmark(new URL("https://www.fh-campuswien.ac.at/"));
        bm3.addTag("Education");
        bmt.addBookmark(bm1);
        bmt.addBookmark(bm2);
        bmt.addBookmark(bm3);

        List<Bookmark> result;
        List<String> keywords = new ArrayList<>();
        keywords.add("Social Media");
        keywords.add("Education");
        keywords.add("News");

        List<Object> expected = Collections.emptyList();

        // Act
        result = bmt.filterByKeywords(keywords);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void removeOneBookmarkFromBookmarkTool() throws MalformedURLException {
        // Arrange
        BookmarkTool bmt = new BookmarkTool();
        Bookmark bm1 = new Bookmark(new URL("https://www.orf.at/"));
        bmt.addBookmark(bm1);
        List<Bookmark> expected = bmt.getBookmarkList();

        // Act
        bmt.removeBookmark(bm1);
        List<Bookmark> result = bmt.getBookmarkList();

        // Assert
        assertEquals(expected,result);

    }

    @Test
    public void removeTwoBooksmarksFromBookmarkTool () throws  MalformedURLException {
        // Arrange
        BookmarkTool bmt = new BookmarkTool();
        Bookmark bm1 = new Bookmark(new URL("https://www.orf.at/"));
        Bookmark bm2 = new Bookmark(new URL("https://www.oe24.at/"));
        Bookmark bm3 = new Bookmark(new URL("https://www.derstandard.at/"));
        bmt.addBookmark(bm1);
        List<Bookmark> expected = bmt.getBookmarkList();

        bmt.addBookmark(bm2);
        bmt.addBookmark(bm3);


        // Act
        bmt.removeBookmark(bm2);
        bmt.removeBookmark(bm3);
        List<Bookmark> result = bmt.getBookmarkList();

        // Assert
        assertEquals(expected,result);

    }
}
