package ro.utcn.sd.controllers.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ro.utcn.sd.communication.RequestToServer;
import ro.utcn.sd.output.RequestDTO;

public class CreateRequestCommand implements Command<String>{

	private final String date;
	private final String username;
	private final String carVin;
	private final String parkingLot;
	
	public CreateRequestCommand(String date, String username, String carVin, String parkingLot) {
		this.date = date;
		this.username = username;
		this.carVin = carVin;
		this.parkingLot = parkingLot;
	}

	@Override
	public String execute() {
		RequestToServer myRequest = new RequestToServer();
		myRequest.getParams().put("date", date);
		myRequest.getParams().put("username", username);
		myRequest.getParams().put("carVin", carVin);
		myRequest.getParams().put("parkingLot", parkingLot);
		myRequest.getParams().put("command", "createReq");
		
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(myRequest);
		System.out.println(json);
		
		try (Socket clientSocket = new Socket("127.0.0.1", 1997)) {
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			
			out.println(json);
			String fromServer = in.readLine();
			RequestDTO response = gson.fromJson(fromServer, RequestDTO.class);
			System.out.println(response);
			
			if (response == null) {
				return "FAIL";
			} else {
				return "SUCCESS";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public String undo() {
		// TODO Auto-generated method stub
		return null;
	}


}
