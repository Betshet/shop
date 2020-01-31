package shop.controller;

import java.io.IOException;
import java.util.ArrayList;

import shop.model.Aisle;
import shop.model.User;
import shop.view.ErrorPopup;

public class DAOAuthentification {
	
	public DAOAuthentification() {
		
	}
	
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
	
	public void signIn(String username, String password, Aisle aisle, boolean manager) throws Exception
	{
		ArrayList<String> usr = new ArrayList<String>();
		
		usr.add(username);
		usr.add(HashSalting.getSaltedHash(password));
		usr.add(Integer.toString(aisle.getId()));
		if(manager)	usr.add("1");
		else usr.add("0");
		try {
			CsvFileHelper.writeFile(CsvFileHelper.getResource("src\\main\\resources\\authentification.csv"), usr);
		} catch (IOException e) {
			@SuppressWarnings("unused")
			ErrorPopup err = new ErrorPopup("Error");
		}
	}
}
