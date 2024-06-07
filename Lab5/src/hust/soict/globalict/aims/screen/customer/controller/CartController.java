package hust.soict.globalict.aims.screen.customer.controller;

import java.io.IOException;

import javax.swing.JOptionPane;

import AimsProject.hust.soict.globalict.aims.cart.Cart;
import AimsProject.hust.soict.globalict.aims.media.Media;
import AimsProject.hust.soict.globalict.aims.media.Playable;
import AimsProject.hust.soict.globalict.aims.media.disc.CompactDisc;
import AimsProject.hust.soict.globalict.aims.media.disc.DigitalVideoDisc;
import AimsProject.hust.soict.globalict.aims.media.disc.Track;
import AimsProject.hust.soict.globalict.aims.store.Store;
import hust.soict.globalict.aims.exception.PlayerException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CartController {
    private Cart cart;
    private Store store;

    @FXML
    private TextField tfFilter;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private Label costLabel;

    @FXML
    private Button btnViewStore;

    public CartController(Cart cart, Store store) {
        this.cart = cart;
        this.store = store;
        this.cart.setCartController(this);
    }

    @FXML
    public void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));

        ObservableList<Media> itemsOrdered = cart.getItemOrdered();
        if (itemsOrdered != null) {
            tblMedia.setItems(itemsOrdered);
        }

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) -> {
            updateButtonBar(newValue);
        });

        tfFilter.textProperty().addListener((obs, oldValue, newValue) -> {
            showFilteredMedia(newValue);
        });

        setTotalCost(cart.totalCost());
    }

    @FXML
    void btnPlaceOrderClicked(ActionEvent event) {
        cart.clearItems();
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null && media instanceof Playable) {
            playMedia((Playable) media);
        }
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null) {
            cart.removeMedia(media);
        }
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/hust/soict/globalict/aims/screen/customer/view/Store.fxml"));
            ViewStoreController viewStoreController = new ViewStoreController(store, cart);
            fxmlLoader.setController(viewStoreController);
            Parent root = fxmlLoader.load();
            Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
            primaryStage.setTitle("STORE");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    void showFilteredMedia(String newValue) {
        // TODO: Implement filtering logic based on newValue
    }

    void updateButtonBar(Media media) {
        boolean isPlayable = media instanceof Playable;
        btnPlay.setVisible(isPlayable);
        btnRemove.setVisible(media != null);
    }

    void setTotalCost(float totalCost) {
        costLabel.setText(totalCost + "$");
    }

    void playMedia(Playable media) {
        StringBuilder output = new StringBuilder();
        if (media instanceof DigitalVideoDisc) {
            output.append("Playing DVD: ").append(media.getTitle()).append("\nLength: ").append(((DigitalVideoDisc) media).getLength());
        } else if (media instanceof CompactDisc) {
            output.append("Playing CD: ").append(media.getTitle()).append("\n");
            for (Track track : ((CompactDisc) media).getTracks()) {
                if (track.getLength() >= 0) {
                    output.append("Track: ").append(track.getTitle()).append(". Length: ").append(track.getLength()).append("\n");
                } else {
                    showError("ERROR: Track length is non-positive!", "Illegal Track Length");
                    return;
                }
            }
        }
        showAlert("You are playing media...", output.toString());
    }

    void showAlert(String headerText, String contentText) {
        Alert dialog = new Alert(AlertType.INFORMATION);
        dialog.setTitle("Media Player");
        dialog.setHeaderText(headerText);
        dialog.setContentText(contentText);
        dialog.showAndWait();
    }

    void showError(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.WARNING_MESSAGE);
    }
}
