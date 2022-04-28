package ru.geekbrains;

import sun.print.DialogOwner;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

import static javax.swing.JColorChooser.createDialog;

public class GuiMineSweeper extends JFrame{

    private int click;

    public GuiMineSweeper(String title) throws HeadlessException {
        super(title);
    }

    public void ContentPaneReplace(int HEIGHT, int WIDTH, final int MINE, final int[][] board) {

        Object[][] array = new String[HEIGHT][WIDTH];

        final JTable table = new JTable(HEIGHT, WIDTH);
        table.setRowHeight(30);
        table.setSelectionMode(0);
        table.setColumnSelectionAllowed(true);
        table.setRowSelectionAllowed(true);
        table.setShowGrid(true);
        table.setGridColor(Color.gray);

        ListSelectionModel selectionModel = table.getSelectionModel();
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

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

                System.out.println(board[rows][columns]);
            }
        });


        JPanel contents = new JPanel();
        contents.add(table);

        setContentPane(contents);


        setSize(800, 400);

        setVisible(true);
    }
}
