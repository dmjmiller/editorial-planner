package model;

public class Feature extends Story {

    public static final int FEATURE_RATE = 50;

    public Feature(String title, String author, int count, String type) {
        super(title, author, count, type);
    }

    @Override
    public double getCost() {
        return wordCount * FEATURE_RATE;
    }


}
