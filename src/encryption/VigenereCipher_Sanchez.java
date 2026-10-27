package encryption;

import java.util.Arrays;
import java.util.List;

public interface VigenereCipher_Sanchez

{
	
	public final static List<Character> ENGLISH_LOWERCASE_LETTERS_LIST = Arrays.asList(
			'a', 'b', 'c', 'd','e', 'f', 'g', 
			'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 
			'p', 'q', 'r', 's', 't', 'u', 'v', 
			'w', 'x', 'y', 'z');
	public final static List<Character> ENGLISH_UPPERCASE_LETTERS_LIST = Arrays.asList(
			'A', 'B', 'C', 'D','E', 'F', 'G', 
			'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 
			'W', 'X', 'Y', 'Z');

	
	//part of pre: plainMessage[i] != null, for i in [0, plainMessage.length)
	//part of pre: plainMessage[i].charAt(j) is in {'a', 'b', 'c', ...,'z'}, for i
	// in [0, plainMessage.length) and j in [0, plainMessage[i].length())
	//part of pre: key != null
	//part of pre: key.length() > 0
	//part of post: rv.charAt(j) is in {'A', 'B', 'C', ..., 'Z'} U {' '}, for j
	//
	public static String encrypt(String[] plainMessage, String key)
	{
		
		
		// Key text needs to be strictly the same length as plainMessage so cut off and words that exceeds the message length
		// .encrypt is used with GET maxtrix entry 
	
		
		
		StringBuilder encyrpted = new StringBuilder();
		int keyIndex = 0;
		// walks through each word 
		for(int i = 0; i < plainMessage.length; i++) {
			if(i > 0) {
				encyrpted.append(' '); // append a space to match up output from PDF
			}
			
			String word = plainMessage[i];
			// walks through the letters of a single word from start to end
			for(int j = 0; j < word.length(); j++) {
				char keyInput = key.charAt(keyIndex % key.length());
				encyrpted.append(getMatrixEntry(word.charAt(j), keyInput));
				keyIndex++;
			}
			
		}
		
		return encyrpted.toString();
	
		
		
	}
	
	
	//part of pre: plainText != null
	//part of pre: plainText.charAt(j) is in {'a', 'b', 'c', ...'z'}, for j
	// in [0, plainText.length())
	//part of pre: key != null
	//part of pre: key.length() > 0
	//part of post: rv.charAt(j) is in {'A', 'B', 'C', ..., 'Z'}, for j
	//
	public static String encrypt(String plainText, String key)
	{
		
		StringBuilder encrypted = new StringBuilder();
		for(int i = 0; i < plainText.length(); i++) {
			char keyLetter = key.charAt(i % key.length());
			encrypted.append(getMatrixEntry(plainText.charAt(i), keyLetter));
		}
		
		return encrypted.toString();
	}
	
	
	//part of pre: encryptedMessage[i] != null, for i in [0, encryptedMessage.length)
	//part of pre: encryptedMessage[i].charAt(j) is in {'A', 'B', 'C', ...,'Z'}, for i
	// in [0, encryptedMessage.length) and j in [0, encryptedMessage[i].length())
	//part of pre: key != null
	//part of pre: key.length() > 0
	//part of post: rv.charAt(j) is in {'a', 'b', 'c', ..., 'z'} U {' '}, for j
	// in [0, rv.length())
	//part of post: left out, but need to express exactly where the spaces are in rv
	public static String decrypt(String[] encryptedMessage, String key)
	{
		// Decrypt uses the .getColumn method to cross with the key in finding the english text 
		// .Encrypt HAS to come out in ALL CAPS
		
		StringBuilder decrypted = new StringBuilder();
		int keyIndex = 0;
		
		for(int i = 0; i < encryptedMessage.length; i++) {
			if (i > 0) {
				decrypted.append(' ');
			}
			
			String word = encryptedMessage[i];
			for(int j = 0; j < word.length(); j++) {
				char keyLetter = key.charAt(keyIndex % key.length());
				decrypted.append(getColumn(keyLetter, word.charAt(j)));
				keyIndex++;
			}
		}
		
		return decrypted.toString();
		
	}
	
	
	
