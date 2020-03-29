import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
	import java.util.Scanner;
	
//Get the text from the file
//The populate the map with the word and this increment if the word occurs more than once
//Get rid of blank lines or spaces
//Write the answer to the new text file


public class DuplicateCounter {
	
	
	static HashMap<String, Integer> wordCounter = new HashMap<String, Integer>();
		
		public static void count(String dataFile) {
			//HashMap<String, Integer> wordCounter = new HashMap<String, Integer>();
			dataFile = "problem2.txt";
			try {
			Scanner Iterate = new Scanner(new File(dataFile));
			while (Iterate.hasNextLine()) {
				String[] word = Iterate.nextLine().split(" ");
				
				//Blank lines 
					for(String countwords : word) {
						if(word == null || word.equals("")) {
							continue;
						}
						//Put everything to lowercase
						String uniqueWords = countwords.toLowerCase();
						
						//if the hashmap has a new word
						
						if(wordCounter.containsKey(uniqueWords)) {
							//populate the hashmap with the new word and then increment
							wordCounter.put(uniqueWords,wordCounter.get(uniqueWords)+ 1);
							
						}
						else {
							//default if there is a word put 1 for the count
							wordCounter.put(uniqueWords, 1 );
						}
						
					}
					
					//call for the write method
					write(null);
			
			}
			Iterate.close();
			}catch (FileNotFoundException e) {
				//error message
				System.out.println(" File was not found");
				e.printStackTrace();
			}
			}	

		public static void write(String outputFile) {
			
			outputFile = "unique_word_count.txt";

			try {
				//Writer to the file
				PrintWriter words = new PrintWriter(outputFile, "UTF-8");
		
				words.println(wordCounter);
				
				words.close();
				} catch (IOException e) {
					//error message
				System.out.println("Could not write file");
					e.printStackTrace();
				}
				
			
		}
		
		}
		
	


