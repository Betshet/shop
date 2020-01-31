package shop.controller;

import java.util.ArrayList;

import shop.model.Aisle;
import shop.model.Article;
import shop.view.AisleWindow;
import shop.view.DetailWindow;
import shop.view.HomepageWindow;
import shop.view.ShopWindow;

public class windowControl {
	
	private static DAOAisle daoAisle;
	private static DAOArticle daoArticle;
	
	public windowControl() {
		daoAisle = new DAOAisle();
		daoArticle = new DAOArticle();
	}
	

	public static void launchArticleWindow(Aisle aisle) {
		
		ArrayList<Article> buffer = daoArticle.findArticles(aisle);
		AisleWindow aisleWindow = new AisleWindow(buffer);
		aisleWindow.afficher();
	}
	
public static void launchShopWindow() {
		
		ArrayList<Aisle> buffer = daoAisle.getAllAisles();
		ShopWindow shopWindow = new ShopWindow(buffer);
		shopWindow.afficher();
	}
	
	public static void launchDetailWindow(Article article) {
		
		DetailWindow detailWindow = new DetailWindow(article);
		detailWindow.afficher();
	}
	public static void launchHomepageWindow() {
		
		HomepageWindow homepageWindow = new HomepageWindow();
		homepageWindow.afficher();
	}

	
}
