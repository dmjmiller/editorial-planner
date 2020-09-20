package persistence;

import model.Column;
import model.Feature;
import model.Story;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// SOURCE: I used Teller ReaderTest as a base for the ReaderTest code
public class ReaderTest {

    Story s1 = new Column("Really good story", "Hunter S Thompson", 2000, "Column");
    Story s2 = new Column("Not so good story", "Joe Blow", 1560, "Column");
    Story s3 = new Feature("BEST STORY EVER", "Hunter S Thompson", 1000, "Feature");
    Story s4 = new Feature("BLEH", "Some Guy", 500, "Feature");

    @Test
    void testParseStoryFile1() {
        try {
            List<Story> stories = Reader.readStories(new File("./data/testStory.txt")).getStories();
            Story s1 = stories.get(0);
            assertEquals("Really good story", s1.getTitle());
            assertEquals("Hunter S Thompson", s1.getAuthor());
            assertEquals(2000, s1.getWordCount());

            Story s2 = stories.get(1);
            assertEquals("Not so good story", s2.getTitle());
            assertEquals("Joe Blow", s2.getAuthor());
            assertEquals(1560, s2.getWordCount());
        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }

    @Test

    void testParseStoryFile2() {
        try {
            List<Story> stories = Reader.readStories(new File("./data/testStory.txt")).getStories();
            Story s3 = stories.get(2);
            assertEquals("BEST STORY EVER", s3.getTitle());
            assertEquals("Hunter S Thompson", s3.getAuthor());
            assertEquals(1000, s3.getWordCount());

            Story s4 = stories.get(3);
            assertEquals("BLEH", s4.getTitle());
            assertEquals("Some Guy", s4.getAuthor());
            assertEquals(500, s4.getWordCount());
        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }


    @Test

    void testParseStoryFile3() {
        try {
            List<Story> stories = Reader.readStories(new File("./data/testStory.txt")).getStories();
            Story s1 = stories.get(0);
            assertEquals("Really good story", s1.getTitle());
            assertEquals("Hunter S Thompson", s1.getAuthor());
            assertEquals("Column", s1.getType());
            assertEquals(2000, s1.getWordCount());

            Story s4 = stories.get(3);
            assertEquals("BLEH", s4.getTitle());
            assertEquals("Some Guy", s4.getAuthor());
            assertEquals("Feature", s4.getType());
            assertEquals(500, s4.getWordCount());
        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }
    @Test
    void testIOException() {
        try {
            Reader.readStories(new File("./path/does/not/exist/testStory.txt"));
        } catch (IOException e) {
            //expected
        }
    }

    @Test
    void testGetReader() {
        Reader reader = new Reader();
        assertNotNull(reader.getReader());
    }
}
