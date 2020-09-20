
package persistence;

import model.Column;
import model.Feature;
import model.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


// SOURCE: I used Teller WriterTest as a base for the WriterTest code
public class WriterTest {
    private static final String TEST_FILE = "./data/testStory.txt";
    private Writer testWriter;
    protected Story s1;
    protected Story s2;
    protected Story s3;
    protected Story s4;

    @BeforeEach
    void runBefore() throws FileNotFoundException, UnsupportedEncodingException {
        testWriter = new Writer(new File(TEST_FILE));
        s1 = new Column("Really good story", "Hunter S Thompson", 2000, "Column");
        s2 = new Column("Not so good story", "Joe Blow", 1560, "Column");
        s3 = new Feature("BEST STORY EVER", "Hunter S Thompson", 1000, "Feature");
        s4 = new Feature("BLEH", "Some Guy", 500, "Feature");
    }

    @Test
    void testWriteStory() {
        // save s1 and s2 to file
        testWriter.write(s1);
        testWriter.write(s2);
        testWriter.write(s3);
        testWriter.write(s4);
        testWriter.close();

        // read them back and verify that stories have expected values
        try {
            List<Story> stories = Reader.readStories(new File(TEST_FILE)).getStories();
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
}





