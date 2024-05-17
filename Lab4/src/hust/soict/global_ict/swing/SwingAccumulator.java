package hust.soict.global_ict.swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SwingAccumulator extends JFrame {
    private JTextField tfInput;
    private JTextField tfOutput;
    private int sum = 0;

    public SwingAccumulator() {
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(2, 2));
        cp.add(new JLabel("Enter an integer: "));

        tfInput = new JTextField(10);
        cp.add(tfInput);
        
        // Use an anonymous inner class to implement ActionListener
        tfInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int numberIn = Integer.parseInt(tfInput.getText());
                    sum += numberIn;
                    tfInput.setText("");
                    tfOutput.setText(Integer.toString(sum));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(SwingAccumulator.this, "Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        cp.add(new JLabel("The accumulated sum is: "));

        tfOutput = new JTextField(10);
        tfOutput.setEditable(false);
        cp.add(tfOutput);

        setTitle("Swing Accumulator");
        setSize(300, 120); // Adjusted size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Added
        setVisible(true);
    }

    public static void main(String[] args) {
        new SwingAccumulator();
    }
}

