package ro.utcn.sd.business;

import ro.utcn.sd.communication.RequestToServer;

public class TSFactory {

	public static TransactionScript create(RequestToServer requestToServer) {
		String command = requestToServer.getParams().get("command");
		switch(command) {
		case "login":
			String username = requestToServer.getParams().get("username");
			String password = requestToServer.getParams().get("password");
			return new LoginTS(username, password);
		case "createReq":
			String date = requestToServer.getParams().get("date");
			String usernameReq = requestToServer.getParams().get("username");
			String carVin = requestToServer.getParams().get("carVin");
			String parkingLot = requestToServer.getParams().get("parkingLot");
			return new CreateRequestTS(date, usernameReq, carVin, parkingLot);
			
		case "viewReqByParkingLot":
			String parkingLotReq = requestToServer.getParams().get("parkingLot");
			return new ViewRequestsByParkingLotTS(parkingLotReq);
		default: 
			return null;
		}
	}

}
