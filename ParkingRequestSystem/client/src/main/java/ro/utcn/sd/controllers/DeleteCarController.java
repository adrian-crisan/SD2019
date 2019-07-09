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
import javafx.scene.control.cell.PropertyValueFactory;
import ro.utcn.sd.output.CarDTO;
import ro.utcn.sd.output.UserDTO;

public class DeleteCarController implements Initializable {

	UserDTO user;
	
	public void setUser(UserDTO user) {
		this.user = user;
	}
	@FXML
	private TableView<CarDTO> carTableView;
	
	@FXML
	private TableColumn<CarDTO, String> carVin;
	
	@FXML
	private TableColumn<CarDTO, String> carPti;
	
	@FXML
	private Button deleteCarButton;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		carVin.setCellValueFactory(new PropertyValueFactory<CarDTO, String>("vin"));
		carPti.setCellValueFactory(new PropertyValueFactory<CarDTO, String>("pti"));
		
		carTableView.getItems().setAll(getCars());
		
		deleteCarButton.setOnAction(e -> {
			deleteCar();
		});
	}

	@FXML
	private List<CarDTO> getCars() {
		
		List<CarDTO> cars = new ArrayList<>();
		
		CarDTO car1 = new CarDTO("CJ96WTP", "26-07-2019", user.getUsername());
		CarDTO car2 = new CarDTO("CJ70HOR", "31-10-2020", "diana");
		
		cars.add(car1);
		cars.add(car2);
		
		return cars;
	}
	
	@FXML
	private void deleteCar() {
		
		CarDTO car = carTableView.getSelectionModel().getSelectedItem();
	}
}
