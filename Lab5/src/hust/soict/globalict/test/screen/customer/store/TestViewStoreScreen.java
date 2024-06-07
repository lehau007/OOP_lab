package hust.soict.globalict.test.screen.customer.store;

import AimsProject.hust.soict.globalict.aims.cart.Cart;
import AimsProject.hust.soict.globalict.aims.media.book.Book;
import AimsProject.hust.soict.globalict.aims.media.disc.CompactDisc;
import AimsProject.hust.soict.globalict.aims.media.disc.DigitalVideoDisc;
import AimsProject.hust.soict.globalict.aims.store.Store;
import hust.soict.globalict.aims.screen.customer.controller.ViewStoreController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application {
    private static Store store;
    private static Cart cart;

    @Override
    public void start(Stage primaryStage) throws Exception {
        final String STORE_FXML_FILE_PATH = "/hust/soict/globalict/aims/screen/customer/view/Store.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
        ViewStoreController viewStoreController = new ViewStoreController(store, cart);
        fxmlLoader.setController(viewStoreController);
        Parent root = fxmlLoader.load();

        primaryStage.setTitle("STORE");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        initializeStore();
        cart = new Cart();
        launch(args);
    }

    private static void initializeStore() {
        store = new Store();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Aladdin", "Animation", 18.99f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc(4, "Aladdin", "Animation", 18.99f);
        CompactDisc cd1 = new CompactDisc(5, "Avatar", "Action", 12.2f);
        Book book1 = new Book(6, "Dracula", "Horror", 43.2f);
        
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(dvd4);
        store.addMedia(cd1);
        store.addMedia(book1);
    }
}
