package controllers;

import models.Cell;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

public class CellMouseHandler extends MouseAdapter {

    private Cell cell;
    public CellMouseHandler(Cell cell) {
        this.cell = cell;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(SwingUtilities.isRightMouseButton(e) && cell.getIsMine()) {
            Icon flagIcon = new ImageIcon("src\\assets\\flag.png");
            cell.setIcon(flagIcon);
            cell.setText("");
            cell.updateHiddenMineCount(-1);
        } else if(SwingUtilities.isRightMouseButton(e) && !cell.getIsMine()) {
            Icon flagIcon = new ImageIcon("src\\assets\\flag.png");
            cell.setIcon(flagIcon);
            cell.setText("");
        } 

        if(SwingUtilities.isRightMouseButton(e) && cell.getIsFlagged() && cell.getIsMine()) {
            cell.setIcon(null);
            cell.setText("?");
            cell.updateHiddenMineCount(1);
        } else if(SwingUtilities.isRightMouseButton(e) && cell.getIsMine()) {
            cell.setIcon(null);
            cell.setText("?");
        } else if(SwingUtilities.isRightMouseButton(e) && !cell.getIsFlagged()) {
            cell.flagCell();
            Icon flagIcon = new ImageIcon("src\\assets\\flag.png");
            cell.setIcon(flagIcon);
        }

        if(SwingUtilities.isLeftMouseButton(e) && cell.getIsMine()) {
            cell.reveal();
            cell.emitGameOver();
        } else if(SwingUtilities.isLeftMouseButton(e)) {
            cell.reveal();
        }
    }
    
}
