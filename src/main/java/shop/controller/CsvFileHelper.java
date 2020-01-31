package shop.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CsvFileHelper {

    public static String getResourcePath(String fileName) {
       final File f = new File("");
       final String dossierPath = f.getAbsolutePath() + File.separator + fileName;
       return dossierPath;
   }

   public static File getResource(String fileName) {
       final String completeFileName = getResourcePath(fileName);
       File file = new File(completeFileName);
       return file;
   }
   
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
