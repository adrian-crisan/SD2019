package ro.utcn.sd.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ro.utcn.sd.business.TSFactory;
import ro.utcn.sd.business.TransactionScript;
import ro.utcn.sd.communication.RequestToServer;
import ro.utcn.sd.output.DTO;

public class Server {

	private static Server instance;
	private final Gson gson;
	private List<Socket> observers;
	
	private Server() {
		observers = Collections.synchronizedList(new ArrayList<>());
		gson = new GsonBuilder().create();
	}
	
	public static Server getInstance() {
		if (instance == null) 
			instance = new Server();
		return instance;
	}

	public void start() {
		System.out.println("Listening for connections.");
		try (ServerSocket serverSocket = new ServerSocket(1997)) {
			while (true) {
				Socket clientSocket = serverSocket.accept();
				Thread thread = new Thread(() -> serveRequest(clientSocket));
				thread.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void serveRequest(Socket clientSocket) {
		System.out.println("Serving Request.");
		try {
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			
			String jsonFromClient = in.readLine();
			RequestToServer requestToServer = gson.fromJson(jsonFromClient, RequestToServer.class);
			
			String command = requestToServer.getParams().get("command");
			
			//process request
			TransactionScript transactionScript = TSFactory.create(requestToServer);
			DTO result = transactionScript.execute();
			
			out.println(gson.toJson(result));
			
			in.close();
			out.close();
			clientSocket.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Socket> getObservers() {
		return observers;
	}
}
