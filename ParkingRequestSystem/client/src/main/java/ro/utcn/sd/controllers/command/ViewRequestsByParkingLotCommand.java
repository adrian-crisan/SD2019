package ro.utcn.sd.controllers.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ro.utcn.sd.communication.RequestToServer;
import ro.utcn.sd.output.RequestDTO;
import ro.utcn.sd.output.ViewRequestsByParkingLotDTO;

public class ViewRequestsByParkingLotCommand implements Command<ViewRequestsByParkingLotDTO> {

	private final String parkingLot;
	
	public ViewRequestsByParkingLotCommand(String parkingLot) {
		this.parkingLot = parkingLot;
	}

	@Override
	public ViewRequestsByParkingLotDTO execute() {
		RequestToServer myRequest = new RequestToServer();
		myRequest.getParams().put("parkingLot", parkingLot);
		myRequest.getParams().put("command", "viewReqByParkingLot");
		
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(myRequest);
		System.out.println(json);
		
		try (Socket clientSocket = new Socket("127.0.0.1", 1997)) {
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			
			out.println(json);
			String fromServer = in.readLine();
			ViewRequestsByParkingLotDTO response = gson.fromJson(fromServer, ViewRequestsByParkingLotDTO.class);
			System.out.println(response);
			
			if (response == null) {
				return null;
			} else {
				return response;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ViewRequestsByParkingLotDTO undo() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
