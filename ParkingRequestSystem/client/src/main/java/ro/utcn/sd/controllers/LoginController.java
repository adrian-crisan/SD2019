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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ro.utcn.sd.controllers.command.LoginCommand;
import ro.utcn.sd.output.UserDTO;

public class LoginController implements Initializable {
	
	@FXML 
	Button loginButton;
	
	@FXML
	Button registerAccountButton;
	
	@FXML
	TextField usernameTextField;
	
	@FXML
	PasswordField passwordTextField;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		loginButton.setOnAction(e -> {
			LoginCommand loginCommand = new LoginCommand(usernameTextField.getText(), passwordTextField.getText());
			
			String user = loginCommand.execute();
			
			if (user.equals("USER")) {
				changeScene();
			} else {
				if (user.equals("ADMIN")) {
					changeSceneToAdmin();
				} else if (user.equals("NOTFOUND")) {
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setTitle("Invalid Login Credentials");
					alert.setHeaderText("Invalid Login Credentials");
					alert.showAndWait();
				}
			}
			
		});
		
		registerAccountButton.setOnAction(e -> {
			registerAccount();
		});
		
	}
	
	@FXML
	private void changeScene() {
		try {
			Stage window = (Stage) loginButton.getScene().getWindow();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/UserMenu.fxml"));
			Parent root = loader.load();
			
			//UserMenuController c = loader.<UserMenuController>getController();
			//c.setUser(user);
			
			window.setTitle("ParkingApp");
			window.setScene(new Scene(root));
		} catch (IOException e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error");
			alert.setContentText(e.getMessage());
		}
	}
	
	@FXML
	private void changeSceneToAdmin() {
		try {
			Stage window = (Stage) loginButton.getScene().getWindow();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AdminMenu.fxml"));
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
	private void registerAccount() {
		try {
			Stage window = (Stage) registerAccountButton.getScene().getWindow();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/RegisterAccount.fxml"));
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
