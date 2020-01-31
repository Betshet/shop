package shop.model;

import java.util.ArrayList;

public class Aisle {
	private int id = 0;
	private String name;
	private ArrayList<Article> articleList;
	
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
	
	@Override
	public String toString() {
		return this.getId()+" - "+this.getName();
	}
}
