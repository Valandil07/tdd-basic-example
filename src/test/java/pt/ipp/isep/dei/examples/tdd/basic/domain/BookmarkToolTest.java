package pt.ipp.isep.dei.examples.tdd.basic.domain;
import org.junit.jupiter.api.*;

import java.awt.print.Book;
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
        ArrayList expected = new ArrayList();

        BookmarkTool bmt = new BookmarkTool();

        ArrayList result = bmt.getBookmarkList();
        assertEquals(result, expected);
    }

    @Test
    public void createBookmarkCreatedBookmark(){
        Bookmark bookmark = new Bookmark("https://www.orf.at/");
        }

    @Test
    public void addBookmarkToBookmarklistAddsBookmarkToList(){
        ArrayList expected = new ArrayList();
        expected.add(new Bookmark("https://www.orf.at/"));
        BookmarkTool bmt = new BookmarkTool();

        bmt.addBookmark(new Bookmark("https://www.orf.at/"));

        ArrayList result = bmt.getBookmarkList();
        assertEquals(expected, result);
    }
}
