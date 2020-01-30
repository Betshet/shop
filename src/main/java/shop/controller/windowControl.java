package shop.controller;

import java.util.ArrayList;

import shop.model.Aisle;
import shop.model.Article;
import shop.view.AisleWindow;
import shop.view.DetailWindow;

public class windowControl {
	public windowControl() {
		
	}
	

	public static void launchArticleWindow(Aisle aisle) {
		
		ArrayList<Article> buffer = DAOArticle.findArticles(aisle);
		AisleWindow aisleWindow = new AisleWindow(buffer);
		aisleWindow.afficher();
	}
	
	public static void launchDetailWindow(Article article) {
		
		DetailWindow detailWindow = new DetailWindow(article);
		detailWindow.afficher();
	}

	
}
