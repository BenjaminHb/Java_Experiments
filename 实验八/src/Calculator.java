import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by benjaminzhang on 16/05/2017.
 * Copyright © benjaminzhang 2017.
 */
public class Calculator {
    private JButton buttonAdd;
    private JButton buttonAC;
    private JButton buttonDiv;
    private JButton buttonSub;
    private JButton buttonMul;
    private JTextField textOperand1;
    private JTextField textOperand2;
    private JTextField textResult;
    private JPanel Calculator;
    private JLabel labelOperand1;
    private JLabel labelOperand2;
    private JLabel labelResult;
    private JPanel JPanelLabel;
    private JPanel JPanelBotton;
    private JPanel JPanelNums;
    private JPanel JPanelText;

    public Calculator() {
        buttonAdd.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e Button Add is pressed.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                double temp = Double.parseDouble(textOperand1.getText()) + Double.parseDouble(textOperand2.getText());
                textResult.setText(Double.toString(temp));
            }
        });
        buttonSub.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e Button Sub is pressed.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                double temp = Double.parseDouble(textOperand1.getText()) - Double.parseDouble(textOperand2.getText());
                textResult.setText(Double.toString(temp));
            }
        });
        buttonMul.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e Button Mul is pressed.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                double temp = Double.parseDouble(textOperand1.getText()) * Double.parseDouble(textOperand2.getText());
                textResult.setText(Double.toString(temp));
            }
        });
        buttonDiv.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e Button Div is pressed.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                double temp = Double.parseDouble(textOperand1.getText()) / Double.parseDouble(textOperand2.getText());
                textResult.setText(Double.toString(temp));
            }
        });
        buttonAC.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e Button AC is pressed.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                textOperand1.setText("0");
                textOperand2.setText("0");
                textResult.setText("0");
            }
        });
        textOperand1.addKeyListener(new KeyAdapter() {
            /**
             * Block illegal input.
             * Invoked when a key has been typed.
             * This event occurs when a key press is followed by a key release.
             *
             * @param e Key typed.
             */
            @Override
            public void keyTyped(KeyEvent e) {
                int keyChar = e.getKeyChar();
                if(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9 || keyChar == KeyEvent.VK_DELETE || keyChar == KeyEvent.VK_PERIOD){

                }else{
                    e.consume();
                }
            }
        });
        textOperand2.addKeyListener(new KeyAdapter() {
            /**
             * Block illegal input.
             * Invoked when a key has been typed.
             * This event occurs when a key press is followed by a key release.
             *
             * @param e Key typed.
             */
            @Override
            public void keyTyped(KeyEvent e) {
                int keyChar = e.getKeyChar();
                if(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9 || keyChar == KeyEvent.VK_DELETE || keyChar == KeyEvent.VK_PERIOD){

                }else{
                    e.consume();
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(new Calculator().Calculator);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(447,163);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }
}