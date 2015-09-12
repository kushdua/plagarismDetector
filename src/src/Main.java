package src;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	private static int defaultTupleSize = 3;
	
	public static void main (String[] args) throws FileNotFoundException, IOException {
		//check how many arguments are passed
		if(args.length < 3) {
			printUsageMessage();
		} else {
			String file1 = null;
	    	String file2 = null;
	    	ArrayList<String> synonym = null;
			//read the files
			if(!args[1].endsWith(".txt")) {
				file1 = FileHandler.readFile(args[1]+".txt");
			} else {
				file1 = FileHandler.readFile(args[1]);
			}
			if(!args[2].endsWith(".txt")) {
				file2 = FileHandler.readFile(args[2]+".txt");
			} else {
				file2 = FileHandler.readFile(args[2]);
			}
			if(!args[0].endsWith(".txt")) {
				synonym = FileHandler.readFileArray(args[0]+".txt");
			} else {
				synonym = FileHandler.readFileArray(args[0]);
			}

			//check the optional argument
			if(args.length == 4) {
				defaultTupleSize = Integer.parseInt(args[3]);
			}
			if(defaultTupleSize < 1) {
				defaultTupleSize = 3;
			}
			int percentage = Detector.getInstance().analysePlagarismContent(synonym, file1, file2, defaultTupleSize);
			System.out.println(percentage + "%");
		}
	}
	
	private static void printUsageMessage() {
		System.out.println("1) file name for a list of synonyms");
		System.out.println("2) input file 1");
		System.out.println("3) input file 2");
		System.out.println("4) (optional) the number N, the tuple size.  If not supplied, the default should be N=3)");
	}
}
