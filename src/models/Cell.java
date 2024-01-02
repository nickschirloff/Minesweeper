package models;

import controllers.CellMouseHandler;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Cell extends JButton {
    
    private int value = 0;
    private boolean isFlagged = false;
    private boolean isMine = false;
    private boolean isRevealed = false;
    private GameInstance gi;
    public Cell(GameInstance gi) {
        this.gi = gi;
        setText("?");
        setPreferredSize(new Dimension(60, 60));
        addMouseListener(new CellMouseHandler(this));
    }

    /*
     * The next two methods are similar in functionality, but are called under separate conditions.
     * 
     * show() is called when a cell is clicked, and is used when the current game is still
     * ongoing, and the user is trying to win
     * reveal() is called when the game is over, or the user clicks the 'give up' button, where
     * certain conditions do not need to be checked
     * 
     * In other words, show() is called during the game, reveal() is called when the game is over.
     * Could maybe combined these methods, but I kept them separate for better clarity
     */
    public void show() {
        setText(Integer.toString(value));
        colorCell();
        if(isMine) {
            gi.gameOver();
        }
        gi.updateAndCheckCellCount();
    }

    public void reveal() {
        setIcon(null);
        setText(Integer.toString(value));
        colorCell();
    }

    /*
     * Colors a cell based on its value when it is revealed.
     */
    public void colorCell() {
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
    
    /*
     * Inverts the flag status of a cell, adding or removing an icon of a flag to the cell
     */
    public void flagCell() {
        if(isRevealed) {
            return;
        }

        if(isFlagged) {
            isFlagged = false;
            setIcon(null);
            setText("?");
        } else {
            isFlagged = true;
            Icon flagIcon = new ImageIcon("src\\assets\\flag.png");
            setIcon(flagIcon);
            setText("");
        }
        
    }

    /*
     * Sets a flag to indicate a cell is a mine, and updates its value to -1 to represent that
     */
    public void setIsMine() { 
        isMine = true;
        value = -1;
    }
    /*
     * Incriments the value of a cell if it is around a mine, but is not a mine itself.
     * For instance, if this cell is near two mines, this function will be called twice,
     * incrimenting its value by two to represent that.
     */
    public void incrimentValue() { 
        if(!isMine) {
            this.value += 1;
        }
    }

    public void emitGameOver() {
        gi.gameOver();
    }
    public void updateHiddenMineCount(int value) {
        gi.updateHiddenMineCount(value);
    }
    public boolean getIsRevealed() { return isRevealed; }
    public void setIsRevealed(boolean val) { isRevealed = val; }
    public boolean checkGameOver() { return gi.getGameIsOver(); }
    public boolean getIsFlagged() { return this.isFlagged; }
    public boolean getIsMine() { return isMine; }
    public int getValue() { return this.value; }
}
