package gui;

import gui.controller.Controller;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

// The mainframe is the main organizing class for the GUI.
// It interacts with the Model classes and methods only through the controller class.
// SOURCE: I based this class off of the "Complete Java GUI/Swing Tutorial" at https://www.youtube.com/watch?v=WRwPVZ4jmNY

public class MainFrame extends JFrame {


    private ToolBar toolbar;
    private FormPanel formPanel;
    private Controller controller;
    private TablePanel tablePanel;


    // MODIFIES: this
    // EFFECTS: initialises and organizes the elements and functions of GUI.
    // Interacts only with controller and other GUI elements
    public MainFrame() {

        super("Editorial Lineup");

        setLayout(new BorderLayout());

        toolbar = new ToolBar();
        formPanel = new FormPanel();
        tablePanel = new TablePanel();

        doCostButton();
        doClearButton();

        setJMenuBar(createMenuBar());

        controller = new Controller();

        tablePanel.setData(controller.getStory());

        formPanel.setFormListener(new FormListener() {
            public void formEventOccurred(FormEvent e) {
                controller.addStory(e);
                tablePanel.refresh();
            }
        });

        add(formPanel, BorderLayout.WEST);
        add(toolbar, BorderLayout.NORTH);
        add(tablePanel, BorderLayout.CENTER);

        setMinimumSize(new Dimension(500, 250));
        setSize(600, 300);
        setDefaultCloseOperation(JInternalFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

   // MODIFIES: this
   // The Cost button in the toolbar calls gets the story list cost from controller/Storylist,
   // to compare the current cost with the total cost limit of the issue
   // SOURCE: I followed the JFreeChart "Java prog#63" tutorial at https://www.youtube.com/watch?v=MkrtvyxPpNg
    public void doCostButton() {

        toolbar.costButton.addActionListener(new ActionListener() {
            private CostFrame cost = new CostFrame();
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultPieDataset pieDataset = new DefaultPieDataset();
                pieDataset.setValue("Editorial Cost: \n$" + controller.getCost() + " in \n"
                        + controller.getStoryCount() + " stories", new Integer(controller.getCost()));
                pieDataset.setValue("Issue Cost Limit: \n$10000", new Integer(10000 - controller.getCost()));
                cost.costChart(pieDataset);
            }
        });
    }

    // MODIFIES: tablepanel
    // EFFECTS: the Clear button clears the storylist from the tablepanel
    public void doClearButton() {
        toolbar.clearButton.addActionListener(e -> {
            tablePanel.setData(controller.clearList());
            tablePanel.refresh();
        });
    }

    // MODIFIES: this
    // EFFECTS: creates a menubar with a file menu
    public JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        fileMenu.add(doExport());
        fileMenu.add(doImport());
        menuBar.add(fileMenu);
        return menuBar;
    }

    // MODIFIES: this
    // EFFECTS: creates an menu item for saving the story list
    public JMenuItem doExport() {

        JMenuItem exportDataItem = new JMenuItem("Save and Exit...");

        exportDataItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.saveToFile();
                    System.exit(0);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        return exportDataItem;
    }

    // MODIFIES: this
    // EFFECTS: creates an menu item for importing a saved story list
    public JMenuItem doImport() {
        JMenuItem importDataItem = new JMenuItem("Load Stories...");

        importDataItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    tablePanel.setData(controller.loadFromFile().getStories());
                    tablePanel.refresh();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        return importDataItem;
    }


}



