package ro.utcn.sd.business;

import ro.utcn.sd.dao.DaoFactory;
import ro.utcn.sd.output.DTO;
import ro.utcn.sd.output.RequestDTO;
import ro.utcn.sd.output.ViewRequestsByParkingLotDTO;

public class ViewRequestsByParkingLotTS implements TransactionScript {

	private final String parkingLotReq;
	private AdminService adminService = new AdminService();
	
	public ViewRequestsByParkingLotTS(String parkingLotReq) {
		this.parkingLotReq = parkingLotReq;
	}

	@Override
	public DTO execute() {
		DaoFactory daoFactory = DaoFactory.getInstance(DaoFactory.Type.HIBERNATE);
		ViewRequestsByParkingLotDTO dto = adminService.viewRequestsForParkingLot(parkingLotReq, daoFactory);
		
		return dto;
	}

	

}
