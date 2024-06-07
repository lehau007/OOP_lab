package hust.soict.globalict.javafx;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {
    @FXML
    private RadioButton penButton;
    @FXML
    private RadioButton eraserButton;
    @FXML
    private ToggleGroup buttonGroup;
	@FXML
	private Pane drawingAreaPane;
    @FXML
    public void initialize() {
        buttonGroup = new ToggleGroup();
        penButton.setToggleGroup(buttonGroup);
        eraserButton.setToggleGroup(buttonGroup);
        penButton.setSelected(true);
    }
	@FXML 
	void clearButtonPressed(ActionEvent event) {
		drawingAreaPane.getChildren().clear();
	}
	@FXML
	void drawingAreaMouseDragged(MouseEvent event) {
		Circle newCircle;
		if (penButton.isSelected()) {
			newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
		} else {
			newCircle = new Circle(event.getX(), event.getY(), 4, Color.WHITE);
		}
		drawingAreaPane.getChildren().add(newCircle);

	}
	@FXML
	void drawingAreaMouseClicked(MouseEvent event) {
		Circle newCircle;
		if (penButton.isSelected()) {
			newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
		} else {
			newCircle = new Circle(event.getX(), event.getY(), 4, Color.WHITE);
		}
		drawingAreaPane.getChildren().add(newCircle);
	}
}
