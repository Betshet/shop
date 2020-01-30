package shop.model;

public class User {

	private String username;
	private String hashPassword;
	private int aisleID;
	
	public User(String username, String hashPassword, int aisleID) {
		this.username = username;
		this.hashPassword = hashPassword;
		this.aisleID = aisleID;
	}

	public String getUsername() {
		return username;
	}

	public String getHashPassword() {
		return hashPassword;
	}

	public int getAisleID() {
		return aisleID;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setHashPassword(String hashPassword) {
		this.hashPassword = hashPassword;
	}

	public void setAisleID(int aisleID) {
		this.aisleID = aisleID;
	}
}
