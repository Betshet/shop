package shop.controller;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * Class HashSalting
 * Used to hash text.
 */
public class HashSalting {
	
	/**
	 * Static method getSaltedHash
	 * Hashes a given string.
	 * @param password
	 * @return the hashed text.
	 * @throws Exception
	 */
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
