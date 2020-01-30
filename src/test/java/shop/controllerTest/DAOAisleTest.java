package shop.controllerTest;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;
import org.mockito.Mockito;

import shop.controller.CsvFileHelper;
import shop.controller.DAOAisle;


public class DAOAisleTest {
	
	@Test
	/**
	 * Check if all correct aisles are found when using method getAllAisles
	 * @throws IOException
	 */
	public void allAislesFound() throws IOException {
		
		assertEquals(DAOAisle.getAllAisles().get(0).getId(),1);
		assertEquals(DAOAisle.getAllAisles().get(0).getName(),"clothes");
		assertEquals(DAOAisle.getAllAisles().get(1).getId(),2);
		assertEquals(DAOAisle.getAllAisles().get(1).getName(),"books");
	
	}

}
