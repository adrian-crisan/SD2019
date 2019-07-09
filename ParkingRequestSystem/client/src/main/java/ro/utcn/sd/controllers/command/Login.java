package ro.utcn.sd.controllers.command;

import ro.utcn.sd.output.UserDTO;

public class Login {
	
	public static UserDTO login(String username, String password) {
		if (username.equals("user"))
			return new UserDTO(1L, "user", "user", "", "", false);
		else if (username.equals("admin")) 
			return new UserDTO(2L, "admin", "admin", "", "", true);
		else
			return null;
	}

}
