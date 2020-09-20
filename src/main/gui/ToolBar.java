package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// the toolbar is where the Cost and Clear buttons are located.
// SOURCE: I based this class off of the "Complete Java GUI/Swing Tutorial" at https://www.youtube.com/watch?v=WRwPVZ4jmNY

public class ToolBar extends JPanel {

    protected JButton costButton;
    protected JButton clearButton;


    public ToolBar() {



        setBorder(BorderFactory.createEtchedBorder());

        costButton = new JButton("Show Cost");
        clearButton = new JButton("Clear List");

        costButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(costButton);
        add(clearButton);

    }
}







