package shop.controller;

import java.util.ArrayList;

import shop.model.Aisle;
import shop.model.Article;
import shop.view.AisleWindow;
import shop.view.DetailWindow;
import shop.view.HomepageWindow;
import shop.view.ShopWindow;
import shop.view.UserWindow;


/**
 * Class windowControl
 * Used to launch the different windows
 */
public class windowControl {
	
	/**
	 * static method launchArticleWindow
	 * Launches the window displaying all articles in an aisle
	 * @param aisle
	 */
	public static void launchArticleWindow(Aisle aisle) {
		
		DAOArticle daoArticle = new DAOArticle();
		ArrayList<Article> buffer = daoArticle.findArticles(aisle);
		AisleWindow aisleWindow = new AisleWindow(buffer);
		aisleWindow.afficher();
	}
	/**
	 * static method launchShopWindow
	 * Launches the window displaying all aisles in the shop
	 */
	public static void launchShopWindow() {
		DAOAisle daoAisle = new DAOAisle();
		ArrayList<Aisle> buffer = daoAisle.getAllAisles();
		ShopWindow shopWindow = new ShopWindow(buffer);
		shopWindow.afficher();
	}
	
	/**
	 * static method launchDetailWindow
	 * Launches the window displaying details about an article
	 * @param article
	 */
	public static void launchDetailWindow(Article article) {
		
		DetailWindow detailWindow = new DetailWindow(article);
		detailWindow.afficher();
	}
	
	/**
	 * static method launchHomepageWindow
	 * Launches the homepage window
	 */
	public static void launchHomepageWindow() {
		
		HomepageWindow homepageWindow = new HomepageWindow();
		homepageWindow.afficher();
	}

	/**
	 * static method launchUserWindow
	 * Launches the window displaying all users
	 */
	public static void launchUserWindow() {
		DAOAuthentification daoUser = new DAOAuthentification();
		UserWindow userWindow = new UserWindow(daoUser.getAllUsers());
		userWindow.afficher();
		
	}

	
}
