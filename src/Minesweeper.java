import view.Window;

import models.GameLogic;

public class Minesweeper {
    public static void main(String[] args) {
        GameLogic gl = new GameLogic(1);
        gl.generateBoard();
        gl.generateMines();
        gl.updateBoard();
        gl.printBoard();
    }
}