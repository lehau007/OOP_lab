package AimsProject.hust.soict.globalict.aims.screen.manager;

import AimsProject.hust.soict.globalict.aims.media.disc.CompactDisc;
import AimsProject.hust.soict.globalict.aims.media.disc.Track;
import AimsProject.hust.soict.globalict.aims.store.Store;
import hust.soict.globalict.aims.exception.PlayerException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCDtoScreen extends JFrame implements ActionListener {
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
    public AddCDtoScreen(Store store){
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

        JPanel artistPanel = new JPanel();
        artistPanel.setLayout(new FlowLayout());
        artistPanel.add(new JLabel("Artist: "));
        artistTF = new JTextField(20);
        artistPanel.add(artistTF);

        JPanel trackPanel = new JPanel();
        trackPanel.setLayout(new FlowLayout());
        trackPanel.add(new JLabel("Title: "));
        trackTitleTF = new JTextField(6);
        trackPanel.add(trackTitleTF);
        trackPanel.add(new JLabel("Length: "));
        trackLengthTF = new JTextField(6);
        addTrack = new JButton("ADD");
        addTrack.addActionListener(this);
        trackPanel.add(trackLengthTF);
        trackPanel.add(addTrack);


        JPanel addButtonPanel = new JPanel();
        addButtonPanel.setLayout(new BorderLayout());
        addCD = new JButton("ADD CD");
        addCD.addActionListener(this);
        addButtonPanel.add(addCD, BorderLayout.CENTER);

        add(idPanel);
        add(titlePanel);
        add(categoryPanel);
        add(costPanel);
        add(artistPanel);
        add(trackPanel);
        add(addButtonPanel);
        setTitle("ADD CD TO THE STORE");
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addTrack){
            if(cd != null){
                try{
                    String title = trackTitleTF.getText();
                    int length = Integer.parseInt(trackLengthTF.getText());
                    Track track = new Track(title, length);
                    cd.addTrack(track);
                } catch (NumberFormatException exception){
                    JOptionPane.showMessageDialog(null, "Invalid input", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        if (e.getSource() == addCD){
            try {
                int id = Integer.parseInt(idTF.getText());
                String title = titleTF.getText();
                String category = categoryTF.getText();
                float cost = Float.parseFloat(costTF.getText());
                String artist = artistTF.getText();
                cd = new CompactDisc(id,title,category,artist,cost);
                store.addMedia(cd);
                store.printStore();
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(null, "Invalid input", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
