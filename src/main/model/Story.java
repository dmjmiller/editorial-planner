package model;

import persistence.Reader;
import persistence.Saveable;

import java.io.PrintWriter;

// Represents a magazine story having a title, author,  word count and status.
// SOURCE: I used Incident as a reference for the class setup in Story,
// and Teller Account as a base for persistence code
public abstract class Story implements Saveable {
    protected String title;
    protected String author;
    protected int wordCount;
    protected String type;


    // REQUIRES: author and title to have non-zero length, word count >= 0.
    // EFFECTS: constructs a story with given title, author and word count
    public Story(String title, String author, int count, String type) {
        this.title = title;
        this.author = author;
        this.wordCount = count;
        this.type = type;
    }


    // EFFECTS: returns title
    public String getTitle() {
        return title;
    }

    // EFFECTS: returns author
    public String getAuthor() {
        return author;
    }

    // EFFECTS: returns wordCount
    public int getWordCount() {
        return wordCount;
    }

    // EFFECTS: returns wordCount
    public String getType() {
        return type;
    }

    // EFFECTS: calculates a story's costs by multiplying its word count by the RATE:
    public abstract double getCost();


    @Override
    public void save(PrintWriter printWriter) {
        printWriter.print(title);
        printWriter.print(Reader.DELIMITER);
        printWriter.print(author);
        printWriter.print(Reader.DELIMITER);
        printWriter.print(wordCount);
        printWriter.print(Reader.DELIMITER);
        printWriter.print(type);
        printWriter.print(Reader.DELIMITER);
    }


}







