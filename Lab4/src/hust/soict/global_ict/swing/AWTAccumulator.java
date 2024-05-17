package hust.soict.global_ict.swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AWTAccumulator extends Frame implements ActionListener{
	private TextField tfInput;
	private TextField tfOutput;
	private int sum = 0;
	
	public AWTAccumulator() {
		setLayout(new GridLayout(2, 2));
		
		add(new Label("Enter an integer: "));
		
		tfInput = new TextField(10);
		add(tfInput);
		tfInput.addActionListener(this);
		
		add(new Label("The Accumulated sum is: "));
		
		tfOutput = new TextField(10);
		tfOutput.setEditable(false);
		add(tfOutput);
		
		setTitle("AWT Accumulator");
		setSize(350, 120);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AWTAccumulator();
	}
	
	public void actionPerformed(ActionEvent evt) {
		int numberIn = Integer.parseInt(tfInput.getText());
		sum += numberIn;
		tfInput.setText("");
		tfOutput.setText(sum + "");
	
	}
}

