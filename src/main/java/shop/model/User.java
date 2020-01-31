package shop.model;

public class User {

	private String username;
	private String hashPassword;
	private Aisle aisle;
	private boolean manager;
	
	public User(String username, String hashPassword, Aisle aisle, boolean manager) {
		this.username = username;
		this.hashPassword = hashPassword;
		this.setAisle(aisle);
		this.setManager(manager);
	}

	public String getUsername() {
		return username;
	}

	public String getHashPassword() {
		return hashPassword;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setHashPassword(String hashPassword) {
		this.hashPassword = hashPassword;
	}

	public boolean isManager() {
		return manager;
	}

	public void setManager(boolean manager) {
		this.manager = manager;
	}

	public Aisle getAisle() {
		return aisle;
	}

	public void setAisle(Aisle aisle) {
		this.aisle = aisle;
	}
}
