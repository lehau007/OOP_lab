package hust.soict.global_ict.aims.screen.GUI_manager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import hust.soict.global_ict.aims.media.DigitalVideoDisc;
import hust.soict.global_ict.aims.store.Store;

public class AddDigitalVideoDiscToStoreScreen extends Screen implements ActionListener{
    private JTextField titleInput, categoryInput, costInput, directorInput, lengthInput;

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store);
    }
    
    JPanel createCenter() {
        JPanel centerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Title components
        JLabel titleLabel = new JLabel("Enter title:");
        titleInput = new JTextField(20);
        addComponents(centerPanel, titleLabel, titleInput, gbc);

        // Category components
        JLabel categoryLabel = new JLabel("Enter category:");
        categoryInput = new JTextField(20);
        gbc.gridy++;
        addComponents(centerPanel, categoryLabel, categoryInput, gbc);

        // Director components
        JLabel directorLabel = new JLabel("Enter director:");
        directorInput = new JTextField(20);
        gbc.gridy++;
        addComponents(centerPanel, directorLabel, directorInput, gbc);

        // Cost components
        JLabel costLabel = new JLabel("Enter cost:");
        costInput = new JTextField(20);
        gbc.gridy++;
        addComponents(centerPanel, costLabel, costInput, gbc);

        // Length components
        JLabel lengthLabel = new JLabel("Enter length:");
        lengthInput = new JTextField(20);
        gbc.gridy++;
        addComponents(centerPanel, lengthLabel, lengthInput, gbc);

        // Submit button
        JButton submitButton = new JButton("Submit");
        submitButton.setPreferredSize(new Dimension(100, 30));
        gbc.gridy++;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        centerPanel.add(submitButton, gbc);

        // Add action listener to the submit button
        submitButton.addActionListener(this);

        return centerPanel;
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

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("Add Book")) {
            dispose();
            new AddBookToStoreScreen(store);
        } else if (action.equals("Add CD")) {
            dispose();
            new AddDigitalVideoDiscToStoreScreen(store);
        } else if (action.equals("Submit")) {
            String title = titleInput.getText();
            String category = categoryInput.getText();
            float cost = Float.parseFloat(costInput.getText());
            String artist = directorInput.getText();
            int length = Integer.parseInt(lengthInput.getText());
            DigitalVideoDisc dvd = new DigitalVideoDisc(1, title, category, artist, length, cost);
            store.addMedia(dvd);
            JOptionPane.showMessageDialog(this, "The DVD has been added successfully!!!");
            dispose();
            new StoreManagerScreen(store);
        } else {
            dispose();
            new StoreManagerScreen(store);
        }
    }
}
