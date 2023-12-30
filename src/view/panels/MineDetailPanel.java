package view.panels;

import view.Window;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JLabel;

public class MineDetailPanel extends JPanel {
    
    private JLabel flavorTextLabel;
    private JLabel totalMinesLabel;
    public MineDetailPanel(Window frame) {
        setPreferredSize(new Dimension(frame.getWidth()/3, 300));
        flavorTextLabel = new JLabel("Total Mines:");
        totalMinesLabel = new JLabel();

        add(flavorTextLabel);
        add(totalMinesLabel);
    }

    public void updateMineCount(int newNumMines) {
        totalMinesLabel.setText(Integer.toString(newNumMines));
    }
}
