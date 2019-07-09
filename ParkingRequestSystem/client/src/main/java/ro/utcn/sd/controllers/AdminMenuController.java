package ro.utcn.sd.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdminMenuController implements Initializable {

	@FXML
	private Button viewParkingLotsButton;
	
	@FXML
	private Button viewRequestsByParkingLot;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		viewRequestsByParkingLot.setOnAction(e -> {
			changeSceneToRequests();
		});
		
	}

	@FXML
	private void changeSceneToRequests() {
		try {
			Stage window = (Stage) viewRequestsByParkingLot.getScene().getWindow();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ViewRequestsByParkingLot.fxml"));
			Parent root = loader.load();
			window.setTitle("ParkingApp");
			window.setScene(new Scene(root));
		} catch (IOException e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error");
			alert.setContentText(e.getMessage());
		}
	}
	
	@FXML
	private void changeSceneToParkingLot() {
		
	}
}
