package gui;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;


public class CostFrame extends JFrame {

    // MODIFIES: this
    // The CostFrame creates a new JFreeCHart to compare the current cost with the total cost limit of the issue
    // SOURCE: I followed the JFreeChart "Java prog#63" tutorial at https://www.youtube.com/watch?v=MkrtvyxPpNg
    public void costChart(DefaultPieDataset p) {
        JFreeChart chart = ChartFactory.createPieChart("British Columbia Magazine", p);
        ChartFrame frame = new ChartFrame("Editorial Cost", chart);
        frame.setVisible(true);
        frame.setSize(600, 600);
    }
}


