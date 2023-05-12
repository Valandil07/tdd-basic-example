package pt.ipp.isep.dei.examples.tdd.basic.domain;
import org.junit.jupiter.api.*;

import java.awt.print.Book;
import java.net.MalformedURLException;
import java.util.ArrayList;
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

        ArrayList<Bookmark> result = bmt.getBookmarkList();
        assertEquals(result, expected);
    }

    @Test
    public void createBookmarkCreatedBookmark(){
        Bookmark bookmark = new Bookmark("https://www.orf.at/");
        }

    @Test
    public void addBookmarkToBookmarklistAddsBookmarkToList(){
        ArrayList<Bookmark> expected = new ArrayList<Bookmark>();
        Bookmark bm = new Bookmark("https://www.orf.at/");
        expected.add(bm);
        BookmarkTool bmt = new BookmarkTool();

        bmt.addBookmark(bm);

        ArrayList<Bookmark> result = bmt.getBookmarkList();
        assertEquals(expected, result);
    }
    @Test
    public void addSecondBookmarkToBookmarklist(){
        ArrayList<Bookmark> expected = new ArrayList<Bookmark>();
        Bookmark bm1 = new Bookmark("https://www.orf.at/");
        Bookmark bm2 = new Bookmark("https://www.derstandard.at");

        expected.add(bm1);
        expected.add(bm2);
        BookmarkTool bmt = new BookmarkTool();

        bmt.addBookmark(bm1);
        bmt.addBookmark(bm2);

        ArrayList<Bookmark> result = bmt.getBookmarkList();
        assertEquals(expected, result);
    }

    @Test
    public void invalidURLthrowsException(){
        String url = "xxx";
        assertThrows(MalformedURLException.class, () -> new Bookmark(url));
    }
}
