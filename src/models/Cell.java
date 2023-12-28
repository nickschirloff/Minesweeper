package models;

import java.awt.Dimension;
import javax.swing.JButton;

public class Cell extends JButton {
    
    private int value = 0;
    private boolean isFlagged = false;
    public Cell() {
        setText("?");
        setPreferredSize(new Dimension(60, 60));
        addActionListener(e -> reveal());
    }

    public void reveal() { setText(Integer.toString(value)); }
    public void flagCell() { isFlagged = !isFlagged; }
    public void updateValue() { this.value += 1; }
    public int getValue() { return this.value; }
}
