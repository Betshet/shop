package shop.controller;

import java.io.IOException;
import java.util.ArrayList;

import shop.model.Aisle;
/**
 * Class DAOAisle
 * Controller used to access data about the aisles.
 */
public class DAOAisle {
	
	public DAOAisle()
	{
		
	}
	
	/**
	 * Method getAllAisles
	 * Gets all the aisle information from the aisle file.
	 * @return ArrayList<Aisle> List of all the aisles in the file.
	 */
	public ArrayList<Aisle> getAllAisles() {
		ArrayList<Aisle> aisleList = new ArrayList<Aisle>();
		ArrayList<String> reading = new ArrayList<String>();
		try {
			reading = CsvFileHelper.readFile( CsvFileHelper.getResource("src\\main\\resources\\aisles.csv"));
		} catch (IOException e) {
			System.out.println("Aisle file not found");
		}
		for(String i : reading) {
			String[] buff = i.split(",");
			aisleList.add(new Aisle(Integer.parseInt(buff[0]),buff[1],null));
		}
		return aisleList;
	}
	
	/**
	 * Method getAisleById
	 * Gets the aisle associated to the given id.
	 * @param id
	 * @return Aisle
	 */
	public Aisle getAisleById(int id) {
		ArrayList<String> reading = new ArrayList<String>();
		try {
			reading = CsvFileHelper.readFile( CsvFileHelper.getResource("src\\main\\resources\\aisles.csv"));
		} catch (IOException e) {
			System.out.println("Aisle file not found");
		}
		
		for(String i : reading) {
			String[] buff = i.split(",");
			
			if(Integer.parseInt(buff[0]) == id) {
				Aisle res = new Aisle(Integer.parseInt(buff[0]),buff[1],null);
				DAOArticle daoArticle = new DAOArticle();
				res.setArticleList(daoArticle.findArticles(res));
				return res;
			}
		}
		return null;	
	}
	
	/**
	 * Method convert
	 * Converts a list of Aisles to an array.
	 * @param list
	 * @return Aisle[]
	 */
	public Aisle[] convert(ArrayList<Aisle> list) {
		Aisle[] res = new Aisle[list.size()];
		for(int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}
		return res;
		
	}

	/**
	 * Method getAisleByName
	 * Gets the first aisle corresponding to the given name.
	 * @param name
	 * @return Aisle
	 */
	public Aisle getAisleByName(String name) {
		ArrayList<String> reading = new ArrayList<String>();
		try {
			reading = CsvFileHelper.readFile( CsvFileHelper.getResource("src\\main\\resources\\aisles.csv"));
		
			for(String i : reading) {
				String[] buff = i.split(",");
				if(buff[1].equals(name)) {
					Aisle res = new Aisle(Integer.parseInt(buff[0]),buff[1],null);
					DAOArticle daoArticle = new DAOArticle();
					res.setArticleList(daoArticle.findArticles(res));
					return res;
				}
			}
		} catch (IOException e) {
			System.out.println("Aisle file not found");
		}
		
		return null;	
	}
}
