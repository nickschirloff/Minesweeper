package view.panels;

import view.Window;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Dimension;

import javax.swing.JButton;

public class RevealBoardPanel extends JPanel {

    private JLabel flavorTextLabel;
    private JButton revealButton;

    public RevealBoardPanel(Window frame) {
        setPreferredSize(new Dimension(frame.getWidth()/3, 300));
        flavorTextLabel = new JLabel("Give up?");
        revealButton = new JButton("Reveal");
        revealButton.addActionListener(e -> frame.getGameInstance().revealBoard());

        add(flavorTextLabel);
        add(revealButton);
    }
    
}
