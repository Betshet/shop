package shop.model;
/**
 * Class User
 * A user.
 */
public class User {
	/**
	 * Private attribute username
	 * Username of the user.
	 */
	private String username;
	/**
	 * Private attribute hashPassword
	 * Hashed password of the user.
	 */
	private String hashPassword;
	/**
	 * Private attribute aisle
	 * Aisle of the user.
	 */
	private Aisle aisle;
	/**
	 * Private attribute manager
	 * Indicates if the user is manager.
	 */
	private boolean manager;
	
	/**
	 * Constructor
	 * @param username
	 * @param hashPassword
	 * @param aisle
	 * @param manager
	 */
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
