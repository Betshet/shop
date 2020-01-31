package allTests.controllerTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import org.junit.Test;

import shop.controller.DAOAisle;
import shop.controller.DAOArticle;
import shop.model.*;

import static org.hamcrest.CoreMatchers.*;

/**
 * 
 * @author Pierre Pallier, Romain Bachelier
 * Test class for DAOArticle class.
 *
 */
public class DAOArticlesTest {
	
	private DAOAisle aisle = new DAOAisle();
	private DAOArticle daoArticle = new DAOArticle();
	
	@Test
	/**
	 * Checks if correct articles are found in the correct Aisle when using method findArticles.
	 */
	public void correctArticlesFound(){
		
		ArrayList<Aisle> allAisles = aisle.getAllAisles();		
		
		assertEquals(daoArticle.findArticles(allAisles.get(0)).get(0).getId(),1);
		assertEquals(daoArticle.findArticles(allAisles.get(0)).get(1).getId(),4);
		assertEquals(daoArticle.findArticles(allAisles.get(0)).get(2).getId(),5);
	}
	
	
	@Test
	/**
	 * Checks if article with correct Id has been found.
	 */
	public void articleWithCorrectIdFound()
	{	
		assertEquals(daoArticle.getArticleById(1).getId(),1);
		assertEquals(daoArticle.getArticleById(2).getId(),2);
		assertThat(daoArticle.getArticleById(3).getId(),not(equalTo(4)));
	}
	
	

}
