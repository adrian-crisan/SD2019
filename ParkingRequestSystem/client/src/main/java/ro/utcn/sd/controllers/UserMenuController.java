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
import javafx.stage.Stage;
import ro.utcn.sd.output.UserDTO;

public class UserMenuController implements Initializable {

	UserDTO user;

	public void setUser(UserDTO user) {
		this.user = user;
	}

	@FXML
	Button viewRequestsButton;
	
	@FXML
	Button createRequestButton;
	
	@FXML
	Button updateRequestButton;
	
	@FXML 
	Button deleteRequestButton;
	
	@FXML 
	Button addCarButton;
	
	@FXML
	Button deleteCarButton;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		viewRequestsButton.setOnAction(e -> {
			changeSceneToView();
		});
		
		createRequestButton.setOnAction(e -> {
			changeSceneToCreate();
		});
		
		updateRequestButton.setOnAction(e -> {
			changeSceneToUpdate();
		});
		
		deleteRequestButton.setOnAction(e -> {
			changeSceneToDelete();
		});
		
		addCarButton.setOnAction(e -> {
			changeSceneToAddCar();
		});
		
		deleteCarButton.setOnAction(e -> {
			changeSceneToDeleteCar();
		});
	}

	@FXML
	private void changeSceneToView() {
		try {
			Stage window = (Stage) viewRequestsButton.getScene().getWindow();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ViewRequests.fxml"));
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
	private void changeSceneToCreate() {
		try {
			Stage window = (Stage) viewRequestsButton.getScene().getWindow();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CreateRequest.fxml"));
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
	private void changeSceneToUpdate() {
		try {
			Stage window = (Stage) viewRequestsButton.getScene().getWindow();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/UpdateRequest.fxml"));
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
	private void changeSceneToDelete() {
		try {
			Stage window = (Stage) viewRequestsButton.getScene().getWindow();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/DeleteRequest.fxml"));
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
	private void changeSceneToAddCar() {
		try {
			Stage window = (Stage) viewRequestsButton.getScene().getWindow();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AddCar.fxml"));
			Parent root = loader.load();
			
			AddCarController c = loader.<AddCarController>getController();
			c.setUser(user);
			
			window.setTitle("ParkingApp");
			window.setScene(new Scene(root));
		} catch (IOException e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error");
			alert.setContentText(e.getMessage());
		}
	}
	
	@FXML
	private void changeSceneToDeleteCar() {
		try {
			Stage window = (Stage) viewRequestsButton.getScene().getWindow();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/DeleteCar.fxml"));
			Parent root = loader.load();
			
			DeleteCarController c = loader.<DeleteCarController>getController();
			c.setUser(user);
			
			window.setTitle("ParkingApp");
			window.setScene(new Scene(root));
		} catch (IOException e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error");
			alert.setContentText(e.getMessage());
		}
	}
}
