package shop.controller;

import java.io.IOException;
import java.util.ArrayList;

import shop.model.Aisle;
import shop.model.Article;

public class DAOArticle {
	
	public static ArrayList<Article> findArticles(Aisle aisle) {
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
	
	public static Article getArticleById(int id) {
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
	

}
