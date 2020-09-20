package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Unit tests for the Story class
public class StoryTest {

    Story s1;
    Story s2;

    @BeforeEach
    public void runBefore() {

       s1 = new Column("Really good story", "Hunter S Thompson", 2000, "Column");
       s2 = new Feature("Not so good story", "Joe Blow", 1560, "Feature");
    }

    @Test
    public void testGetTitle() {
        assertEquals("Really good story", s1.getTitle());
    }

    @Test
    public void testGetAuthor() {
        assertEquals("Joe Blow", s2.getAuthor());
    }

    @Test
    public void testGetWordCount() {
        assertEquals(2000, s1.getWordCount());
    }

    @Test
    public void testGetCost() {
        assertEquals(50000, s1.getCost());
    }



    @Test
    public void testGetType() {
        assertEquals("Feature", s2.getType());
    }



}
