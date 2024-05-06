/*
Name: Four.
Date: originally written on Apr 16 2024.
Class: CS 145.
Assignment: Lab 2: Target Heart Rate.
Purpose: Creates an application where a user can input info and receive data about their target heart rate,
based on data from the American Heart Association.

WARNING: I MADE THIS PROGRAM WITH JDK VERSION 22. I CANNOT GUARANTEE IT WILL WORK WITH EARLIER VERSIONS.
 */
import javax.swing.*;
// AWT for the button
import java.awt.*;
import java.awt.event.*;

// I'm still learning how to use Swing.
// but from what I know, this extends the JFrame class to create our own custom "frame" or window,
// then we just need to set certain parameters.
public class HeartRateGUI extends JFrame {
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField birthMonthField;
    private JTextField birthDayField;
    private JTextField birthYearField;

    public static void main(String[] args) {
        // Creates an object to run the program
        new HeartRateGUI();
    }

    // Creates the window.
    public HeartRateGUI() {
        // The name of the window
        super("Heart Rate Calculator");
        initComponents();
        // 6 rows, 2 cols
        setLayout(new GridLayout(6, 2));
        addComponents();
        setVisible(true);
    }

    // Initiates components for the window, such as fields (text boxes) and the size.
    private void initComponents() {
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize text fields
        firstNameField = new JTextField();
        lastNameField = new JTextField();
        birthMonthField = new JTextField();
        birthDayField = new JTextField();
        birthYearField = new JTextField();
    }

    // Actually put the components we just initialized onto the window.
    private void addComponents() {
        // Add labels and fields
        add(new JLabel("First Name:"));
        add(firstNameField);
        add(new JLabel("Last Name:"));
        add(lastNameField);
        add(new JLabel("Birth Month:"));
        add(birthMonthField);
        add(new JLabel("Birth Day:"));
        add(birthDayField);
        add(new JLabel("Birth Year:"));
        add(birthYearField);


        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // When the button is clicked, calculate the heart rate.
                // And pass in everything it needs.
                HeartRateCalculator.calculateHeartRate(
                        firstNameField.getText(),
                        lastNameField.getText(),
                        birthMonthField.getText(),
                        birthDayField.getText(),
                        birthYearField.getText(),
                        HeartRateGUI.this
                );
            }
        });
        add(calculateButton);
    }

    // Is called from the calculator to open a pane for the final heart rate info
    public void displayHeartRateInfo(String info) {
        JOptionPane.showMessageDialog(this, info, "Heart Rate Information",
                JOptionPane.INFORMATION_MESSAGE);
    }

    // Is called from the calculator to send an error message.
    public void displayErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    // End of class
}
