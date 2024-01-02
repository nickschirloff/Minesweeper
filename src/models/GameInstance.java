package models;

import view.Window;
import java.util.Arrays;
import java.util.Random;

public class GameInstance {

    private Window frame;
    private int difficulty;
    private int numMines;
    private int hiddenMineCount, unrevealedCellCount;
    private int rows, cols;
    private boolean gameIsOver = false;
    private Cell[][] board;
    private Integer[] minesPos;
    Random rand = new Random();

    public GameInstance(Window frame, int difficulty) {
        this.frame = frame;
        rows = 10;
        newGame(difficulty);
    }

    /*
     *  Starts a new game. Sets the size of amount of columns for the board based on the given difficulty,
     *  and calls subsequent methods to initialize the game elements.
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

    /*
     * Creates a new board with a size based on the set difficulty. Iterates over the array to initialize
     * the cells at each index. Also initializes unrevealedCellCount, a variable helps keep track of win
     * conditions.
     * 
     * @param   none
     * @return  none
     */
    public void generateBoard() {
        unrevealedCellCount = rows * cols;
        board = new Cell[rows][cols];
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                board[i][j] = new Cell(this);
            }
        }
    }

    /*
     * Generates a random amount of mines based on the set difficulty, and populates an array 
     * with randomly chosen positions for the number of mines.
     * 
     * @param   none
     * @return  none
     */
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

    /*
     * Iterates through the list of mines, and updates the value surrounding cells.
     * For example, if cell is near two mines, its value will become two to reflect it.
     *  
     * @param   none
     * @return  none
     */
    public void updateBoard() {
        int x, y;
        for(int i = 0; i < minesPos.length; i++)
        {
            x = minesPos[i] / (8 + (difficulty * 2));
            y = minesPos[i] % cols;
            board[x][y].setIsMine();
            updateNeighbors(x, y);
        }
    }

    /*
     * Takes the x and y position of a cell within the board, and incriments the value of cells
     * in a 3x3 area around it.
     * 
     * Credit to TorbenPutkonen on StackOverflow for the basis of the functions
     * to update value of mines around cells
     * https://codereview.stackexchange.com/questions/248530/minesweeper-bombcounts
     * 
     * @param   x   The x position of the mine within the board 
     * @param   y   The y position of the mine within the board
     * @return  none
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

    /*
     * Iterates through the board, revealing the value of each cell
     * 
     * @param   none
     * @return  none
     */
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

    /*
     * Updates the hidden win condition that keeps track of whether a user has flagged
     * all cells that contain a mine. If all mine cells are flagged, the user has won.
     * 
     * Called when a mine cell is flagged (right-clicked). Subtracts one from the count
     * if the cell was not flagged already, and adds one if it was flagged.
     * 
     * @param   val The value to add 
     * @return  none
     */
    public void updateHiddenMineCount(int val) {
        hiddenMineCount += val;
        if(hiddenMineCount == 0) {
            frame.endGame(true);
        }
    }

    /*
     * Another value to check for win conditions. When a cell is left-clicked, this
     * function is called, removing one from the unrevealed cell count. If the number
     * of remaining cells is equal to the number of mines, this means the user has won
     * the game.W
     * 
     * @param   none
     * @return  none
     */
    public void updateAndCheckCellCount() {
        unrevealedCellCount--;
        if(unrevealedCellCount == numMines)
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
