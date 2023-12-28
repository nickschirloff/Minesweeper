package models;

import java.util.Arrays;
import java.util.Random;

public class GameLogic {
    
    private int difficulty;
    private int numMines;
    private int rows, cols;
    private Cell[][] board;
    private Integer[] minesPos;
    Random rand = new Random();

    public GameLogic(int difficulty) {
        this.difficulty = difficulty;
        rows = 10;
        cols = 8 + (difficulty * 2);
    }

    public void generateBoard() {
        board = new Cell[rows][cols];
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
            temp = rand.nextInt(bound) + 1;
            while(Arrays.asList(minesPos).contains(temp))
            {
                temp = rand.nextInt(bound) + 1;
            }
            minesPos[i] = temp;
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
            for(int y1 = y - 1; y1 <= y + 1; y++)
            {
                if(isWithinBounds(x1, y1) && !isMine(x1, y1))
                {
                    board[x1][y1].updateValue();
                }
            }
        }
    }

    private boolean isWithinBounds(int x, int y) {
        return x >= 0 && y >= 0 && x < rows && y < cols;
    }

    private boolean isMine(int x, int y) {
        return board[x][y].getValue() == -1;
    }



    public void printArray(Integer[] arr) {
        for(int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] +  " ");
        }
        System.out.println();
    }

}
