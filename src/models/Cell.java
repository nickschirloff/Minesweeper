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

    public void setValue(int value) { this.value = value; }
    public void reveal() { setText(Integer.toString(value)); }
    public void flagCell() { isFlagged = !isFlagged; }
    public int getValue() { return this.value; }
}
