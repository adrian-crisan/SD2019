package ro.utcn.sd.entities.builders;

import java.util.Objects;

import ro.utcn.sd.entities.User;

public class UserBuilder {

	 private User underConstruction;

	    private UserBuilder() {
	        underConstruction = new User();
	    }

	    public static UserBuilder createUserBuilder() {
	        return new UserBuilder();
	    }

	    public UserBuilder name(String name) {
	        underConstruction.setName(name);
	        return this;
	    }

	    public UserBuilder username(String username) {
	        underConstruction.setUsername(username);
	        return this;
	    }

	    public UserBuilder password(String password) {
	    	underConstruction.setPassword(password);
	    	return this;
	    }
	    
	    public UserBuilder email(String email) {
	    	underConstruction.setEmail(email);
	    	return this;
	    }
	    
	    public UserBuilder isAdmin(boolean is) {
	        underConstruction.setAdmin(is);
	        return this;
	    }
	    
	    
	    public User build() {
	        checkValid(underConstruction);
	        return underConstruction;
	    }

	    private void checkValid(User underConstruction) {
	        Objects.requireNonNull(underConstruction.getName());
	        Objects.requireNonNull(underConstruction.getUsername());
	    }
}
