package view.panels;

import view.Window;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import models.Cell;

public class GamePanel extends JPanel {
    
    private Window frame;
    public GamePanel(Window frame) {
        this.frame = frame;
        setPreferredSize(getPreferredSize());
    }

    public void populatePanel(Cell[][] board) {
        setLayout(new GridLayout(board.length, board[0].length));
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[i].length; j++)
            {   
                board[i][j].setSize(60, 60);
                add(board[i][j]);
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(frame.getWidth(), 600);
    }

}
