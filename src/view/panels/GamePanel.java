package view.panels;

import view.Window;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import models.Cell;

public class GamePanel extends JPanel {
    
    private Window frame;
    public GamePanel(Window frame) {
        this.frame = frame;
        setPreferredSize(getPreferredSize());
        setBackground(Color.GRAY);
        add(new Cell());
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(frame.getWidth(), 600);
    }

}
