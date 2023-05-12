package pt.ipp.isep.dei.examples.tdd.basic.domain;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class BookmarkTest {
    @BeforeAll
    public static void classSetUp() {
        //HACK: for demonstration purposes only
        System.out.println(
                "This is a BookmarkTest class method and takes place before any @Test is executed");
    }

    @AfterAll
    public static void classTearDown() {
        //HACK: for demonstration purposes only
        System.out.println(
                "This is a BookmarkTest class method and takes place after all @Test are executed");
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



}
