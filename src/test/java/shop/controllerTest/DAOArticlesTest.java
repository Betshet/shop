package shop.controllerTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import shop.controller.DAOAisle;
import shop.controller.DAOArticle;
import shop.model.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class DAOArticlesTest {
	
	
	
	@Test
	/**
	 * Checks if article with correct Id has been found.
	 */
	public void articleWithCorrectIdFound()
	{
		ArrayList<Aisle> allAisles = DAOAisle.getAllAisles();
		
		assertEquals(DAOArticle.getArticleById(1).getId(),1);
		assertEquals(DAOArticle.getArticleById(2).getId(),2);
		assertThat(DAOArticle.getArticleById(3).getId(),not(equalTo(4)));
	}
	
	@Test
	/**
	 * Checks if correct articles are found when using method findArticles.
	 */
	public void correctArticlesFound(){
		
		ArrayList<Aisle> allAisles = DAOAisle.getAllAisles();		
		
		assertEquals(DAOArticle.findArticles(allAisles.get(0)).get(0).getId(),1);
		assertEquals(DAOArticle.findArticles(allAisles.get(0)).get(1).getId(),4);
		assertEquals(DAOArticle.findArticles(allAisles.get(0)).get(2).getId(),5);
	}

}
