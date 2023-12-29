package models;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;

public class Cell extends JButton {
    
    private int value = 0;
    private boolean isFlagged = false;
    private boolean isMine = false;
    public Cell() {
        setText("?");
        setPreferredSize(new Dimension(60, 60));
        addActionListener(e -> reveal());
    }

    public void reveal() { 
        switch(value) {
            case 1:
            setBackground(Color.LIGHT_GRAY);
            break;
            case 2:
            setBackground(Color.YELLOW);
            break;
            case 3:
            setBackground(Color.ORANGE);
            break;
            case 4:
            setBackground(Color.RED);
            case 5:
            setBackground(Color.BLACK);
            setForeground(Color.WHITE);
            break;
            default:
            break;
        }
        setText(Integer.toString(value)); 
    }
    public void flagCell() { isFlagged = !isFlagged; }
    public void setIsMine(boolean val) { 
        isMine = val;
        value = -1;
    }
    public boolean getIsMine() { return isMine; }
    public void updateValue(int val) { 
        if(isMine) {
            // do nothing
        }
        this.value += val; }
    public int getValue() { return this.value; }
}
