package ro.utcn.sd.controllers;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
import ro.utcn.sd.controllers.command.CreateRequestCommand;
import ro.utcn.sd.output.ViewRequestsByUserDTO;


public class CreateRequestController implements Initializable {

	@FXML 
	private TextField usernameTextField;
	
	@FXML
	private TextField carTextField;
	
	@FXML
	private TextField parkingLotTextField;
	
	@FXML
	private Button createRequestButton;
	
	@FXML 
	private Button backButton;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		createRequestButton.setOnAction(e -> {
			createRequest();
		});
		
		backButton.setOnAction(e -> {
			back();
		});
	}
	
	public void createRequest() {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		
		CreateRequestCommand reqCommand = new CreateRequestCommand(dateFormat.format(date), usernameTextField.getText(), carTextField.getText(), parkingLotTextField.getText());
		
		String resp = reqCommand.execute();
		
		if (resp != null) {
			usernameTextField.setText(resp);
		}
		
		//ViewRequestsByUserDTO req = new ViewRequestsByUserDTO(1, dateFormat.format(date), usernameTextField.getText(), "PENDING", carTextField.getText(), parkingLotTextField.getText());
		
		//System.out.println(req.getId() + " " + req.getDate() + " " + req.getUsername() + " " + req.getState() + " " + req.getCar() + " " + req.getParkingLot());
		
		//Car car = new Car();
		//car.setVin(carTextField.getText());
		
		//List<ParkingLot> parkingLots = new ArrayList<>();
		//ParkingLot p = new ParkingLot();
		//p.setAddress(parkingLotTextField.getText());
		//parkingLots.add(p);
		
		/*Request request = createRequestBuilder().
				id(1).
				date(dateFormat.format(date)).
				username(usernameTextField.getText()).
				state("PENDING").
				car(car).
				parkingLots(parkingLots).
				build();
				*/						
	}

	public void back() {
		try {
			Stage window = (Stage) backButton.getScene().getWindow();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/UserMenu.fxml"));
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
