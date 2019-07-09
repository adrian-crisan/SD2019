package ro.utcn.sd.business;

import ro.utcn.sd.dao.DaoFactory;
import ro.utcn.sd.output.UserDTO;

public class LoginTS implements TransactionScript{

	private final String username;
	private final String password;
	private UserService userService = new UserService();
	
	public LoginTS(String username, String password) {
		this.username = username;
		this.password = password;
	}

	@Override
	public UserDTO execute() {
		DaoFactory daoFactory = DaoFactory.getInstance(DaoFactory.Type.HIBERNATE);
		UserDTO user = userService.login(username, password, daoFactory);
		
		return user;	
	}

}
