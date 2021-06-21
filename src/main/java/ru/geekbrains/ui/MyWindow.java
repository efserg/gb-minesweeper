package ru.geekbrains.ui;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.*;

public class MyWindow extends JFrame {

    public MyWindow() {
        setTitle("My First UI App");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(200, 200, 400, 400);

        setLayout(null);

        JTextField textField = new JTextField();
        textField.setBounds(140, 20, 300, 40);
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(textField.getText());
            }
        });

        add(textField);

        JButton button = new JButton("button 1");
        button.setBounds(10,20, 100, 40);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random random = new Random();
                textField.setText("Случайное число = " + random.nextInt());
            }
        });
        add(button);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Окно закрывается!");
            }
        });
        setVisible(true);
    }

    public static void main(String[] args) {
        new MyWindow();
    }

}
