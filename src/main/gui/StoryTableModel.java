package gui;

import model.Story;

import javax.swing.table.AbstractTableModel;
import java.util.List;

// creates the columns and labels used to display the story list in the tablepanel
// SOURCE: I based this class off of the "Complete Java GUI/Swing Tutorial" at https://www.youtube.com/watch?v=WRwPVZ4jmNY

public class StoryTableModel extends AbstractTableModel {

    private List<Story> sl;

    private String[] colNames = {"Title", "Author", "Word Count", "Story Type"};

    public StoryTableModel() {
    }

    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }

    public void setData(List<Story> sl) {
        this.sl = sl;
    }

    @Override
    public int getRowCount() {
        return sl.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Story story = sl.get(row);

        switch (col) {
            case 0:
                return story.getAuthor();
            case 1:
                return story.getTitle();
            case 2:
                return story.getWordCount();
            case 3:
                return story.getType();
        }
        return null;
    }
}
