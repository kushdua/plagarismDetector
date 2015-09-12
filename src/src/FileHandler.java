package src;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileHandler {
	
	/**
	 * ReadInput file into String
	 * @param fileName relative file location
	 * @return file content with newline character \n replaced by <space>
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static String readFile (String fileName) throws FileNotFoundException, IOException  {
		 try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append(" ");
	            line = br.readLine();
	        }
	        String everything = sb.toString();
	        return everything;
		 }
	}
	
	/**
	 * ReadInput file into arrylist of String
	 * @param fileName relative file location
	 * @return ArrayList of String one item per line
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static ArrayList<String> readFileArray (String fileName) throws FileNotFoundException, IOException  {
		 try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
		 	ArrayList<String> file = new ArrayList<String>();
	        String line = br.readLine();

	        while (line != null) {
	        	file.add(line);
	            line = br.readLine();
	        }
	        return file;
		 }		
	}

}
