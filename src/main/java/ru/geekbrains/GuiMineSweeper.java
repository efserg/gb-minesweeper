package ru.geekbrains;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
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
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) table.getDefaultRenderer(String.class);
        renderer.setHorizontalAlignment(SwingConstants.CENTER);

        table.setFont(new Font(null, Font.BOLD, 14));
        table.setRowHeight(30);
        table.setColumnSelectionAllowed(true);
        table.setRowSelectionAllowed(true);
        table.setShowGrid(true);
        table.setGridColor(Color.gray);

        table.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                buttonNew.setVisible(true);
                buttonReset.setVisible(true);

                int column = table.columnAtPoint(e.getPoint());
                int row = table.rowAtPoint(e.getPoint());
                int value = board[row][column];

                switch (e.getButton()) {
                    case MouseEvent.BUTTON1:
                        if (value == MINE) {
                            table.setValueAt("*", row, column);

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
                            table.setValueAt(value, row, column);
                        }
                        break;
                    case  MouseEvent.BUTTON3:

                        table.setColumnSelectionInterval(column, column);
                        table.setRowSelectionInterval(row, row);
                        table.setValueAt("F", row, column);
                        break;
                }


            }
        });

        buttonReset.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
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
            public void mousePressed(MouseEvent e) {
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
