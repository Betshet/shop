package shop.controller;

import java.math.BigInteger;
import java.security.MessageDigest;


public class HashSalting {
	
	public static String getSaltedHash(String password) throws Exception {
		
		
		MessageDigest md = MessageDigest.getInstance("SHA-512");
		byte[] messageDigest = md.digest(password.getBytes());
		BigInteger no = new BigInteger(1, messageDigest);
		String hashtext = no.toString(16);
		while (hashtext.length() < 32) {
		    hashtext = "0" + hashtext;
		}
		return hashtext;
    }
}
