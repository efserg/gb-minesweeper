package ru.geekbrains;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class GuiMineSweeper extends JFrame{


    public GuiMineSweeper(String title) throws HeadlessException {
        super(title);
    }

    public void ContentPaneReplace(int HEIGHT, int WIDTH, final int MINE, final int[][] board) {

        Object[][] array = new String[HEIGHT][WIDTH];

        final JTable table = new JTable(HEIGHT, WIDTH);
        table.setRowHeight(30);
        table.setColumnSelectionAllowed(true);
        table.setRowSelectionAllowed(true);
        table.setShowGrid(true);
        table.setGridColor(Color.gray);

        table.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent evt) {

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


        JPanel contents = new JPanel();
        contents.add(table);

        setContentPane(contents);


        setSize(800, 400);

        setVisible(true);
    }
}
