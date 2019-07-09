package ro.utcn.sd.controllers.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ro.utcn.sd.communication.RequestToServer;
import ro.utcn.sd.output.UserDTO;

public class LoginCommand implements Command<String> {

    private final String password;
    private final String username;
    
    public LoginCommand(String username, String password)
    {
        this.password = password;
        this.username = username;
    }
    
	@Override
	public String execute() {
		RequestToServer myRequest = new RequestToServer();
		myRequest.getParams().put("username", username);
		myRequest.getParams().put("password", password);
		myRequest.getParams().put("command", "login");
		
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(myRequest);
		System.out.println(json);
		
		try (Socket clientSocket = new Socket("127.0.0.1", 1997)) {
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			
			out.println(json);
			String fromServer = in.readLine();
			UserDTO userDTO = gson.fromJson(fromServer, UserDTO.class);
			System.out.println(userDTO);
			
			if (userDTO == null) {
				return "NOTFOUND";
			} else if (!userDTO.isAdmin()) {
				return "ADMIN";
			} else {
				return "USER";
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
