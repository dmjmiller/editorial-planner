package persistence;


import model.Column;
import model.Feature;
import model.Story;
import model.StoryList;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// A reader that can read account data from a file
// SOURCE: I used Teller Reader as a base for the Reader code
public class Reader {


    public static final String DELIMITER = ",";

    private static Reader reader = new Reader();

    public Reader getReader() {
        return reader;
    }


    // EFFECTS: returns a list of stories parsed from file; throws
    // IOException if an exception is raised when opening / reading from file
    public static StoryList readStories(File file) throws IOException {
        List<String> fileContent = readFile(file);
        return parseContent(fileContent);
    }

    //EFFECTS: returns content of file as a list of strings, each string
    //containing the content of one row of the file
    private static List<String> readFile(File file) throws IOException {
        return Files.readAllLines(file.toPath());
    }


    // EFFECTS: returns a list of accounts parsed from list of strings
    // where each string contains data for one account
    private static StoryList parseContent(List<String> fileContent) {
        StoryList stories = new StoryList();

        for (String line : fileContent) {
            ArrayList<String> lineComponents = splitString(line);
            stories.addStory(parseStory(lineComponents));
        }
        return stories;
    }

    //EFFECTS: returns a list of strings obtained by splitting line on DELIMITER
    private static ArrayList<String> splitString(String line) {
        String[] splits = line.split(DELIMITER);
        return new ArrayList<>(Arrays.asList(splits));
    }

    //REQUIRES: components has size 4 where element 0 represents the title of the
    // story, element 1 represents the author and element 2 represents the word count and element 3 represents the type
    // EFFECTS: returns a story constructed from components
    private static Story parseStory(List<String> components) {
        String title = components.get(0);
        String author = components.get(1);
        int count = Integer.parseInt(components.get(2));
        String type = components.get(3);

        if (type.equals("Feature")) {
            return new Feature(title, author, count, type);
        }
        return new Column(title, author, count, type);
    }

}



