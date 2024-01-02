package view;

import view.alerts.GameStatusAlert;
import view.menu.GameMenu;
import view.panels.*;
import models.GameInstance;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;

public class Window extends JFrame {

    // Base width/height for an easy difficulty game, which the default difficulty
    private int windowWidth = 600;
    private int windowHeight = 800;
    private GameInstance gi;
    private MineDetailPanel mp;
    private RevealBoardPanel rp;
    private GamePanel gp;

    public Window() {
        setTitle("Minesweeper");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(windowWidth, windowHeight);
        setResizable(false);
        setJMenuBar(new GameMenu(this));
        setLayout(new BorderLayout());

        gi = new GameInstance(this, 1);
        
        mp = new MineDetailPanel(this);
        mp.updateMineCount(gi.getMineCount());
        add(mp, BorderLayout.LINE_START);

        Icon mineIcon = new ImageIcon("src\\assets\\mine.png");
        JButton startButton = new JButton(mineIcon);
        startButton.addActionListener(e -> newGame(gi.getDifficulty()));
        add(startButton, BorderLayout.CENTER);

        rp = new RevealBoardPanel(this);
        add(rp, BorderLayout.LINE_END);

        gp = new GamePanel(this);
        gp.populatePanel(gi.getBoard());
        add(gp, BorderLayout.PAGE_END);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void newGame(int difficulty) {
        gi.newGame(difficulty);
        mp.updateMineCount(gi.getMineCount());
        gp.removeAll();
        gp.populatePanel(gi.getBoard());

        revalidate();
        repaint();
    }

    public void endGame(boolean victory) {
        GameStatusAlert gs = new GameStatusAlert(this, victory);
    }

    public int getWindowWidth() { return windowWidth; }
    public void setWindowWidth(int newWidth) { 
        windowWidth = newWidth;
        setSize(newWidth, windowHeight);
    }

    public GameInstance getGameInstance() { return gi; }

}
