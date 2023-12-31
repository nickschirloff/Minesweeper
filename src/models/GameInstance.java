package models;

import view.Window;
import java.util.Arrays;
import java.util.Random;

public class GameInstance {

    private Window frame;
    private int difficulty;
    private int numMines;
    private int hiddenMineCount;
    private int revealedCellCount;
    private int rows, cols;
    private boolean gameIsOver = false;
    private Cell[][] board;
    private Integer[] minesPos;
    Random rand = new Random();

    public GameInstance(Window frame, int difficulty) {
        this.frame = frame;
        this.difficulty = difficulty;
        rows = 10;
        newGame(difficulty);
    }

    /*
     * 
     * @param  newDifficulty  The new given difficulty to start a new game   
     */
    public void newGame(int newDifficulty) {
        this.difficulty = newDifficulty;
        cols = 8 + (difficulty * 2);
        gameIsOver = false;
        generateBoard();
        generateMines();
        updateBoard();
    }

    public void generateBoard() {
        revealedCellCount = rows * cols;
        board = new Cell[rows][cols];
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                board[i][j] = new Cell(this);
            }
        }
    }

    public void generateMines() {
        /*
         * (6 + (difficulty * 2))
         * Calculating minimum number of mines for each difficulty, resuling in:
         * Easy = 8, Med = 10, Hard = 12
         * rand.nextInt(difficulty * 4) + 1
         * Adding random difficulty modifier. Calculates from 1-4 (easy) to 1-12 (hard)
         */
        numMines = (6 + (difficulty * 2)) + rand.nextInt(difficulty * 4) + 1;
        minesPos = new Integer[numMines];
        hiddenMineCount = numMines;

        int bound = 10 * (8 + (difficulty * 2));
        Integer temp;
        for(int i = 0; i < numMines; i++)
        {
            temp = rand.nextInt(bound);
            // TODO: Add check for first cell clicked
            while(Arrays.asList(minesPos).contains(temp))
            {
                temp = rand.nextInt(bound);
            }
            minesPos[i] = temp;
        }
    }

    public void updateBoard() {
        int x, y;
        for(int i = 0; i < minesPos.length; i++)
        {
            x = minesPos[i] / (8 + (difficulty * 2));
            y = minesPos[i]%cols;
            board[x][y].setIsMine();
            updateNeighbors(x, y);
        }
    }

    /*
     * Credit to TorbenPutkonen on StackOverflow for the basis of the functions
     * to update value of mines around cells
     * https://codereview.stackexchange.com/questions/248530/minesweeper-bombcounts
     */

    public void updateNeighbors(int x, int y) {
        for(int x1 = x - 1; x1 <= x + 1; x1++)
        {
            for(int y1 = y - 1; y1 <= y + 1; y1++)
            {
                if(isWithinBounds(x1, y1) && !isMine(x1, y1))
                {
                    board[x1][y1].incrimentValue();
                }
            }
        }
    }

    private boolean isWithinBounds(int x, int y) {
        return x >= 0 && y >= 0 && x < rows && y < cols;
    }

    private boolean isMine(int x, int y) {
        return board[x][y].getIsMine();
    }


    public void revealBoard() {
        gameIsOver = true;
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                board[i][j].reveal();
            }
        }
    }

    public void updateHiddenMineCount(int val) {
        hiddenMineCount += val;
        if(hiddenMineCount == 0) {
            frame.endGame(true);
        }
    }

    public void updateAndCheckCellCount() {
        revealedCellCount--;
        if(((rows * cols) - revealedCellCount) == numMines)
        {
            frame.endGame(true);
        }
    }

    public void gameOver() {
        revealBoard();
        frame.endGame(false);
    }

    public Cell[][] getBoard() { return board; }
    public int getMineCount() { return numMines; }
    public int getDifficulty() { return difficulty; }
    public boolean getGameIsOver() { return gameIsOver; }
}
