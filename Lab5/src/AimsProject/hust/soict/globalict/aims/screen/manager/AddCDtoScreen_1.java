package AimsProject.hust.soict.globalict.aims.screen.manager;

import AimsProject.hust.soict.globalict.aims.media.disc.CompactDisc;
import AimsProject.hust.soict.globalict.aims.media.disc.Track;
import AimsProject.hust.soict.globalict.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCDtoScreen_1 extends JFrame implements ActionListener{
    private CompactDisc cd;
    private final Store store;
    private final JTextField idTF;
    private final JTextField costTF;
    private final JTextField titleTF;
    private final JTextField categoryTF;
    private final JTextField artistTF;
    private final JTextField trackTitleTF;
    private final JTextField trackLengthTF;
    private final JButton addTrack;
    private final JButton addCD;

    public AddCDtoScreen_1(Store store) {
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
        add(new JLabel("Artist: "), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        artistTF = new JTextField(20);
        add(artistTF, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weightx = 0;
        add(new JLabel("Track Title: "), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        trackTitleTF = new JTextField(20);
        add(trackTitleTF, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.weightx = 0;
        add(new JLabel("Track Length: "), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        trackLengthTF = new JTextField(20);
        add(trackLengthTF, gbc);

        gbc.gridx = 2;
        gbc.gridy = 6;
        gbc.weightx = 0;
        addTrack = new JButton("ADD TRACK");
        addTrack.addActionListener(this);
        add(addTrack, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        addCD = new JButton("ADD CD");
        addCD.addActionListener(this);
        add(addCD, gbc);

        setTitle("ADD CD TO THE STORE");
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addTrack) {
            if (cd != null) {
                try {
                    String title = trackTitleTF.getText();
                    int length = Integer.parseInt(trackLengthTF.getText());
                    Track track = new Track(title, length);
                    cd.addTrack(track);
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(null, "Invalid input", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        if (e.getSource() == addCD) {
            try {
                int id = Integer.parseInt(idTF.getText());
                String title = titleTF.getText();
                String category = categoryTF.getText();
                float cost = Float.parseFloat(costTF.getText());
                String artist = artistTF.getText();
                cd = new CompactDisc(id, title, category, artist, cost);
                store.addMedia(cd);
                store.printStore();
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(null, "Invalid input", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
