package ro.utcn.sd.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import ro.utcn.sd.controllers.command.ViewRequestsByParkingLotCommand;
import ro.utcn.sd.output.RequestDTO;
import ro.utcn.sd.output.ViewRequestsByParkingLotDTO;

public class ViewRequestsByParkingLotController implements Initializable {

	@FXML 
	private TableView<RequestDTO> reqTableView;
	
	@FXML 
	private TableColumn<RequestDTO, Long> requestId;
	
	@FXML
	private TableColumn<RequestDTO, String> requestDate;
	
	@FXML 
	private TableColumn<RequestDTO, String> requestState;
	
	@FXML
	private TableColumn<RequestDTO, String> requestUsername;
	
	@FXML 
	private TableColumn<RequestDTO, String> requestCar;
	
	@FXML 
	private TableColumn<RequestDTO, String> requestParkingLot;
	
	@FXML
	private TextField parkingLotTextField;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
		requestId.setCellValueFactory(new PropertyValueFactory<RequestDTO, Long>("id"));
		requestDate.setCellValueFactory(new PropertyValueFactory<RequestDTO, String>("date"));
		requestState.setCellValueFactory(new PropertyValueFactory<RequestDTO, String>("state"));
		requestUsername.setCellValueFactory(new PropertyValueFactory<RequestDTO, String>("username"));
		requestCar.setCellValueFactory(new PropertyValueFactory<RequestDTO, String>("car"));
		requestParkingLot.setCellValueFactory(new PropertyValueFactory<RequestDTO, String>("parkingLot"));
		
		reqTableView.getItems().setAll(getRequests());		
		
	}

	@FXML
	public List<RequestDTO> getRequests() {
		
		ViewRequestsByParkingLotCommand command = new ViewRequestsByParkingLotCommand("Negoiu 23");
		ViewRequestsByParkingLotDTO dto = command.execute();
		
		List<RequestDTO> requests = new ArrayList<>();
		
		for (RequestDTO r : dto.getRequests()) {
			requests.add(r);
		}
		
		return requests;
	}

}
