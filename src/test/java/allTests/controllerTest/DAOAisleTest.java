package allTests.controllerTest;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import shop.controller.DAOAisle;

/**
 * 
 * @author Pierre Pallier, Romain Bachelier
 * Test class for DAOAisle class.
 *
 */
public class DAOAisleTest {
	
	
	private DAOAisle daoAisle= new DAOAisle();
	
	@Test
	/**
	 * Check if all correct aisles are found when using method getAllAisles
	 * @throws IOException
	 */
	public void allAislesFound() throws IOException {
		assertEquals(daoAisle.getAllAisles().get(0).getId(),1);
		assertEquals(daoAisle.getAllAisles().get(0).getName(),"Clothes");
		assertEquals(daoAisle.getAllAisles().get(1).getId(),2);
		assertEquals(daoAisle.getAllAisles().get(1).getName(),"Books");
	
	}

	@Test
	/**
	 * Checks if the correct aisle was found using its Id
	 */
	public void correctAisleFound() {
		
		assertEquals(daoAisle.getAisleById(1).getId(),1);
		assertEquals(daoAisle.getAisleById(2).getId(),2);
	}
	
}
