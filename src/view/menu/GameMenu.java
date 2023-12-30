package view.menu;

import view.Window;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameMenu extends JMenuBar implements ActionListener {
    
    private Window frame;
    private JMenu mainMenu, difficultyMenu;

    public GameMenu(Window frame) {
        this.frame = frame;

        mainMenu = new JMenu("Settings");
        difficultyMenu = new JMenu("Difficulty");

        JMenuItem difficultySettingEasy = new JMenuItem("Easy");
        difficultySettingEasy.addActionListener(this);
        JMenuItem difficultySettingMedium = new JMenuItem("Medium");
        difficultySettingMedium.addActionListener(this);
        JMenuItem difficultySettingHard = new JMenuItem("Hard");
        difficultySettingHard.addActionListener(this);

        difficultyMenu.add(difficultySettingEasy);
        difficultyMenu.add(difficultySettingMedium);
        difficultyMenu.add(difficultySettingHard);

        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(this);

        mainMenu.add(difficultyMenu);
        mainMenu.addSeparator();
        mainMenu.add(exitMenuItem);
        add(mainMenu);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        switch(s) {
            case "Easy":
                frame.setWindowWidth(900);
                frame.refresh(1);
            break;
            case "Medium":
                frame.setWindowWidth(735);
                frame.refresh(2);
            break;
            case "Hard":
                frame.setWindowWidth(855);
                frame.refresh(3);
            break;
            case "Exit":
                frame.dispose();
            break;
        }
    }

}
