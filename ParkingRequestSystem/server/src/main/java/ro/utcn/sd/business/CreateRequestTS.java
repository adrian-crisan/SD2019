package ro.utcn.sd.business;

import ro.utcn.sd.dao.DaoFactory;
import ro.utcn.sd.output.DTO;
import ro.utcn.sd.output.RequestDTO;

public class CreateRequestTS implements TransactionScript {

	private final String date;
	private final String username;
	private final String carVin;
	private final String parkingLot;
	private UserService userService = new UserService();
	
	public CreateRequestTS(String date, String username, String carVin, String parkingLot) {
		this.date = date;
		this.username = username;
		this.carVin = carVin;
		this.parkingLot = parkingLot;
	}

	
	@Override
	public DTO execute() {
		DaoFactory daoFactory = DaoFactory.getInstance(DaoFactory.Type.HIBERNATE);
		RequestDTO dto = userService.makeRequest(username, carVin, parkingLot, date, daoFactory);
	
		return dto;
	}

}
