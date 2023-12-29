package view.panels;

import view.Window;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JLabel;

public class MineDetailPanel extends JPanel {
    
    private Window frame;
    private JLabel flavorTextLabel;
    private JLabel totalMinesLabel;
    public MineDetailPanel(Window frame, int initialMines) {
        this.frame = frame;
        setPreferredSize(new Dimension(frame.getWidth()/3, 300));
        flavorTextLabel = new JLabel("Total Mines:");
        totalMinesLabel = new JLabel(Integer.toString(initialMines));

        add(flavorTextLabel);
        add(totalMinesLabel);
    }

    public void updateMineCount(int newNumMines) {
        totalMinesLabel.setText(Integer.toString(newNumMines));
    }
}
