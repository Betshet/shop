package shop.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import shop.model.Aisle;
import shop.model.Article;
import shop.view.ErrorPopup;
/**
 * CLass DAOArticle
 * Controller used to access data about the articles.
 */
public class DAOArticle {
	
	public DAOArticle() {
		
	}
	
	/**
	 * Method findArticles
	 * Gets all the articles from the given Aisle from the article file.
	 * @param aisle
	 * @return ArrayList<Article> List of all the articles in the aisle.
	 */
	public ArrayList<Article> findArticles(Aisle aisle) {
		ArrayList<Article> articleList = new ArrayList<Article>();
		ArrayList<String> reading = new ArrayList<String>();
		try {
			reading = CsvFileHelper.readFile( CsvFileHelper.getResource("src\\main\\resources\\articles.csv"));
		} catch (IOException e) {
			
			System.out.println("Article file not found");
			
		}
		
		for(String i : reading) {
			String[] buff = i.split(",");
		
			if(buff[3].equals( aisle.getName())) {
				articleList.add(new Article(Integer.parseInt(buff[0]),buff[1],Float.parseFloat(buff[2]),buff[4],Integer.parseInt(buff[5])));
			}
			
		}
		
		return articleList;
	}
	
	/**
	 * Method getArticleById
	 * Gets the article associated to the given id.
	 * @param id
	 * @return Article
	 */
	public Article getArticleById(int id) {
		ArrayList<String> reading = new ArrayList<String>();
		try {
			reading = CsvFileHelper.readFile( CsvFileHelper.getResource("src\\main\\resources\\articles.csv"));
		} catch (IOException e) {
			System.out.println("Article file not found");
		}
		
		for(String i : reading) {
			String[] buff = i.split(",");
			if(Integer.parseInt(buff[0]) == id) {
				return new Article(Integer.parseInt(buff[0]),buff[1],Float.parseFloat(buff[2]),buff[4],Integer.parseInt(buff[5]));
			}
		}
		return null;
		
	}
	
	/**
	 * Method getArticleAisle
	 * Gets the aisle of an article given its id.
	 * @param id of the article
	 * @return Aisle
	 */
	public Aisle getArticleAisle(int id) {
		try {
			ArrayList<String> reading = new ArrayList<String>();
		
			reading = CsvFileHelper.readFile( CsvFileHelper.getResource("src\\main\\resources\\articles.csv"));
			
			DAOAisle daoAisle = new DAOAisle();
			for(int i = 0; i<reading.size(); i++) {
				
				String[] buff = reading.get(i).split(",");
				if(Integer.parseInt(buff[0]) == id) {
					return daoAisle.getAisleByName(buff[3]);
					
				}
			}
		} catch (IOException e) {
			System.out.println("Article file not found");
		}
		return null;
		
	}
	
	/**
	 * Method addArticle
	 * Adds an article to the article file.
	 * @param id
	 * @param name
	 * @param price
	 * @param aisle
	 * @param desc
	 * @param stock
	 * @throws IOException
	 */
	public void addArticle(int id, String name, float price, Aisle aisle, String desc, int stock) throws IOException {
		File file = CsvFileHelper.getResource("src\\main\\resources\\articles.csv");
		ArrayList<String> article = new ArrayList<String>();
		article.add(Integer.toString(id));
		article.add(name);
		article.add(Float.toString(price));
		article.add(aisle.getName());
		article.add(desc);
		article.add(Integer.toString(stock));
		CsvFileHelper.writeFile( file, article, true );
	}
	
	/**
	 * Method editStock
	 * Edits the stock of the given article to a new given value.
	 * @param art1
	 * @param stock
	 * @throws Exception
	 */
	public void editStock(Article art1, int stock) throws Exception {
		try {
			File file = CsvFileHelper.getResource("src\\main\\resources\\articles.csv");
			ArrayList<String> reading = CsvFileHelper.readFile( file );
			Aisle aislebuff = null;
			
			for(int i = 0; i<reading.size(); i++) {
				String[] buff = reading.get(i).split(",");
				if(art1.getId() == Integer.parseInt(buff[0])){
					aislebuff = getArticleAisle(art1.getId());
					reading.remove(i);
				}
			}
			
			CsvFileHelper.editFile(file, reading);
			addArticle(art1.getId(),art1.getName(),art1.getPrice(),aislebuff, art1.getDesc(),stock);
			
		} catch (IOException e) {
			@SuppressWarnings("unused")
			ErrorPopup err = new ErrorPopup("Error");
		}
		
	}
}
