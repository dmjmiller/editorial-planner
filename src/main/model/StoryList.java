package model;

import java.util.ArrayList;
import java.util.List;

// Represents a list of stories in a magazine
// SOURCE: I used Incident Queue as a reference for the class setup in StoryList
public class StoryList {
    List<Story> stories;
    int cost = 0;
    int storyCount = 0;


    // EFFECTS constructs an empty story list
    public StoryList() {
        stories = new ArrayList();
    }

    // MODIFIES: this
    // EFFECTS: adds story to story list
    public void addStory(Story story) {
        stories.add(story);
    }

    // EFFECTS: returns stories from list
    public List<Story> getStories() {
        return stories;
    }

    // EFFECTS: gets story count from list
    public int getStoryCount() {
        storyCount = 0;
        for (Story next : stories) {
            storyCount++;
        }
        return storyCount;
    }

    //EFFECTS: returns a string representing the total cost of the stories in the story list.
    public int totalCost() {
        cost = 0;
        for (Story next : stories) {
            cost += next.getCost() / 100.00;
        }
        return cost;
    }

}
