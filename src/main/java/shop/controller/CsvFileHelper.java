package shop.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/**
 * Class CsvFileHelper
 * Used to manipulate csv files.
 *
 */
public class CsvFileHelper {

	/**
	 * Static method getResourcePath
	 * Gets the path to the given file name.
	 * @param fileName
	 * @return Path to the file.
	 */
    public static String getResourcePath(String fileName) {
       final File f = new File("");
       final String dossierPath = f.getAbsolutePath() + File.separator + fileName;
       return dossierPath;
   }

    /**
     * Static method getResource
     * Opens a File variable based on the given file name.
     * @param fileName
     * @return File
     */
   public static File getResource(String fileName) {
       final String completeFileName = getResourcePath(fileName);
       File file = new File(completeFileName);
       return file;
   }
   
   /**
    * Static method readFile
    * Reads the given File and creates an ArrayList containing all lines.
    * @param file
    * @return ArrayList<String> containing all lines of the text file.
    * @throws IOException
    */
   public static ArrayList<String> readFile(File file) throws IOException {

	   ArrayList<String> result = new ArrayList<String>();

       FileReader fr = new FileReader(file);
       BufferedReader br = new BufferedReader(fr);

       for (String line = br.readLine(); line != null; line = br.readLine()) {
           result.add(line);
       }

       br.close();
       fr.close();

       return result;
   }
   
   /**
    * Static method writeFile
    * Writes in the given file the text contained in the list, adding commas between each string.
    * @param file
    * @param strList
    * @param append : if true, appends the text to the end of the file. Else, replaces all the text in the file.
    * @throws IOException
    */
   public static void writeFile(File file, ArrayList<String> strList, boolean append) throws IOException {
	   FileWriter csvWriter = new FileWriter( file, append );
	   csvWriter.append(System.getProperty( "line.separator" ));
	   
	   for(int i = 0; i<strList.size()-1; i++) {
		   csvWriter.append(strList.get(i));
		   csvWriter.append(",");
	   }
	   csvWriter.append(strList.get( strList.size()-1 ));
	   csvWriter.flush();
	   csvWriter.close();
   }
   
   /**
    * Static method editFile
    * Replaces all text in the given file by the text in the given list. Each string in the list is a new line.
    * @param file
    * @param strList
    * @throws IOException
    */
   public static void editFile(File file, ArrayList<String> strList) throws IOException {
	   FileWriter csvWriter = new FileWriter( file );
	   for(int i = 0;i<strList.size()-1 ; i++) {
		   csvWriter.append(strList.get(i));
		   csvWriter.append(System.getProperty( "line.separator" ));
	   }
	   csvWriter.append(strList.get( strList.size()-1 ));
	   csvWriter.flush();
	   csvWriter.close();
	   
   }
}
