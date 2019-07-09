package ro.utcn.sd.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import ro.utcn.sd.output.CarDTO;
import ro.utcn.sd.output.UserDTO;

public class AddCarController implements Initializable {

	UserDTO user;
	
	public void setUser(UserDTO user) {
		this.user = user;
	}
	
	@FXML
	private Button addCarButton;
	
	@FXML
	private TextField carVinTextField;
	
	@FXML
	private TextField carPtiTextField;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		addCarButton.setOnAction(e -> {
			addCar();
		});
		
	}

	@FXML
	private void addCar() {
		
		CarDTO car = new CarDTO(carVinTextField.getText().toString(), carPtiTextField.getText().toString(), user.getUsername());
		
	}
	

}
