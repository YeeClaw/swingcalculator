package com.coltaj.javaCalc;

import javax.swing.*;
import java.awt.*;

import static javax.swing.LayoutStyle.ComponentPlacement.RELATED;

public class Calc extends JFrame {

    private JButton clearButton, equal, add, minus, times, divide, sqrt, button1, button2, button3, button4, button5, button6, button7, button8, button9, button0;
    private JLabel answer;


    public Calc() {

        initUI();
    }

    private void initUI() {

        clearButton = new JButton("Clear");
        clearButton.addActionListener(e -> answer.setText(""));
        add = new JButton("+");
        add.addActionListener(e -> answer.setText(answer.getText() + " + "));
        minus = new JButton("-");
        minus.addActionListener(e -> answer.setText(answer.getText() + " - "));
        times = new JButton("*");
        times.addActionListener(e -> answer.setText(answer.getText() + " * "));
        divide = new JButton("/");
        divide.addActionListener(e -> answer.setText(answer.getText() + " / "));
        sqrt = new JButton("Sqrt");
        sqrt.addActionListener(e -> {
            String total;
            if (answer.getText().length() == 1){
                total = Integer.toString((int) Math.sqrt(Integer.parseInt(answer.getText())));
            } else {
                String[] value = answer.getText().split(" ");

                int totalCalc = operLogic(value);
                totalCalc = valueCalc(value, totalCalc);

                total = Integer.toString((int) Math.sqrt(totalCalc));
            }

            answer.setText(total);
        });

        equal = new JButton("=");
        equal.addActionListener(e -> {
            String[] value = answer.getText().split(" ");

            int totalCalc = operLogic(value);
            totalCalc = valueCalc(value, totalCalc);

            String total = Integer.toString(totalCalc);
            answer.setText(total);
        });

        button1 = new JButton("1");
        button1.addActionListener(e -> answer.setText(answer.getText() + "1"));
        button2 = new JButton("2");
        button2.addActionListener(e -> answer.setText(answer.getText() + "2"));
        button3 = new JButton("3");
        button3.addActionListener(e -> answer.setText(answer.getText() + "3"));
        button4 = new JButton("4");
        button4.addActionListener(e -> answer.setText(answer.getText() + "4"));
        button5 = new JButton("5");
        button5.addActionListener(e -> answer.setText(answer.getText() + "5"));
        button6 = new JButton("6");
        button6.addActionListener(e -> answer.setText(answer.getText() + "6"));
        button7 = new JButton("7");
        button7.addActionListener(e -> answer.setText(answer.getText() + "7"));
        button8 = new JButton("8");
        button8.addActionListener(e -> answer.setText(answer.getText() + "8"));
        button9 = new JButton("9");
        button9.addActionListener(e -> answer.setText(answer.getText() + "9"));
        button0 = new JButton("0");
        button0.addActionListener(e -> answer.setText(answer.getText() + "0"));

        answer = new JLabel("", SwingConstants.CENTER);

        createLayout(clearButton, button1, button2, button3, button4, button5, button6, button7, button8, button9, button0, add, minus, times, divide, sqrt, answer, equal);//Method called to place

        setTitle("Calculator");
        setSize(290, 240);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createLayout(JComponent...args){

        var pane = getContentPane();
        var layout = new GroupLayout(pane);
        pane.setLayout(layout);

        layout.setAutoCreateContainerGaps(true);
        //GroupLayout
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addPreferredGap(RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup()
                        .addComponent(args[0])
                        .addComponent(args[4])
                        .addComponent(args[8])
                        .addComponent(args[12])
                        .addComponent(args[16]))
                .addGroup(layout.createParallelGroup()
                        .addComponent(args[1])
                        .addComponent(args[5])
                        .addComponent(args[9])
                        .addComponent(args[13]))
                .addGroup(layout.createParallelGroup()
                        .addComponent(args[2])
                        .addComponent(args[6])
                        .addComponent(args[10])
                        .addComponent(args[14]))
                .addGroup(layout.createParallelGroup()
                        .addComponent(args[17])
                        .addComponent(args[3])
                        .addComponent(args[7])
                        .addComponent(args[11])
                        .addComponent(args[15])));


        layout.setVerticalGroup(layout.createSequentialGroup()

                .addPreferredGap(RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup()
                        .addComponent(args[16])
                        .addComponent(args[17]))
                .addGroup(layout.createParallelGroup()
                        .addComponent(args[0])
                        .addComponent(args[1])
                        .addComponent(args[2])
                        .addComponent(args[3]))
                .addGroup(layout.createParallelGroup()
                        .addComponent(args[4])
                        .addComponent(args[5])
                        .addComponent(args[6])
                        .addComponent(args[7]))
                .addGroup(layout.createParallelGroup()
                        .addComponent(args[8])
                        .addComponent(args[9])
                        .addComponent(args[10])
                        .addComponent(args[11]))
                .addGroup(layout.createParallelGroup()
                        .addComponent(args[12])
                        .addComponent(args[13])
                        .addComponent(args[14])
                        .addComponent(args[15])));

        layout.linkSize(SwingConstants.HORIZONTAL, equal, clearButton, add, minus, times, sqrt, divide, button0, button1, button2, button3, button4, button5, button6, button7, button8, button9);
    }

    public int operLogic(String[] value) {

        int totalCalc = 0;
        switch (value[1]) {
            case "+":
                totalCalc += Integer.parseInt(value[0]) + Integer.parseInt(value[2]);
                break;
            case "-":
                totalCalc += Integer.parseInt(value[0]) - Integer.parseInt(value[2]);
                break;
            case "*":
                totalCalc += Integer.parseInt(value[0]) * Integer.parseInt(value[2]);
                break;
            case "/":
                totalCalc += Integer.parseInt(value[0]) / Integer.parseInt(value[2]);
                break;
        }

        return totalCalc;
    }

    public int valueCalc(String[] value, int totalCalc) {

        for(int i = 3; i < value.length; i++){
            switch (value[i]) {
                case "+":
                    totalCalc += Integer.parseInt(value[i + 1]);
                    break;
                case "-":
                    totalCalc -= Integer.parseInt(value[i + 1]);
                    break;
                case "*":
                    totalCalc *= Integer.parseInt(value[i + 1]);
                    break;
                case "/":
                    totalCalc /= Integer.parseInt(value[i + 1]);
                    break;
            }
        }

        return totalCalc;
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            var gui = new Calc();
            gui.setVisible(true);
        });
    }
}
