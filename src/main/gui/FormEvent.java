package gui;

import java.util.EventObject;

// This formevent represents a story being added to the list in the tablepanel.
// SOURCE: I based this class off of the "Complete Java GUI/Swing Tutorial" at https://www.youtube.com/watch?v=WRwPVZ4jmNY

public class FormEvent extends EventObject {

    private String name;
    private String title;
    private int count;
    private String type;


    public FormEvent(Object source, String name, String title, int count, String type) {
        super(source);

        this.name = name;
        this.title = title;
        this.count = count;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getType() {
        return type;
    }

    public void setType() {
        this.type = type;
    }
}
