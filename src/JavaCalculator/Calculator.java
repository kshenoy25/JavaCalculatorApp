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
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subButton, multButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;

    // declare reusable font
    Font myFont = new Font("Ink Free", Font.BOLD, 20);

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50, 25, 320, 50);
        textField.setFont(myFont);
        textField.setEditable(false);

        // add buttons of calculator functions
        addButton = new JButton("+");
        subButton = new JButton("-");
        multButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");
        negButton = new JButton("(-)");

        // add the buttons to array
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = multButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        for (int i = 0; i < 9; i++) {
            // implementing the action listener interface
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            // outline around the button is lowered for user-friendly experience
            functionButtons[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        negButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(250, 430, 100, 50);

        // adding the panel with remaining functions
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        // background color changed to see the dimensions of the panel and with its functions that will be added
        //panel.setBackground(Color.BLACK);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(multButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);


        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        //set visibility
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // check if someone clicks a button through traversing
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                // lets user display the button that is clicked then displayed
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton) {
            textField.setText(textField.getText().concat("."));
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            // assign operator in single quotes
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            // assign operator in single quotes
            operator = '-';
            textField.setText("");
        }
        if (e.getSource() == multButton) {
            num1 = Double.parseDouble(textField.getText());
            // assign operator in single quotes
            operator = '*';
            textField.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            // assign operator in single quotes
            operator = '/';
            textField.setText("");
        }
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textField.getText());

            // using switch to determine what mathematical operation to perform'
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            // updating the text field
            textField.setText(String.valueOf(result));
            // to reuse the same number and continue
            num1 = result;
        }
        if (e.getSource() == clrButton) {
            textField.setText("");
        }
        if (e.getSource() == delButton) {
            String string = textField.getText();
            textField.setText("");
            // iterates through the length of the String - 1
            for (int i = 0; i < string.length() - 1; i++) {
                textField.setText(textField.getText() + string.charAt(i));
            }
        }
        if (e.getSource() == negButton) {
            double num = Double.parseDouble(textField.getText());
            if (num >= 0) {
                double resultNeg = num * -1;
                textField.setText(resultNeg + " ");
            } else {
                double resultPos = num * -1;
                textField.setText(resultPos + " ");

            }
        /*
        if (e.getSource() == negButton) {

            // retrieve text from text field
            double temp = Double.parseDouble(textField.getText());
            // flip the sign on our temp variable
            temp *= -1;

            // set text to current value of temp
            textField.setText(String.valueOf(temp));
        }

         */

        /*
        try {
            if (e.getSource() == negButton) {
                double num = Double.parseDouble(textField.getText());
                    if (num >= 0){
                        double resultNeg = num * -1;
                        textField.setText(resultNeg + "");
                    }
                    else {
                        double resultPos = num * -1;
                        textField.setText(resultPos + "");
                    }
                }
            }
        catch (NumberFormatException num){
            System.out.println("NumberFormatException occurred");

        }

         */


        }
    }
}