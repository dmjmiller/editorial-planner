package gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPanel extends JPanel {
    private JLabel nameLabel;
    private JLabel titleLabel;
    private JLabel countLabel;
    private JTextField nameField;
    private JTextField titleField;
    private JSpinner countField;
    private JButton okBtn;
    private JComboBox storyType;

    private FormListener formListener;
    private GridBagConstraints gc = new GridBagConstraints();


    // This formpanel is where the user creates a story with a title, author name and wordcount,
    // and uses the OK button to add it to tablepanel via mainframe
    // SOURCE: I based this class off of the "Complete Java GUI/Swing Tutorial" at https://www.youtube.com/watch?v=WRwPVZ4jmNY

    public FormPanel() {


        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);

        nameLabel = new JLabel("Author Name: ");
        nameField = new JTextField(10);

        titleLabel = new JLabel("Story Title: ");
        titleField = new JTextField(10);

        countLabel = new JLabel("Word Count: ");
        countField = new JSpinner(new SpinnerNumberModel(0, 0, 3000, 100));

        storyType = new JComboBox();

        DefaultComboBoxModel typeModel = new DefaultComboBoxModel();
        typeModel.addElement("Feature");
        typeModel.addElement("Column");
        storyType.setModel(typeModel);
        storyType.setSelectedIndex(0);

        okBtn = new JButton("OK");
        setOkBtn();

        Border innerBorder = BorderFactory.createTitledBorder("Add Story");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
        setLayout(new GridBagLayout());

        setDimensions();

    }

    // EFFECTS: sets the OK button / actionlistener, which creates a form event with a story name, title and wordcount
    public void setOkBtn() {
        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String title = titleField.getText();
                int count = (Integer) countField.getValue();
                String type = (String) storyType.getSelectedItem();

                FormEvent event = new FormEvent(this, name, title, count, type);
                if (formListener != null) {
                    formListener.formEventOccurred(event);
                }
            }
        });
    }


    // MODIFIES: this
    // EFFECTS: sets the dimensions for labels and fields in formpanel
    public void setDimensions() {

        gridWeight(1, 1);
        ///first row//////////////////////

        gridCords(0, 0);
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        add(titleLabel, gc);

        gridCords(1, 0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(titleField, gc);

        ///second row//////////////////////

        gridCords(0, 1);
        gc.anchor = GridBagConstraints.LINE_END;
        add(nameLabel, gc);

        gridCords(1, 1);
        gc.anchor = GridBagConstraints.LINE_START;
        add(nameField, gc);

        ///third row//////////////////////

        gridCords(0, 2);
        add(countLabel, gc);

        gridCords(1, 2);
        gc.anchor = GridBagConstraints.LINE_START;
        add(countField, gc);

        ///fourth row//////////////////////


        addCombo();

        /// fifth row /////////

        gridCords(1, 4);
        gc.anchor = GridBagConstraints.LINE_START;
        add(okBtn, gc);

    }

    public void setFormListener(FormListener listener) {
        this.formListener = listener;
    }

    // EFFECTS: helper function for setting the grid coordinates for the formpanel
    public void gridCords(int x, int y) {
        gc.gridx = x;
        gc.gridy = y;
    }

    // EFFECTS: helper function for setting the grid weights for the formpanel
    public void gridWeight(int a, int b) {
        gc.weightx = a;
        gc.weighty = b;
    }

    // EFFECTS: helper to add combo box
    public void addCombo() {

        gridCords(0, 3);
        add(new JLabel("Story Type: "), gc);

        gridCords(1, 3);
        gc.anchor = GridBagConstraints.LINE_START;
        add(storyType, gc);

    }

}



