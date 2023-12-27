package view.panels;

import view.Window;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class SettingsPanel extends JPanel {
    
    private Window frame;
    GridBagLayout gbc = new GridBagLayout();
    GridBagLayout gb;
    private JLabel minesFlavorTextLabel;
    private JLabel numMinesLabel;
    private JButton gameStartButton;

    public SettingsPanel(Window frame) {
        this.frame = frame;
        // setLayout(gbc);

        // GridBagConstraints gc = new GridBagConstraints();
        // gc.fill = GridBagConstraints.HORIZONTAL;
        // gc.insets = new Insets(2,2,2,2);

        // gc.gridx = 0;
        // gc.gridy = 0;

        // minesFlavorTextLabel = new JLabel("Number of Mines:");
        // add(minesFlavorTextLabel);

        // gc.gridx = 0;
        // gc.gridy = 1;

        // numMinesLabel = new JLabel("0");
        // add(numMinesLabel);

        // gc.gridx = 0;
        // gc.gridy = 1;
        // gc.gridheight = 2;
        // gameStartButton = new JButton("Start");
        // add(gameStartButton);
        setPreferredSize(getPreferredSize());
        setBackground(Color.RED);
    }

    private void handleGeneration() {
        // gb = new GridBagLayout();
        // setLayout(gb);

        GridBagConstraints gc = new GridBagConstraints();

    }

    public void refresh() {
        setSize(new Dimension(frame.getWidth(), 200));
        repaint();
    }



    @Override
    public Dimension getPreferredSize() {
        return new Dimension(frame.getWidth(), 200);
    }
}
