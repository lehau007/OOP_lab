package hust.soict.global_ict.aims.screen.GUI_manager;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.sound.sampled.*;

public class playScreen {
    JDialog playDialog;

    public playScreen(String title, String imagePath, String musicPath) {
        playDialog = new JDialog((Frame) null, "Playing Media", true);
        playDialog.setLayout(new BorderLayout());
        playDialog.setSize(400, 250);
        playDialog.setLocationRelativeTo(null);

        JLabel playMessage = new JLabel("You are watching " + title);
        playMessage.setHorizontalAlignment(SwingConstants.CENTER);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new BtnBackHandler());

        JLabel playImage = new JLabel();
        playImage.setHorizontalAlignment(SwingConstants.CENTER);
        if (imagePath != null && !imagePath.isEmpty()) {
            ImageIcon imageIcon = new ImageIcon(imagePath);
            // Debug statement to check if the image is being loaded
            if (imageIcon.getIconWidth() == -1) {
                System.out.println("Image not found: " + imagePath);
            } else {
                // Scale the image to fit the JLabel
                Image img = imageIcon.getImage();
                Image scaledImg = img.getScaledInstance(400, 200, Image.SCALE_SMOOTH);
                playImage.setIcon(new ImageIcon(scaledImg));
            }
        } else {
            System.out.println("Image path is null or empty.");
        }

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(backButton);

        playDialog.add(playMessage, BorderLayout.NORTH);
        playDialog.add(playImage, BorderLayout.CENTER);
        playDialog.add(buttonPanel, BorderLayout.SOUTH);

        playDialog.setVisible(true);

        // Play music
        playMusic(musicPath);
    }

    private class BtnBackHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            playDialog.dispose();
        }
    }

    private void playMusic(String musicPath) {
        try {
            // Open an audio input stream.
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(getClass().getResource(musicPath));
            // Get a sound clip resource.
            Clip clip = AudioSystem.getClip();
            // Open audio clip and load samples from the audio input stream.
            clip.open(audioIn);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Example usage
        new playScreen("Title", "path/to/image.jpg", "path/to/music.wav");
    }
}

