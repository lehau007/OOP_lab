package hust.soict.globalict.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Painter extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        // Load the FXML file for the Painter UI
        Parent root = FXMLLoader.load(getClass().getResource("/hust/soict/globalict/javafx/Painter.fxml"));
        
        // Create a new scene with the loaded FXML
        Scene scene = new Scene(root);
        
        // Set the title of the window (stage)
        stage.setTitle("Painter");
        
        // Set the scene to the stage
        stage.setScene(scene);
        
        // Display the stage
        stage.show();
    }

    public static void main(String[] args) {
        // Launch the JavaFX application
        launch(args);
    }
}
