package ro.utcn.sd.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import ro.utcn.sd.output.ViewRequestsByUserDTO;

public class ViewRequestsController implements Initializable {

	@FXML 
	private TableView<ViewRequestsByUserDTO> requestsTableView;
	
	@FXML 
	private TableColumn<ViewRequestsByUserDTO, Long> requestId;
	
	@FXML
	private TableColumn<ViewRequestsByUserDTO, String> requestDate;
	
	@FXML 
	private TableColumn<ViewRequestsByUserDTO, String> requestState;
	
	@FXML
	private TableColumn<ViewRequestsByUserDTO, String> requestUsername;
	
	@FXML 
	private TableColumn<ViewRequestsByUserDTO, String> requestCar;
	
	@FXML 
	private TableColumn<ViewRequestsByUserDTO, String> requestParkingLot;
	
	@FXML
	private Button backButton;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		requestId.setCellValueFactory(new PropertyValueFactory<ViewRequestsByUserDTO, Long>("id"));
		requestDate.setCellValueFactory(new PropertyValueFactory<ViewRequestsByUserDTO, String>("date"));
		requestState.setCellValueFactory(new PropertyValueFactory<ViewRequestsByUserDTO, String>("state"));
		requestUsername.setCellValueFactory(new PropertyValueFactory<ViewRequestsByUserDTO, String>("username"));
		requestCar.setCellValueFactory(new PropertyValueFactory<ViewRequestsByUserDTO, String>("car"));
		requestParkingLot.setCellValueFactory(new PropertyValueFactory<ViewRequestsByUserDTO, String>("parkingLot"));
		
		requestsTableView.getItems().setAll(getRequests());		
	}
	
	@FXML
	public List<ViewRequestsByUserDTO> getRequests() {
		
		List<ViewRequestsByUserDTO> userRequests = new ArrayList<>();
		
		ViewRequestsByUserDTO request = new ViewRequestsByUserDTO(1, "23-05-2019", "adrian", "PENDING", "CJ96WTP", "Mehedinti 70-72");
		ViewRequestsByUserDTO request2 = new ViewRequestsByUserDTO(1, "21-04-2019", "crisan", "CONFIRMED", "CJ96WTP", "Mehedinti 70-72");
		
		userRequests.add(request);
		userRequests.add(request2);
		
		return userRequests;	
	}
	
	@FXML
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
