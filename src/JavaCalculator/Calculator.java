// everything related java imports


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];

    // array of JButtons to hold our function buttons
    JButton[] functionButtons = new JButton[8];
    JButton addButton, subButton, multButton, divButton;
    JButton decButton, equButton, delButton, clrButton;
    JPanel panel;

    // declare reusable font
    Font myFont = new Font("Ink Free", Font.BOLD, 20);

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    Calculator(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);

        //set visibility
        frame.setVisible(true);

        }
    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
