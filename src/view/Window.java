package view;

import view.menu.GameMenu;
import view.panels.*;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class Window extends JFrame {

    private int windowWidth = 600;
    private int windowHeight = 800;
    private SettingsPanel sp;
    private GamePanel gp;

    public Window() {
        setTitle("Minesweeper");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(windowWidth, windowHeight);
        setResizable(false);
        setJMenuBar(new GameMenu(this));
        //setLayout(null);
        setLayout(new BorderLayout());

        sp = new SettingsPanel(this);
        add(sp, BorderLayout.PAGE_START);

        gp = new GamePanel(this);
        add(gp, BorderLayout.PAGE_END);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void refresh() {
        sp.refresh();
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

}