	//part of pre: encryptedText != null
	//part of pre: encryptedText.charAt(j) is in {'A', 'B', 'C', ...,'Z'}, for j
	// in [0, encryptedText.length())
	//part of pre: key != null
	//part of pre: key.length() > 0
	//part of post: rv.charAt(j) is in {'a', 'b', 'c', ..., 'z'}, for j in [0, rv.length())
	public static String decrypt(String encryptedText, String key)
	{
		StringBuilder decrypted = new StringBuilder();
		for(int i = 0; i < encryptedText.length(); i++) {
			char keyLetter = key.charAt(i % key.length()); 
			decrypted.append(getColumn(keyLetter,encryptedText.charAt(i)));
		}
		return decrypted.toString();
		
	}
	
	
	//backbone method
	//part of pre: row is in {'a', 'b', 'c', ...'z'}
	//part of pre: column is in {'a', 'b', 'c', ...'z'}
	//part of post: rv is in {'A', 'B', 'C', ..., 'Z'}
	public static char getMatrixEntry(char row, char column){
	
		
		
		int rowPosition = -1; // -1 is my placeholder if char is not found or if found updates that index
		for(int i = 0; i < ENGLISH_LOWERCASE_LETTERS_LIST.size () ; i++) {
			if(ENGLISH_LOWERCASE_LETTERS_LIST.get(i) == row) {
				rowPosition = i;
				break; 
				//break key word is used to end the function as soon as it finds the index
			}
		}
		
		int columnPosition = -1;
		for(int i = 0; i < ENGLISH_LOWERCASE_LETTERS_LIST.size(); i++) {
			if(ENGLISH_LOWERCASE_LETTERS_LIST.get(i) == column) {
				columnPosition = i;
				break;
			}
		}
		
		
		// j + v: 9 + 21 = 30, 30%26 = 4, --> 'E' correct
		// n + k: 13 + 10 = 23, 23 % 26 = 3 --> 'X' Correct
		
		// module operator is used to find the position
		int shiftRightByAmountGiven = (rowPosition + columnPosition) % ENGLISH_LOWERCASE_LETTERS_LIST.size();
		
		return ENGLISH_UPPERCASE_LETTERS_LIST.get(shiftRightByAmountGiven);
		
		
	}
	
	
	//part of pre: row is in {'a', 'b', 'c', ...'z'}
	//part of pre: matrixEntry is in {'A', 'B', 'C', ..., 'Z'}
	//part of post: rv is in {'a', 'b', 'c', ...'z'}
	public static char getColumn(char row, char matrixEntry)
	{
		
		
		// Same idea as getMatrix entry in using the index to find a new position 
		//for example
		
		//getColumn('j', 'E') = 'v' -->  row J = 9, Entry E = 4, 
		// 4-9 = -5 // not a valid position so -5 + 26 = 21
		// this opposite thinking basically undoes the wrap we made in getMatrixEntry, instead of subtract by 26 we are adding by 26
		
		// row + column = entry (getMatrixEntry)
		// column = entry - row (getColumn)
		
		
		
		int rowPosition = -1;
		for(int i = 0; i < ENGLISH_LOWERCASE_LETTERS_LIST.size(); i++) {
			if(ENGLISH_LOWERCASE_LETTERS_LIST.get(i) == row) {
				rowPosition = i;
				break;
			}
		}
		
		int matrixEntryPosition = -1;
		for(int i = 0; i < ENGLISH_UPPERCASE_LETTERS_LIST.size(); i++) {
			if(ENGLISH_UPPERCASE_LETTERS_LIST.get(i) == matrixEntry) {
				matrixEntryPosition = i;
				break;
			}
		}
		
		int shiftRightByAmountGiven = matrixEntryPosition -  rowPosition ;
		
		// handles the negative index case
		if(shiftRightByAmountGiven < 0) {
			shiftRightByAmountGiven = shiftRightByAmountGiven + ENGLISH_UPPERCASE_LETTERS_LIST.size();
		}
		
		return ENGLISH_LOWERCASE_LETTERS_LIST.get(shiftRightByAmountGiven);



		
	}


}

// a total of 25 total shifts that can be made depending on what row they are on





