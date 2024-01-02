package controllers;

import models.Cell;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;

public class CellMouseHandler extends MouseAdapter {

    private Cell cell;
    public CellMouseHandler(Cell cell) {
        this.cell = cell;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Neatly handling which mouse input is received
        if(cell.checkGameOver()) {
            // if the game is over, we don't want any action to be
            // handled, so we do nothing here
            return;
        } else if(SwingUtilities.isRightMouseButton(e)) {
            handleRightClick();
        } else {
            handleOtherClick();
        }
    }

    public void handleRightClick() {
        cell.flagCell();
        // If the cell is a mine, and was not flagged beforehand
        if(cell.getIsMine() && cell.getIsFlagged()) {
            cell.updateHiddenMineCount(-1);
        } else if(cell.getIsMine() && !cell.getIsFlagged()) { // If the cell is a mine, and was flagged beforehand
            cell.updateHiddenMineCount(1);
        }
    }

    public void handleOtherClick() {
        if(cell.getIsFlagged()) {
            return;
        } else if(cell.getIsMine()) {
            cell.emitGameOver();
        } else {
            cell.setIsRevealed(true);
            cell.show();
        }
    }
    
}
