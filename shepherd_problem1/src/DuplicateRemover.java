import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;





public class DuplicateRemover {
	
	static HashSet<String>uniqueWords =  new HashSet<String>();
	
	public static void remove(String dataFile) {
		 try {
			//HashSet<String>uniqueWords =  new HashSet<String>();
		dataFile = "problem1.txt";
		
			Scanner Iterate = new Scanner(new File(dataFile));
			//iterates through the text doc
			while (Iterate.hasNextLine()) {
				
				String[] word = Iterate.nextLine().split(" ");
				for(int i = 0; i < word.length; i++) {
					//populates the hashset with the words from the text
					if (uniqueWords.add(word[i])) {
						//gets rid of duplicates
						String newWord = "";
						newWord += word[i] + " ";  
					}
					
				}
				//call for the write method
				write(null);
			}
			//System.out.print(uniqueWords);
				Iterate.close();
		} catch (FileNotFoundException e) {
			System.out.println(" File was not found");
			e.printStackTrace();
		}
		
		
	}

	public static void write(String outputFile) {
		
		outputFile = "uniqueWords.txt";

		try {
			//Writer to the file
			PrintWriter words = new PrintWriter(outputFile, "UTF-8");
	
			words.println(uniqueWords);
			
			words.close();
			} catch (IOException e) {
			System.out.println("Could not write file");
				e.printStackTrace();
			}
			
		
	}
	
	
}
