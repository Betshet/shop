package shop.controller;

import java.io.IOException;
import java.util.ArrayList;

import shop.model.User;

public class DAOAuthentification {
	
	public static ArrayList<User>  getAllUsers(){
		
		ArrayList<User> userList = new ArrayList<User>();
		ArrayList<String> reading = new ArrayList<String>();
		try {
			reading = CsvFileHelper.readFile( CsvFileHelper.getResource("src\\main\\resources\\aisles.csv"));
		} catch (IOException e) {
			System.out.println("User file not found");
		}
		for(String i : reading) {
			String[] buff = i.split(",");
			userList.add(new User(buff[0],buff[1],Integer.parseInt(buff[2])));
		}
		return userList;
	}

	public static int checkAuth(String username, String password) {
			
		try {
			ArrayList<User> userList = getAllUsers();
			String hashedPass = HashSalting.getSaltedHash(password);
			for(User usr : userList) {
				if( usr.getUsername().equals( username)) {
					if(usr.getHashPassword().equals(hashedPass)) {
						if(usr.getAisleID() == 0) return 2;
						return 1;
					}
				}
			}
			return 0;
		} catch (Exception e) {
			return 0;
		}
		
	}
}
