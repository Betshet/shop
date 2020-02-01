package shop.model;

import java.util.ArrayList;
/**
 * Class Aisle
 * An aisle of the shop.
 */
public class Aisle {
	/**
	 * Private attribute id
	 * Unique iditifier of the object.
	 */
	private int id;
	/**
	 * Private attribute name
	 * Name of the aisle.
	 */
	private String name;
	/**
	 * Private attribute articleList
	 * List of articles in the aisle.
	 */
	private ArrayList<Article> articleList;
	
	/**
	 * Constructor
	 * @param id
	 * @param name
	 * @param articleList
	 */
	public Aisle(int id, String name, ArrayList<Article> articleList) {
		this.id = id;
		this.name = name;
		this.articleList = articleList;		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public ArrayList<Article> getArticleList() {
		return articleList;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setArticleList(ArrayList<Article> articleList) {
		this.articleList = articleList;
	}
	/**
	 * Method toString
	 * Override of the toString method to display an aisle as a String, using the format "[id] - [name]".
	 * @return String
	 */
	@Override
	public String toString() {
		return this.getId()+" - "+this.getName();
	}
}
