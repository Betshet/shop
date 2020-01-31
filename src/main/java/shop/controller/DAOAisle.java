package shop.controller;

import java.io.IOException;
import java.util.ArrayList;

import shop.model.Aisle;

public class DAOAisle {
	
	public DAOAisle()
	{
		
	}
	
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
	
	public Aisle[] convert(ArrayList<Aisle> list) {
		Aisle[] res = new Aisle[list.size()];
		for(int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}
		return res;
		
	}
}
