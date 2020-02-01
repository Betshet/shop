package shop.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import shop.model.Aisle;
import shop.model.User;
import shop.view.ErrorPopup;
/**
 * Class DAOAuthentification
 * Controller used to access data about the users. 
 */
public class DAOAuthentification {
	
	public DAOAuthentification() {
		
	}
	
	/**
	 * Method getAllUsers
	 * Gets all the users in the user file.
	 * @return ArrayList<User> 
	 */
	public ArrayList<User>  getAllUsers(){
		
		ArrayList<User> userList = new ArrayList<User>();
		ArrayList<String> reading = new ArrayList<String>();
		try {
			reading = CsvFileHelper.readFile( CsvFileHelper.getResource("src\\main\\resources\\authentification.csv"));
		} catch (IOException e) {
			System.out.println("User file not found");
		}
		DAOAisle daoaisle = new DAOAisle();
		
		for(String i : reading) {
			String[] buff = i.split(",");
			boolean boolbuff;
			if(buff[3].equals("0")) boolbuff = false;
			else boolbuff = true;
			userList.add(new User(buff[0],buff[1],daoaisle.getAisleById(Integer.parseInt(buff[2])),boolbuff));
			System.out.println();
		}
		return userList;
	}
	
	/**
	 * Methode getUserByName
	 * Gets a user using the given name.
	 * @param name
	 * @return User
	 */
	public User getUserByName(String name) {
		ArrayList<String> reading = new ArrayList<String>();
		try {
			reading = CsvFileHelper.readFile( CsvFileHelper.getResource("src\\main\\resources\\authentification.csv"));
		} catch (IOException e) {
			System.out.println("User file not found");
		}
		DAOAisle daoAisle = new DAOAisle();
		for(String i : reading) {
			String[] buff = i.split(",");
			if(name.equals(buff[0])) {
				boolean boolbuff;
				if(buff[3] =="1") boolbuff = true;
				else boolbuff = false;
				return new User(buff[0],buff[1],daoAisle.getAisleById(Integer.parseInt(buff[2])),boolbuff);
			}
		}
		return null;
		
	}
	
	/**
	 * Method checkAuth
	 * Checks if the given username and password are correct.
	 * @param username
	 * @param password
	 * @return User : null if the given data is incorrect.
	 */
	public User checkAuth(String username, String password) {
		
			ArrayList<User> userList = getAllUsers();
		try {
			String hashedPass = HashSalting.getSaltedHash(password);
			
			for(User usr : userList) {
				if( username.equals(usr.getUsername())) {
					if(usr.getHashPassword().equals(hashedPass)) {
						return usr;
					}
				}
			}
			return null;
		} catch (Exception e) {
			return null;
		}
		
	}
	
	/**
	 * Method signIn
	 * Adds a user to the user file using the information given.
	 * @param username
	 * @param password
	 * @param aisle
	 * @param manager
	 * @throws Exception
	 */
	public void signIn(String username, String password, Aisle aisle, boolean manager) throws Exception
	{
		ArrayList<User> usrList = getAllUsers();
		for(User u : usrList) {
			if(u.getUsername().equals(username)) {
				throw new Exception();
			}
		}
		ArrayList<String> usr = new ArrayList<String>();
		
		usr.add(username);
		usr.add(HashSalting.getSaltedHash(password));
		usr.add(Integer.toString(aisle.getId()));
		if(manager)	usr.add("1");
		else usr.add("0");
		try {
			CsvFileHelper.writeFile(CsvFileHelper.getResource("src\\main\\resources\\authentification.csv"), usr, true);
		} catch (IOException e) {
			@SuppressWarnings("unused")
			ErrorPopup err = new ErrorPopup("Error");
		}
	}
	
	/**
	 * Method deleteUser
	 * Removes a user from the user file.
	 * @param usr
	 */
	public void deleteUser(User usr) {
		try {
			File file = CsvFileHelper.getResource("src\\main\\resources\\authentification.csv");
			ArrayList<String> reading = CsvFileHelper.readFile( file );
			
			for(int i = 0; i<reading.size(); i++) {
				String[] buff = reading.get(i).split(",");
				if(usr.getUsername().equals(buff[0])){
					reading.remove(i);
				}
			}
			CsvFileHelper.editFile(file, reading);
			
		} catch (IOException e) {
			@SuppressWarnings("unused")
			ErrorPopup err = new ErrorPopup("Error");
		}
	}

	/**
	 * Method editUser
	 * Edits a user's information.
	 * @param usr1
	 * @param usr2
	 * @throws Exception
	 */
	public void editUser(User usr1, User usr2) throws Exception {
		try {
			File file = CsvFileHelper.getResource("src\\main\\resources\\authentification.csv");
			ArrayList<String> reading = CsvFileHelper.readFile( file );
			
			for(int i = 0; i<reading.size(); i++) {
				String[] buff = reading.get(i).split(",");
				if(usr1.getUsername().equals(buff[0])){
					reading.remove(i);
				}
			}
			CsvFileHelper.editFile(file, reading);
			signIn(usr2.getUsername(),usr2.getHashPassword(),usr2.getAisle(),usr2.isManager());
		} catch (IOException e) {
			@SuppressWarnings("unused")
			ErrorPopup err = new ErrorPopup("Error");
		}
		
	}
}
