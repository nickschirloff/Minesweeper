package view;

import view.menu.GameMenu;
import view.panels.*;
import models.GameInstance;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;

public class Window extends JFrame {

    private int windowWidth = 615;
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

        gi = new GameInstance(GameInstance.DIFFICULTY_EASY);

        mp = new MineDetailPanel(this, 0);
        mp.updateMineCount(gi.getMineCount());
        add(mp, BorderLayout.LINE_START);

        Icon mineIcon = new ImageIcon("src\\assets\\mine.png");
        JButton startButton = new JButton(mineIcon);
        add(startButton, BorderLayout.CENTER);

        rp = new RevealBoardPanel(this);
        add(rp, BorderLayout.LINE_END);

        gp = new GamePanel(this);
        gp.populatePanel(gi.getBoard());
        add(gp, BorderLayout.PAGE_END);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void refresh(int newDifficulty) {
                System.out.println();
        System.out.println();
        System.out.println();
        gi = new GameInstance(newDifficulty);
        //gi.newGame();
        mp.updateMineCount(gi.getMineCount());
        gp.reset();
        gp.populatePanel(gi.getBoard());

        repaint();
    }

    public void setWindowWidth(int newWidth) { 
        windowWidth = newWidth;
        setSize(newWidth, windowHeight);
    }
    public void setWindowHeight(int newHeight) { 
        windowHeight = newHeight;
        setSize(windowWidth, newHeight);
    }

    public int getWindowWidth() { return windowWidth; }
    public int getWindowHeight() { return windowHeight; }
    public GameInstance getGameInstance() { return gi; }

}
