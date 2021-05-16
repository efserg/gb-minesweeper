package ru.geekbrains;

import java.util.Random;

public class MineSweeper {

    private static final int WIDTH = 10;
    private static final int HEIGHT = 10;
    private static final int MINES = 25;
    private static final int MINE = 1000;
    private static final int EMPTY = 0;


    public static void main(String[] args) {
        play();
    }


    public static boolean play() {
        boolean win = true;
        int[][] board = generateBoard();
        printBoard(board);

        return win;
    }

    private static void printBoard(final int[][] board) {
        System.out.print("   ");
        for (char i = 'A'; i < 'A' + WIDTH; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int i = 0; i < HEIGHT; i++) {
            System.out.printf("%3d", i);
            for (int j = 0; j < WIDTH; j++) {
                if (board[i][j] == EMPTY) {
                    System.out.print(" .");
                } else if (board[i][j] == MINE) {
                    System.out.print(" *");
                } else {
                    System.out.printf("%2d", board[i][j]);
                }
            }
            System.out.println();
        }
    }

    private static int[][] generateBoard() {
        final int[][] board = new int[HEIGHT][WIDTH];
        int mines = MINES;
        final Random random = new Random();
        while (mines > 0) {
            int x, y;
            do {
                x = random.nextInt(HEIGHT);
                y = random.nextInt(WIDTH);
            } while (board[x][y] == MINE);
            board[x][y] = MINE;
            mines--;
        }

        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (board[i][j] == MINE) {
                    continue;
                }
                int mCount = 0;
                for (int k = i - 1; k <= i + 1; k++) {
                    for (int l = j - 1; l <= j + 1; l++) {
                        if (k < 0 || k >= HEIGHT || l < 0 || l >= WIDTH) {
                            continue;
                        }
                        if (board[k][l] == MINE) {
                            mCount++;
                        }
                    }
                }
                board[i][j] = mCount;
            }
        }

        return board;
    }

}
