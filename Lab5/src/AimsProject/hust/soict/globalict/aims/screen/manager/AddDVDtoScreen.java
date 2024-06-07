package AimsProject.hust.soict.globalict.aims.screen.manager;

import AimsProject.hust.soict.globalict.aims.media.disc.DigitalVideoDisc;
import AimsProject.hust.soict.globalict.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDVDtoScreen extends JFrame implements ActionListener {
    private final Store store;
    private final JTextField idTF;
    private final JTextField costTF;
    private final JTextField titleTF;
    private final JTextField categoryTF;
    private final JTextField directorTF;
    private final JTextField lengthTF;
    private final JButton addDVD;

    public AddDVDtoScreen(Store store){
        this.store = store; // Initialize the store object
        setLayout(new FlowLayout());
        setSize(350,300);

        JPanel idPanel = new JPanel();
        idPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        idPanel.add(new JLabel("ID: "));
        idTF = new JTextField(20);
        idPanel.add(idTF);

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout());
        titlePanel.add(new JLabel("Title: "));
        titleTF = new JTextField(20);
        titlePanel.add(titleTF);

        JPanel categoryPanel = new JPanel();
        categoryPanel.setLayout(new FlowLayout());
        categoryPanel.add(new JLabel("Category: "));
        categoryTF = new JTextField(20);
        categoryPanel.add(categoryTF);

        JPanel costPanel = new JPanel();
        costPanel.setLayout(new FlowLayout());
        costPanel.add(new JLabel("Cost: "));
        costTF = new JTextField(20);
        costPanel.add(costTF);

        JPanel directorPanel = new JPanel();
        directorPanel.setLayout(new FlowLayout());
        directorPanel.add(new JLabel("Director "));
        directorTF = new JTextField(20);
        directorPanel.add(directorTF);

        JPanel lengthPanel = new JPanel();
        lengthPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        lengthPanel.add(new JLabel("Length: "));
        lengthTF = new JTextField(20);
        lengthPanel.add(lengthTF);

        JPanel addButtonPanel = new JPanel();
        addButtonPanel.setLayout(new BorderLayout());
        addDVD = new JButton("ADD DVD");
        addDVD.addActionListener(this);
        addButtonPanel.add(addDVD, BorderLayout.CENTER);

        add(idPanel);
        add(titlePanel);
        add(categoryPanel);
        add(costPanel);
        add(directorPanel);
        add(lengthPanel);
        add(addButtonPanel);
        setTitle("ADD DVD TO THE STORE");
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addDVD){
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
