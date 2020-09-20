package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FeatureTest {
    Story story;


    @BeforeEach
    public void runBefore() {
        story = new Feature("Not so good story", "Joe Blow", 1560, "Feature");
    }

    @Test
    public void testGetCost() {
        assertEquals(78000.0, story.getCost());
    }

}
