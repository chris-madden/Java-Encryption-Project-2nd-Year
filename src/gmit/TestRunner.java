package gmit;

import java.io.*;
import java.util.*;

public class TestRunner 
{
	//Running time depends of length of codeword. 1 letter runs about 0 - 1 seconds, 26 letters runs about 3 seconds. 
	//These times lead me to believe the main method runs at O(log n) 
	public static void main(String[] args) throws IOException
	{
		
		//Create Scanner object
		Scanner input = new Scanner(System.in);
		
		//Object reference to class Encoding
		Encoding en = new Encoding();
		
		//Call this method to initialize letter encoding
		en.init();
		
		//Prompt user for file name
		System.out.println("Enter the file you want encrypt (Do not include the file name extension, names are case sensitive) \n");
		
		//Store file name in string
		String userFile = input.nextLine();
		
		//Add the file extension to the string
		userFile += ".txt";
		
		//Create file variable
		File f = new File(userFile);
		
		//Read in file
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
			 
		//Variables
		String codeword, line = null, encodedLetters = null, lineEncoded = null;
		char[][] matrixArr = null;
		String [] encodedLine = null;
		int row, col, index = 0;
		
		//Prompt user for codeword
		System.out.println("\nEnter a codeword \n");
		
		//Store codeword string from user
		codeword = input.next();
		
		//Close Scanner
		input.close();
		
		//Create char array to size of codeword.length
		char[] sortedCodeWord = new char[codeword.length()];
		
		//Convert codeword into char array
		sortedCodeWord = codeword.toCharArray();
		
		//Sort codeword alphabetically
		Arrays.sort(sortedCodeWord);
		
		//Start clock on how long program takes
		long startTime = System.currentTimeMillis();
		
		//Write out to file
		BufferedWriter bufferedWriter = new BufferedWriter ( new FileWriter ( "Encryption.txt" ));	
		
/*
  														LINES 78 - 124
  									
	Next part of code reads in a file line by line. Each line is made into a String with no spaces and all capital letters.
	This String is then converted to a character array. This array is looped through and each character is passed into the encode method.
	The encode method is part of the Encoding class and returns the encoded value for each letter which is a String.
	The String with the encoded letters for a single character fill an array. The array is looped through and Strings are extracted into a String variable
	  		
*/
		
		//Read in file line by line
		while((line = br.readLine()) != null) 		
		{
			
			//Trim each line and make it uppercase
			line = line.trim().toUpperCase();
			
			//Split line into words and store in array
			String[] testWords = line.split(" ");
			
			//Set line to have no characters
			line = "";
			
			//Creates line of words with no spaces
			for(int i = 0; i < testWords.length; i++)
			{
				line += testWords[i];
					
			}//End for
			
			//Take each line and store as single characters in a char array
			char [] lineChar = line.toCharArray();
			
			//Initialize String array to length of lineChar array
			encodedLine = new String [lineChar.length];
			
			//Print each character from array lineChar
			for(int i = 0; i < lineChar.length; i++)
			{
				
				//String that holds the encoded version of letter
				//Returns String so that's why there's no out of bounds exception
				encodedLetters = en.encode(lineChar[i]);
				
				//Fill array with encoded letter
				encodedLine[i] = encodedLetters;
				
			}//End for

			//Loop through array encodedLine
			for(int j = 0; j < encodedLine.length; j++)
			{
				
				//Extract each element from array and store in String
				lineEncoded += encodedLine[j];
				
			}//End for
			
/*
  														LINES 142 - 168
 
 	This part of code deals with filling a 2D array. First the code makes sure each line fits perfectly in a 2D array. It stores the length or the codeword
 	and the length of each line in int variables. Code then checks to see if codeword divides perfectly into the length of line and if not, spaces are added 
 	to end of line. This gives the correct number of elements needed to fill the array without exceptions.
 	The encoded line is then converted to a character array and the 2D array has it's size initialized. Int variables are initialized as they'll be used when filling
 	the 2D array with the characters from the array of encoded characters.
 	
 														LINES 171 - 196
 														
   	One for loop used to fill 2D array. Each time through the loop an if statement is called. It checks that the number of columns filled is only to the 
   	length of the codeword. If it reaches length of codeword then it moves on to a new row and column counter is initialized to 0. Otherwise it increments 
   	column counter until limit for number of columns is met.
*/
			
			//Store codeword length and line length for future size initialization of array
			int codewordSize = codeword.length(); 
			int lineEncodedSize = lineEncoded.length();
			
			//Check if line has extract number of elements to make up 2d array
			if((lineEncodedSize % codewordSize) != 0)
			{
				  
				do{
					  	//Add in spaces at end of line to make correct number of elements
						lineEncoded = lineEncoded + " ";
						
						//Re-initialize lineEncodedSize as size might have changed
						lineEncodedSize = lineEncoded.length();
						
				}while((lineEncodedSize % codewordSize) != 0);
				  
			}//End if
			
			//Each line gets turned into a char array
			char [] matrixToChar = lineEncoded.toCharArray();
			
			//initialize size of array, codeword size sets length of rows
			matrixArr = new char[codewordSize][lineEncodedSize];
			
			//Variables will keep track of row and columns
			row = col = 0;
			
			//Loop for duration of the line length
			for (int i = 0; i < lineEncodedSize; i++)
			{
				
				//Fill the 2D array
				matrixArr[col][row] = matrixToChar[i];
				
				//if all columns in row are filled
				if(col == (codewordSize - 1))
				{
					
					//Re-initialize col to 0 to start are beginning
					col = 0;
					
					//Move on to a new row
					row += 1;
					
				}
				else
				{
					
					//Move through the columns
					col++;
					
				}//End else
				
			}//End for
				
			
/*														LINES 209 - 240

  	This part of code does the encrypting. There are 3 for loops, the outer most for loop runs while there are still rows left in the 2D array.
  	Second for loop runs for the length of the codeword and has an index variable within it.
  	Index variable is used to run through the 3rd for loop to the length of the sorted codeword.
  	In the 3rd for loop the first letter of the codeword is compared with each letter in the sorted codeword until it is equal then loop breaks.
  	This repeats for each letter in the codeword so all letters in codeword are compared with the sorted codeword.
  	Once correct position is found, letter is printed to a txt file.
  	
*/
			//Loop through rows
			for (int i = 0; i < row; i++)
			{
				
				//Used to compare sorted with unsorted keyword
				//Loop through unsorted codeword 
				for (int j = 0; j < codewordSize; j++)
				{
					
					//Keeps track of characters
					index = 0;
					
					//Loop through the sorted codeword
					for (index = 0; index < sortedCodeWord.length; index++)
					{
						
						//Check what index the codeword letter is found in the sortedCodeWord array
						if (codeword.charAt(j) == sortedCodeWord[index])
						{ 
							
							//When letter is found break out of loop
							break;
							
						}//End if 
						
					}//End for that loops through sorted codeword
					
					bufferedWriter.write(matrixArr[index][i]);
					
				}//End for that loops through unsorted codeword
				
			}//End for looping through rows

			//Empty line for each time through loop
			lineEncoded = "";
				
		}//End while
		
		//Close bufferedWriter
		br.close();
		
		//Close bufferedWriter
		bufferedWriter.close();
		
		//Store end time of program
		long endTime = System.currentTimeMillis();
		
		//Print out time it's taken the program to execute
		System.out.println("\n\tTime taken is "+(endTime - startTime) / 1000 + " seconds");
		
	}//End main

}//End class TestRunner


