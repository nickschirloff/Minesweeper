package models;

import java.util.ArrayList;

public class GameLogic {
    
    private int difficulty;
    private int arrRows = 10;
    private int arrCols;
    private int[][] board;
    private ArrayList<Cell> cellList = new ArrayList<>();

    public GameLogic(int difficulty) {
        this.difficulty = difficulty;
    }

    // i < 10 * (8 + (difficulty * 2))
    public void generateBoard() {
        for(int i = 0; i < 10 * (8 + (difficulty * 2)); i++)
        {
            Cell c = new Cell();
            cellList.add(c);
        }
    }



    private void generateBoard2() {
        switch(difficulty) {
            case 1:
            arrCols = 10;
            board = new int[arrRows][arrCols];
            break;
            case 2:
            arrCols = 12;
            board = new int[arrRows][arrCols];
            break;
            case 3:
            arrCols = 15;
            board = new int[arrRows][arrCols];
            break;
        }
    }
}
