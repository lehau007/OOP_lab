package hust.soict.global_ict.aims.screen.GUI_manager;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.global_ict.aims.media.Track;
import hust.soict.global_ict.aims.media.CompactDisc;
import hust.soict.global_ict.aims.store.Store;

public class AddCompactDiscToStoreScreen extends Screen implements ActionListener {
	private JTextField titleInput, categoryInput, costInput, authorInput, trackNameInput, trackLengthInput;
	public AddCompactDiscToStoreScreen(Store store) {
		super(store);
	}
	
	JPanel createCenter() {
	    JPanel center = new JPanel(new GridBagLayout());
	    GridBagConstraints gbc = new GridBagConstraints();
	    gbc.anchor = GridBagConstraints.WEST;
	    gbc.insets = new Insets(10, 10, 10, 10);

	    // Title components
	    JLabel titleLabel = new JLabel("Enter title:");
	    titleInput = new JTextField(20);
	    addComponents(center, titleLabel, titleInput, gbc);

	    // Category components
	    JLabel categoryLabel = new JLabel("Enter category:");
	    categoryInput = new JTextField(20);
	    gbc.gridy++;
	    addComponents(center, categoryLabel, categoryInput, gbc);

	    // Cost components
	    JLabel costLabel = new JLabel("Enter cost:");
	    costInput = new JTextField(20);
	    gbc.gridy++;
	    addComponents(center, costLabel, costInput, gbc);

	    // Authors components
	    JLabel authorsLabel = new JLabel("Enter authors' name:");
	    authorInput = new JTextField(20);
	    gbc.gridy++;
	    addComponents(center, authorsLabel, authorInput, gbc);

	    // Submit button
	    JButton submitButton = new JButton("Submit");
	    submitButton.setPreferredSize(new Dimension(100, 30));
	    gbc.gridy++;
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    center.add(submitButton, gbc);

	    // Add action listener to the submit button
	    submitButton.addActionListener(this);

	    return center;
	}


	private void addComponents(JPanel panel, JLabel label, JTextField textField, GridBagConstraints gbc) {
	    gbc.gridx = 0;
	    gbc.gridwidth = 1;
	    panel.add(label, gbc);

	    gbc.gridx = 1;
	    gbc.gridwidth = 2;
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    panel.add(textField, gbc);

	    gbc.gridy++;
	}

	
	public void actionPerformed(ActionEvent e){
		String action = e.getActionCommand();
        if (action.equals("Add Book")){
        	dispose();
            new AddBookToStoreScreen(store);
        }
        else if (action.equals("Add DVD")){
            dispose();
            new AddDigitalVideoDiscToStoreScreen(store);
        }
        else if (action.equals("Submit")){
        	String title = titleInput.getText();
            String category = categoryInput.getText();
            float cost = Float.parseFloat(costInput.getText());
            String artist = authorInput.getText();
            CompactDisc compactDisc = new CompactDisc(1, title, category, cost, artist);
            store.addMedia(compactDisc);
            JOptionPane.showMessageDialog(this, "The CD has been added successfully!!!");
            dispose();
            new StoreManagerScreen(store);

        }
        else{
            dispose();
            new StoreManagerScreen(store);
        }
    }
}
