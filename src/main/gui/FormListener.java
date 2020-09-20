package gui;

import java.util.EventListener;

// This formlistener is an interface used to add a story input into the formpanel to the tablepanel
// SOURCE: I based this class off of the "Complete Java GUI/Swing Tutorial" at https://www.youtube.com/watch?v=WRwPVZ4jmNY

public interface FormListener extends EventListener {
    public void formEventOccurred(FormEvent e);
}
