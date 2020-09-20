package gui.controller;

import gui.FormEvent;
import model.Column;
import model.Feature;
import model.Story;
import model.StoryList;
import persistence.Reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

// This Controller class make the connection between the GUI and the classes and methods in the Model.
// SOURCE: I based this class off of the "Complete Java GUI/Swing Tutorial" at https://www.youtube.com/watch?v=WRwPVZ4jmNY
public class Controller {
    StoryList sl = new StoryList();

    private static final String STORY_FILE = "./data/stories.txt";

    public List<Story> getStory() {
        return sl.getStories();
    }

    public int getStoryCount() {
        return sl.getStoryCount();
    }


    // MODIFIES: StoryList
    // EFFECTS: adds a given story (via a formevent from the formpanel) to the storylist sl
    public void addStory(FormEvent ev) {
        String name = ev.getName();
        String title = ev.getTitle();
        int count = ev.getCount();
        String type = ev.getType();

        if (type.equals("Feature")) {
            Story story = new Feature(name, title, count, type);
            sl.addStory(story);
        } else {
            Story story = new Column(name, title, count, type);
            sl.addStory(story);
        }

    }

    // MODIFIES: StoryList
    // EFFECTS: returns an empty storylist
    public List<Story> clearList() {
        sl = new StoryList();
        return sl.getStories();
    }


    // EFFECTS: saves state of story list to STORY_FILE
    // SOURCE: I used TellerApp as a base for the saveStories code
    public void saveToFile() throws IOException {
        try {
            persistence.Writer writer = new persistence.Writer(new File(STORY_FILE));
            for (Story next : sl.getStories()) {
                writer.write(next);
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    // MODIFIES: this
    // EFFECTS: calls reader.readStories to return stories from STORY_FILE, if it exists;
    public StoryList loadFromFile() throws IOException {
        sl = Reader.readStories(new File(STORY_FILE));
        return sl;
    }


    public int getCost() {
        return sl.totalCost();
    }
}
