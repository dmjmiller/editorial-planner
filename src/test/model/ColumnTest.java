package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ColumnTest {
    Story story;


    @BeforeEach
    public void runBefore() {
        story = new Column("Really good story", "Hunter S Thompson", 2000, "Column");
    }

    @Test
    public void testGetCost() {
        assertEquals(50000.0, story.getCost());
    }

}
