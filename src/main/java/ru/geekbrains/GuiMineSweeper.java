package ru.geekbrains;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class GuiMineSweeper extends JFrame{
    public GuiMineSweeper(String title) throws HeadlessException {
        super(title);
    }

    public void ContentPaneReplace(int HEIGHT, int WIDTH) {

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
                System.out.println(rows);
                System.out.println(columns);
            }
        });

        JPanel contents = new JPanel();
        contents.add(table);

        setContentPane(contents);


        setSize(800, 400);

        setVisible(true);
    }
}
