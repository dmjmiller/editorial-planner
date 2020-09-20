package gui;

import model.Story;

import javax.swing.*;
import java.awt.*;
import java.util.List;

// the tabel panel class is where the story list is displayed.
// SOURCE: I based this class off of the "Complete Java GUI/Swing Tutorial" at https://www.youtube.com/watch?v=WRwPVZ4jmNY

public class TablePanel extends JPanel {
    private JTable table;
    private StoryTableModel tableModel;

    public TablePanel() {

        tableModel = new StoryTableModel();

        table = new JTable(tableModel);

        setLayout(new BorderLayout());

        add(new JScrollPane(table), BorderLayout.CENTER);

    }

    public void setData(List<Story> sl) {
        tableModel.setData(sl);
    }

    public void refresh() {
        tableModel.fireTableDataChanged();
    }
}
