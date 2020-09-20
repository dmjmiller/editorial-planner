//package gui;

import model.Story;
import model.StoryList;
import persistence.Reader;

import java.io.*;
import java.util.List;
import java.util.Scanner;

// Story List application for console
// SOURCE: I used TellerApp as a reference for the setup of StoryListApp
//public class StoryListApp {
// StoryListApp   private static final String STORY_FILE = "./data/stories.txt";
//    StoryList issue;
//    private Scanner input;
//

//    //EFFECTS: Runs the Story List application
//    public StoryListApp() {
//        runStoryList();
//    }
////
//    //MODIFIES: this
//    //EFFECTS: processes user input
//    //SOURCE: I used TellerApp as a reference for the run method
//    private void runStoryList() {
//        boolean runApp = true;
//        String command = null;
//        input = new Scanner(System.in);
//
//        loadStories();
//
//        while (runApp) {
//            displayMenu();
//            command = input.next();
//            command = command.toLowerCase();
//
//            if (command.equals("quit")) {
//                runApp = false;
//            } else {
//                processCommand(command);
//            }
//        }
//        System.out.println("\nGood Luck with the Deadline!");
//    }
//
//    //MODIFIES: this
//    //EFFECTS: loads stories into a new list
//    private void init() {
//        issue = new StoryList();
//        Story s1 = new Story("Really good story", "Hunter S Thompson", 2000);
//        Story s2 = new Story("Not so good story", "Joe Blow", 1560);
//        Story s3 = new Story("BEST STORY EVER", "Hunter S Thompson", 1000);
//        issue.addStory(s1);
//        issue.addStory(s2);
//        issue.addStory(s3);
//    }
//
//    // MODIFIES: this
//    // EFFECTS: loads accounts from STORY_FILE, if it exists;
//    // otherwise initialises stories with default story list
//    // SOURCE: I used TellerApp as a base for the loadStories code
//    private void loadStories() {
//        try {
//            issue = new StoryList();
//            List<Story> savedIssue = Reader.readStories(new File(STORY_FILE));
//            for (Story next : savedIssue) {
//                issue.addStory(next);
//            }
//        } catch (IOException e) {
//            init();
//        }
//    }
//
//    // EFFECTS: saves state of story list to STORY_FILE
//    // SOURCE: I used TellerApp as a base for the saveStories code
//    private void saveStories() {
//        try {
//            persistence.Writer writer = new persistence.Writer(new File(STORY_FILE));
//            for (Story next : issue.getStories()) {
//                writer.write(next);
//            }
//            writer.close();
//            System.out.println("Stories saved to file "  + STORY_FILE);
//        } catch (FileNotFoundException e) {
//            System.out.println("Unable to save stories to " + STORY_FILE);
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//    }
//
//    //MODIFIES: this
//    // EFFECTS: processes user command
//    //SOURCE: I used TellerApp as a reference for the processCommand method
//    private void processCommand(String command) {
//        if (command.equals("add")) {
//            doAdd();
//        } else if (command.equals("lineup")) {
//            doLineup();
//        } else if (command.equals("count")) {
//            doCount();
//        } else if (command.equals("cost")) {
//            doCost();
//        } else if (command.equals("save")) {
//            saveStories();
//        } else {
//            System.out.println("Input not valid...");
//        }
//    }
//
//    // EFFECTS: displays menu of options to user
//    //SOURCE: I used TellerApp as a reference for the displayMenu method
//    public void displayMenu() {
//        System.out.println("\nWould you like to:");
//        System.out.println("\t- Add a story to editorial lineup list? -> add");
//        System.out.println("\t- See the current editorial lineup list? -> lineup");
//        System.out.println("\t- See a count of all stories in editorial lineup list? -> count");
//        System.out.println("\t- See the total cost of the editorial lineup list? -> cost");
//        System.out.println("\t- Save stories to file? -> save");
//        System.out.println("\t- Quit? -> quit");
//    }
//
//    //MODIFIES: this
//    //EFFECTS: adds story to list, with title, author and word count
//    //SOURCE: I used TellerApp doDeposit as a reference for the doAdd method
//    public void doAdd() {
//
//        System.out.println("\nWhat is the title of the story? ");
//        String title = input.nextLine();
//        title = input.nextLine();
//        System.out.println("Title entered as: " + title);
//
//        System.out.println("\nWhat is the name of the author? ");
//        String name = input.nextLine();
//        System.out.println("Name entered as: " + name);
//
//        System.out.println("\nWhat is the word count? ");
//        int wordCount = 0;
//        if (input.hasNextInt()) {
//            wordCount = input.nextInt();
//            System.out.println("Word count entered as: " + wordCount);
//        } else {
//            System.out.println("\nWord count entered is not an integer, please try again!");
//            input.next();
//            return;
//        }
//
//        Story newStory;
//        newStory = new Story(title, name, wordCount);
//
//        issue.addStory(newStory);
//
//        System.out.println("\nNew story added!");
//    }
//
//    //EFFECTS: prints current editorial list
//    public void doLineup() {
//        System.out.println("\nThese are the stories in the next issue: \n" + issue.listDetails());
//    }
//
//
//    //EFFECTS: return number of stories in list
//    public void doCount() {
//        System.out.println("\nThere are " + issue.getStoryCount() + " stories in this issue.");
//    }
//
//    //EFFECTS: return total cost of all stories in list
//    //SOURCE: I used Grocery List for help with formatting the number for cost
//    public void doCost() {
//        System.out.printf("\nThe total cost of editorial in this issue is: $%.2f\n", issue.totalCost());
//    }
//
//}
//
//
