package hust.soict.globalict.aims.screen.customer.controller;

import javax.swing.JOptionPane;

import AimsProject.hust.soict.globalict.aims.cart.Cart;
import AimsProject.hust.soict.globalict.aims.media.Media;
import AimsProject.hust.soict.globalict.aims.media.Playable;
import AimsProject.hust.soict.globalict.aims.media.disc.CompactDisc;
import AimsProject.hust.soict.globalict.aims.media.disc.DigitalVideoDisc;
import AimsProject.hust.soict.globalict.aims.media.disc.Track;
import AimsProject.hust.soict.globalict.aims.store.Store;
import hust.soict.globalict.aims.exception.LimitExceededException;
import hust.soict.globalict.aims.exception.PlayerException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ItemController {
    private Media media;
    private Cart cart;
    private Store store;

    @FXML
    private Label lblTitle;

    @FXML
    private Label lblCost;

    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    void btnAddToCartClicked(ActionEvent event) throws LimitExceededException {
        cart.addMedia(media, store);
    }

    @FXML
    void btnPlayClicked(ActionEvent event) throws PlayerException {
        if (media instanceof DigitalVideoDisc) {
            playDigitalVideoDisc((DigitalVideoDisc) media);
        } else if (media instanceof CompactDisc) {
            playCompactDisc((CompactDisc) media);
        }
    }

    private void playDigitalVideoDisc(DigitalVideoDisc dvd) throws PlayerException {
        if (dvd.getLength() > 0) {
            showAlert("Playing DVD: " + dvd.getTitle() + "\nLength: " + dvd.getLength());
        } else {
            showError("ERROR: DVD length is non-positive!", "Illegal DVD Length");
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }
    }

    private void playCompactDisc(CompactDisc cd) throws PlayerException {
        StringBuilder output = new StringBuilder("Playing CD: " + cd.getTitle() + "\n");
        for (Track track : cd.getTracks()) {
            if (track.getLength() > 0) {
                output.append("Track: ").append(track.getTitle()).append(". Length: ").append(track.getLength()).append("\n");
            } else {
                showError("ERROR: Track length is non-positive!", "Illegal Track Length");
                throw new PlayerException("ERROR: Track length is non-positive!");
            }
        }
        showAlert(output.toString());
    }

    private void showAlert(String message) {
        Alert dialog = new Alert(Alert.AlertType.INFORMATION);
        dialog.setTitle("Media Player");
        dialog.setHeaderText("You are playing media...");
        dialog.setContentText(message);
        dialog.showAndWait();
    }

    private void showError(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.WARNING_MESSAGE);
    }

    public ItemController(Cart cart, Store store) {
        this.cart = cart;
        this.store = store;
    }

    public void setData(Media media) {
        this.media = media;
        lblTitle.setText(media.getTitle());
        lblCost.setText("$" + media.getCost());
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
            HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 60));
        }
    }
}
