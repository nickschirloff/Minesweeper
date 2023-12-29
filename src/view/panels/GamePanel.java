package view.panels;

import view.Window;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import models.Cell;

public class GamePanel extends JPanel {
    
    private Window frame;
    public GamePanel(Window frame) {
        this.frame = frame;
        setPreferredSize(getPreferredSize());
        setBackground(Color.GRAY);
        setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
    }

    public void populatePanel(Cell[][] board) {
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[i].length; j++)
            {   
                //board[i][j].setBounds( xWidth, yHeight, 60, 60);
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
