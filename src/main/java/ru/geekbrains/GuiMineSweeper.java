package ru.geekbrains;

import sun.applet.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class GuiMineSweeper extends JFrame {

    private int[][] board;

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public GuiMineSweeper(String title) throws HeadlessException {
        super(title);
    }

    public void ContentPaneReplace(int HEIGHT, int WIDTH, final int MINE) {
        final JButton buttonNew = new JButton("Новая игра");
        buttonNew.setVisible(false);
        final JButton buttonReset = new JButton("Сбросить");
        buttonReset.setVisible(false);

        final JTable table = new JTable(HEIGHT, WIDTH);
        table.setRowHeight(30);
        table.setColumnSelectionAllowed(true);
        table.setRowSelectionAllowed(true);
        table.setShowGrid(true);
        table.setGridColor(Color.gray);

        table.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent evt) {
                buttonNew.setVisible(true);
                buttonReset.setVisible(true);
                int rows = table.getSelectedRows()[0];
                int columns = table.getSelectedColumns()[0];
                int value = board[rows][columns];
                if (value == MINE) {
                    table.setValueAt("*", rows, columns);
                    JOptionPane.showMessageDialog(null, "Вы проиграли!");
                    for (int i = 0; i < board.length; i++) {
                        for (int j = 0; j < board[i].length; j++) {
                            int val = board[i][j];
                            if (val == MINE) {
                                table.setValueAt("*", i, j);
                            } else {
                                table.setValueAt(val, i, j);
                            }
                        }
                    }

                } else {
                    table.setValueAt(value, rows, columns);
                }
            }
        });

        buttonReset.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                buttonNew.setVisible(false);
                buttonReset.setVisible(false);
                for (int i = 0; i < board.length; i++) {
                    for (int j = 0; j < board[i].length; j++) {
                        table.setValueAt("", i, j);
                    }
                }
            }
        });

        buttonNew.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                buttonNew.setVisible(false);
                buttonReset.setVisible(false);
                board = MineSweeper.generateBoard();
                for (int i = 0; i < board.length; i++) {
                    for (int j = 0; j < board[i].length; j++) {
                        table.setValueAt("", i, j);
                    }
                }
            }
        });

        JPanel contents = new JPanel();
        contents.add(table);
        contents.add(buttonNew);
        contents.add(buttonReset);

        setContentPane(contents);


        setSize(800, 400);

        setVisible(true);
    }
}
