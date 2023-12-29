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

    public Window() {
        setTitle("Minesweeper");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(windowWidth, windowHeight);
        setResizable(false);
        setJMenuBar(new GameMenu(this));
        setLayout(new BorderLayout());

        gi = new GameInstance(GameInstance.DIFFICULTY_EASY);

        MineDetailPanel mp = new MineDetailPanel(this, 0);
        add(mp, BorderLayout.LINE_START);

        Icon mineIcon = new ImageIcon("src\\assets\\mine.png");
        JButton startButton = new JButton(mineIcon);
        add(startButton, BorderLayout.CENTER);

        RevealBoardPanel rp = new RevealBoardPanel(this);
        add(rp, BorderLayout.LINE_END);

        GamePanel gp = new GamePanel(this);
        gp.populatePanel(gi.getBoard());
        add(gp, BorderLayout.PAGE_END);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void refresh() {
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
