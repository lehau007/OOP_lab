package AimsProject.hust.soict.globalict.aims.screen.manager;

import AimsProject.hust.soict.globalict.aims.media.disc.DigitalVideoDisc;
import AimsProject.hust.soict.globalict.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDVDtoScreen_1 extends JFrame implements ActionListener {
    private final Store store;
    private final JTextField idTF;
    private final JTextField costTF;
    private final JTextField titleTF;
    private final JTextField categoryTF;
    private final JTextField directorTF;
    private final JTextField lengthTF;
    private final JButton addDVD;

    public AddDVDtoScreen_1(Store store) {
        this.store = store; // Initialize the store object
        setLayout(new GridBagLayout());
        setSize(400, 350);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        add(new JLabel("ID: "), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        idTF = new JTextField(20);
        add(idTF, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        add(new JLabel("Title: "), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        titleTF = new JTextField(20);
        add(titleTF, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;
        add(new JLabel("Category: "), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        categoryTF = new JTextField(20);
        add(categoryTF, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0;
        add(new JLabel("Cost: "), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        costTF = new JTextField(20);
        add(costTF, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 0;
        add(new JLabel("Director: "), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        directorTF = new JTextField(20);
        add(directorTF, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weightx = 0;
        add(new JLabel("Length: "), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        lengthTF = new JTextField(20);
        add(lengthTF, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        addDVD = new JButton("ADD DVD");
        addDVD.addActionListener(this);
        add(addDVD, gbc);

        setTitle("ADD DVD TO THE STORE");
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addDVD) {
            try {
                int id = Integer.parseInt(idTF.getText());
                String title = titleTF.getText();
                String category = categoryTF.getText();
                float cost = Float.parseFloat(costTF.getText());
                String director = directorTF.getText();
                int length = Integer.parseInt(lengthTF.getText());
                DigitalVideoDisc dvd = new DigitalVideoDisc(id, title, category, director, length, cost);
                store.addMedia(dvd);
                store.printStore();
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(null, "Invalid input", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
