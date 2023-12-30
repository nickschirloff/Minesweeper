package models;

import java.util.Arrays;
import java.util.Random;

public class GameInstance {
    
    public static final int DIFFICULTY_EASY = 1;
    public static final int DIFFICULTY_MEDIUM = 2;
    public static final int DIFFICULTY_HARD = 3;

    private int difficulty;
    private int numMines;
    private int rows, cols;
    private Cell[][] board;
    private Integer[] minesPos;
    Random rand = new Random();

    public GameInstance(int difficulty) {
        this.difficulty = difficulty;
        rows = 10;
        cols = 8 + (difficulty * 2);
        newGame();
    }

    public void newGame() {
        generateBoard();
        generateMines();
        updateBoard();
    }

    public void generateBoard() {
        board = new Cell[rows][cols];
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                board[i][j] = new Cell();
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

        int bound = 10 * (8 + (difficulty * 2));
        Integer temp;
        for(int i = 0; i < numMines; i++)
        {
            temp = rand.nextInt(bound);
            // TODO: Add check for first cell clicked
            while(Arrays.asList(minesPos).contains(temp))
            {
                temp = rand.nextInt(bound) + 1;
            }
            minesPos[i] = temp;
        }
        // printArray(minesPos);
    }

    public void updateBoard() {
        Arrays.sort(minesPos);
        for(int i = 0; i < minesPos.length; i++)
        {
            int x;
            int y;
            x = minesPos[i] / (8 + (difficulty * 2));
            // if(minesPos[i] >= 100) {
            //     x = (minesPos[i] - 100)/(8 + (difficulty * 2));
            // } else {
            //     x = minesPos[i]/(8 + (difficulty * 2));
            // }
            y = minesPos[i]%cols;
            System.out.println("Value: " + minesPos[i]);
            System.out.println("Placing at: " + x + "," + y);
            board[x][y].setIsMine(true);
            updateNeighbors(x, y);
        }
        
        printArray(minesPos);

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
                    board[x1][y1].updateValue(1);
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
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                board[i][j].reveal();
            }
        }
    }

    public Cell[][] getBoard() { 

        
        return board; }
    public int getMineCount() { return numMines; }



    /*
     * Debug methods
     */

    public void printBoard() {
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                switch(board[i][j].getValue()) {
                    case -1:
                    System.out.print(board[i][j].getValue() + " ");
                    break;
                    default:
                    System.out.print(board[i][j].getValue() + "  ");
                    break;
                }
            }
            System.out.println();
        }
    }

    public void printArray(Integer[] arr) {
        for(int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] +  " ");
        }
        System.out.println();
    }

}
