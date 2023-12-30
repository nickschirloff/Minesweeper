package models;

import controllers.CellMouseHandler;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;

public class Cell extends JButton {
    
    private int value = 0;
    private boolean isFlagged = false;
    private boolean isMine = false;
    private GameInstance gi;
    public Cell(GameInstance gi) {
        this.gi = gi;
        setText("?");
        setPreferredSize(new Dimension(60, 60));
        addMouseListener(new CellMouseHandler(this));
    }

    public void reveal() { 
        if(!gi.getGameIsOver()) {
            gi.updateAndCheckCellCount();
        }
        if(isFlagged) {
            setIcon(null);
        }
        switch(value) {
            case -1: 
                setBackground(Color.BLACK);
                setForeground(Color.WHITE);
                setText(Integer.toString(value)); 
            break;
            case 0:
                setText(""); 
                break;
            case 1:
                setBackground(Color.LIGHT_GRAY);
                setText(Integer.toString(value)); 
            break;
            case 2:
                setBackground(Color.YELLOW);
                setText(Integer.toString(value)); 
            break;
            case 3:
                setBackground(Color.ORANGE);
                setText(Integer.toString(value)); 
            break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                setBackground(Color.RED);
                setText(Integer.toString(value)); 
            default:
            break;
        }
    }
    
    public void flagCell() { isFlagged = !isFlagged; }
    public void setIsMine(boolean val) { 
        isMine = val;
        value = -1;
    }
    public boolean getIsMine() { return isMine; }
    public void updateValue(int val) { 
        if(!isMine) {
            this.value += val;
        }
    }
    public int getValue() { return this.value; }
    public boolean getIsFlagged() { return this.isFlagged; }

    public void emitGameOver() {
        gi.gameOver();
    }
    public void updateHiddenMineCount(int value) {
        gi.updateHiddenMineCount(value);
    } 


}
