package gui;

import javax.swing.*;

// The Main class initialises the MainFrame, which runs the application
public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainFrame();
            }
        });
    }
}
