package model;

public class Column extends Story {

    public static final int COLUMN_RATE = 25;

    public Column(String title, String author, int count, String type) {
        super(title, author, count, type);
    }

    @Override
    public double getCost() {
        return wordCount * COLUMN_RATE;
    }
}
