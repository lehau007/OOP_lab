package hust.soict.global_ict.aims.screen.GUI_manager;

import java.awt.Component;
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

import hust.soict.global_ict.aims.media.Book;
import hust.soict.global_ict.aims.store.Store;

public class AddBookToStoreScreen extends Screen implements ActionListener {
    private JTextField titleField, categoryField, costField, authorField;

    public AddBookToStoreScreen(Store store) {
        super(store);
    }

    JPanel createCenter() {
        JPanel centerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gridConstraints = new GridBagConstraints();
        gridConstraints.anchor = GridBagConstraints.WEST;
        gridConstraints.insets = new Insets(10, 10, 10, 10);

        // Title components
        JLabel titleLabel = new JLabel("Enter title:");
        titleField = new JTextField(20);
        addComponents(centerPanel, titleLabel, titleField, gridConstraints);

        // Category components
        JLabel categoryLabel = new JLabel("Enter category:");
        categoryField = new JTextField(20);
        gridConstraints.gridy++;
        addComponents(centerPanel, categoryLabel, categoryField, gridConstraints);

        // Cost components
        JLabel costLabel = new JLabel("Enter cost:");
        costField = new JTextField(20);
        gridConstraints.gridy++;
        addComponents(centerPanel, costLabel, costField, gridConstraints);

        // Authors components
        JLabel authorsLabel = new JLabel("Enter authors' name:");
        authorField = new JTextField(20);
        gridConstraints.gridy++;
        addComponents(centerPanel, authorsLabel, authorField, gridConstraints);

        // Submit button
        JButton submitButton = new JButton("Submit");
        submitButton.setPreferredSize(new Dimension(100, 30));
        gridConstraints.gridy++;
        gridConstraints.fill = GridBagConstraints.HORIZONTAL;
        centerPanel.add(submitButton, gridConstraints);

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

    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("Add CD")) {
            dispose();
            new AddCompactDiscToStoreScreen(store);
        } else if (action.equals("Add DVD")) {
            dispose();
            new AddDigitalVideoDiscToStoreScreen(store);
        } else if (action.equals("Submit")) {
            String title = titleField.getText();
            String category = categoryField.getText();
            float cost = Float.parseFloat(costField.getText());
            ArrayList<String> authors = new ArrayList<String>();
            String author = authorField.getText();
            String temp = "";
            for (int i = 0; i < author.length(); i++) {
                if (author.charAt(i) != ',') {
                    temp += author.charAt(i);
                } else {
                    authors.add(temp);
                    temp = "";
                }
            }
            authors.add(temp); // Add the last author
            Book book = new Book(1, title, category, cost, authors);
            store.addMedia(book);
            JOptionPane.showMessageDialog(this, "The book has been added successfully!!!");
            dispose();
            new StoreManagerScreen(store);
        } else {
            dispose();
            new StoreManagerScreen(store);
        }
    }
}
