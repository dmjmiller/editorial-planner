package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


// unit tests for the story list class
class StoryListTest {
    private static final String STORY_FILE = "./data/stories.txt";
    StoryList list;
    List<Story> testList = new ArrayList<>();
    Story s1 = new Column("Really good story", "Hunter S Thompson", 2000, "Column");
    Story s2 = new Feature("Not so good story", "Joe Blow", 1560, "Feature");
    Story s3 = new Column("BEST STORY EVER", "Hunter S Thompson", 1000, "Column");

    @BeforeEach
    public void runBefore() {
        this.list = new StoryList();
    }

    @Test
    public void testConstructor() {
        assertEquals(0, list.getStoryCount());
    }

    @Test
    public void testAddStory() {
        list.addStory(s1);
        list.addStory(s2);
        assertEquals(2, list.getStoryCount());

    }

    @Test
    public void testGetStory() {
        list.addStory(s1);
        testList.add(s1);
        assertEquals(testList, list.getStories());
    }

    @Test
    public void testTotalCost() {
        list.addStory(s1);
        list.addStory(s2);
        list.addStory(s3);
        assertEquals(1530.0, list.totalCost());
    }

}


