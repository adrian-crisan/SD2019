package ro.utcn.sd.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import ro.utcn.sd.output.ViewRequestsByUserDTO;

public class UpdateRequestController implements Initializable {

	@FXML
	private Button updateRequestButton;
	
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
	private TextField newCarVinTextField;
	
	@FXML 
	private TextField newParkingLotTextField;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		requestId.setCellValueFactory(new PropertyValueFactory<ViewRequestsByUserDTO, Long>("id"));
		requestDate.setCellValueFactory(new PropertyValueFactory<ViewRequestsByUserDTO, String>("date"));
		requestState.setCellValueFactory(new PropertyValueFactory<ViewRequestsByUserDTO, String>("state"));
		requestUsername.setCellValueFactory(new PropertyValueFactory<ViewRequestsByUserDTO, String>("username"));
		requestCar.setCellValueFactory(new PropertyValueFactory<ViewRequestsByUserDTO, String>("car"));
		requestParkingLot.setCellValueFactory(new PropertyValueFactory<ViewRequestsByUserDTO, String>("parkingLot"));
		
		requestsTableView.getItems().setAll(getRequests());		
		
		updateRequestButton.setOnAction(e -> {
			updateRequest();
		});
		
	}

	@FXML
	public void updateRequest() {
		
		ViewRequestsByUserDTO req = requestsTableView.getSelectionModel().getSelectedItem();
		String newCarVin = newCarVinTextField.getText().toString();
		String newParkingLot = newParkingLotTextField.getText().toString();
		
		
		
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
}
