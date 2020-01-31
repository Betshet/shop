package allTests.controllerTest;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import shop.controller.CsvFileHelper;


public class CsvFileHelperTest {
	
	private String path = "src\\test\\resources\\aisles.csv";
	
	@Test
	/**
	 * Checks that CsvFileHelper gets the correct system path to the ressource
	 */
	public void correctResourcePath() {
		File f1 = new File("");
		String pathTest = f1.getAbsolutePath() + File.separator + path;
		
		assertEquals(CsvFileHelper.getResourcePath("src\\test\\resources\\aisles.csv"),pathTest);
	}

	@Test
	/**
	 * Checks that CsvFileHelper correctly translate the given system path into an adequate File object
	 */
	public void correctResource() {
		File f2 = new File(CsvFileHelper.getResourcePath(path));
		
		assertEquals(CsvFileHelper.getResource(path),f2);
	}
	
	@Test
	/**
	 * Checks that CSVFileHelper correctly reads the given File Object
	 */
	public void correctReading() throws IOException {
		File f3 = new File(CsvFileHelper.getResourcePath(path));
		assertEquals(CsvFileHelper.readFile(f3).get(0),"1,clothes");
		assertEquals(CsvFileHelper.readFile(f3).get(1),"2,books");
		assertEquals(CsvFileHelper.readFile(f3).get(2),"3,music");
		
	}
}
