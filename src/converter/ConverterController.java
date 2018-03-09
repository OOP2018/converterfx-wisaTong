package converter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class ConverterController {

	@FXML
	TextField textField1;
	@FXML
	TextField textField2;
	@FXML
	ComboBox<Length> comboBox1;
	@FXML
	ComboBox<Length> comboBox2;

	/** Convert a distance from one unit to another */
	public void handleConvert(ActionEvent event) {
		// read values from textfield
		try {
			String text1 = textField1.getText().trim();
			String text2 = textField2.getText().trim();
			
			double scale1 = comboBox1.getValue().getValue();
			double scale2 = comboBox2.getValue().getValue();

			if (!text1.isEmpty()) {
				double value = Double.parseDouble(text1);
				textField2.setText(String.format("%.4g", (value * scale1) / scale2));
			} else {
				double value = Double.parseDouble(text2);
				textField1.setText(String.format("%.4g", (value * scale2) / scale1));
			}
		} catch (NumberFormatException ex) {
			
			textField1.setStyle("-fx-text-inner-color: red;");
			textField2.setStyle("-fx-text-inner-color: red;");
			textField2.setText("invalid");
			
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Exception caugth");
			alert.setHeaderText(null);
			alert.setContentText("Invalid input!");

			alert.showAndWait();
		}
	}
	
	/** Clear textField */
	public void handleClear(ActionEvent event) {
		textField1.clear();
		textField2.clear();
		textField1.setStyle("-fx-text-inner-color: black;");
		textField2.setStyle("-fx-text-inner-color: black;");
	}

	/**
	 * JavaFX calls the initialize() method of your controller when it creates the
	 * UI form, after the components have been created and @FXML annotated
	 * attributes have been set.
	 *
	 * This is a hook to initialize anything your controller or UI needs.
	 */
	@FXML
	public void initialize() {
		// This is for testing
		System.out.println("Running initialize");
		if (comboBox1 != null) {
			comboBox1.getItems().addAll(Length.values());
			comboBox1.getSelectionModel().select(0); // select an item to show
		}
		if (comboBox2 != null) {
			comboBox2.getItems().addAll(Length.values());
			comboBox2.getSelectionModel().select(1); // select an item to show
		}
	}

}
