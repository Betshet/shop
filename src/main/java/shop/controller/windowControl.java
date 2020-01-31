package shop.controller;

import java.util.ArrayList;

import shop.model.Aisle;
import shop.model.Article;
import shop.view.AisleWindow;
import shop.view.DetailWindow;
import shop.view.HomepageWindow;
import shop.view.ShopWindow;
import shop.view.UserWindow;

public class windowControl {
	
	public windowControl() {
	}
	

	public static void launchArticleWindow(Aisle aisle) {
		
		DAOArticle daoArticle = new DAOArticle();
		ArrayList<Article> buffer = daoArticle.findArticles(aisle);
		AisleWindow aisleWindow = new AisleWindow(buffer);
		aisleWindow.afficher();
	}
	
public static void launchShopWindow() {
		DAOAisle daoAisle = new DAOAisle();
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


	public static void launchUserWindow() {
		DAOAuthentification daoUser = new DAOAuthentification();
		UserWindow userWindow = new UserWindow(daoUser.getAllUsers());
		userWindow.afficher();
		
	}

	
}
