package view.alerts;

import view.Window;
import javax.swing.JOptionPane;

public class GameStatusAlert {
    
    public GameStatusAlert(Window frame, boolean victory) {
        String message = victory ? "You won! Play again?" : "You lost! Play again?";
        int response = JOptionPane.showConfirmDialog(frame, message);
        switch(response) {
            case JOptionPane.YES_OPTION:
                frame.newGame(frame.getGameInstance().getDifficulty());
            break;
            case JOptionPane.NO_OPTION:
            case JOptionPane.CANCEL_OPTION:
                frame.dispose();
            break;
        }
    }
}
