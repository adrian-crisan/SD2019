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
import ro.utcn.sd.output.UserDTO;

public class RegisterAccountController implements Initializable {

	@FXML 
	private Button createAccountButton;
	
	@FXML
	private TextField usernameTextField;
	
	@FXML
	private TextField passwordTextField;
	
	@FXML
	private TextField emailTextField;
	
	@FXML
	private TextField nameTextField;
	
	@FXML
	private Button backButton;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		createAccountButton.setOnAction(e -> {
			createAccount();
		});
		
		backButton.setOnAction(e -> {
			back();
		});
	}

	@FXML
	private void createAccount() {
		String username = usernameTextField.getText().toString();
		String password = passwordTextField.getText().toString();
		String email = emailTextField.getText().toString();
		String name = nameTextField.getText().toString();
		
		UserDTO user = new UserDTO(null, username, password, email, name, false);		
	}
	
	@FXML
	private void back() {
		try {
			Stage window = (Stage) backButton.getScene().getWindow();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Login.fxml"));
			Parent root = loader.load();
			window.setTitle("ParkingApp");
			window.setScene(new Scene(root));
		} catch (IOException e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error");
			alert.setContentText(e.getMessage());
		}
	}

}
