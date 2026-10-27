package test;

import encryption.VigenereCipher_Sanchez;

public class ArrayUtils_Sanchez {
	
		public static void testGetColumn() {
			
			String expected_straight = "k";
			
			
			System.out.println("TestingMethods.testGetColumn ('n','X') = " + VigenereCipher_Sanchez.getColumn('n', 'X')
			+ ": " + "Should equal " + expected_straight);
			
			
		}
		
		public static void testGetMatrixEntry() {
			char expectedStraight = 'X';
			System.out.println("TestingMethods.testGetMatrixEntry ('n','k') = " + VigenereCipher_Sanchez.getMatrixEntry('n', 'k')
			+ ": " + "Should equal " + expectedStraight);
			
		}
		
		public static void testEncryptWithMessage() {
			String expectedStriahgt = "CSASTP KV SIQUT GQU CSATIPIUAQJB";
			String[] Straight = {"crypto", "is", "short", "for", "cryptography"};
			System.out.println("TestingMethods.testEncryptWithMessage{crypto, is, short, for, cryptography}, abcd) = " + 
			VigenereCipher_Sanchez.encrypt(Straight , "abcd") + ": " + "should equal " + expectedStriahgt);
		}
	
		public static void testEncryptWithSingleMessage() {
			String expectedStriahgt = "THISWILLMATCH";
			System.out.println("TestingMethods.testEncryptWithSingleMessage{thiswillmatch}, a) = " + 
			VigenereCipher_Sanchez.encrypt("thiswillmatch" , "a") + ": " + "should equal " + expectedStriahgt);
		}
		
		public static void testDecryptWithMessage() {
			String expectedStraight = "crypto is short for cryptography";
			String[] Straight = {"CSATP", "KV", "SIQUT", "GQU", "CSASTPIUAQJB"};
			System.out.println("TestingMethods.testDecryptWithMessage((CSASTP, KV, SIQUT, GQU, CSATPIUAQJB), abcd) = " + 
			VigenereCipher_Sanchez.decrypt(Straight, "abcd") + " : " + " should equal " + expectedStraight );
		}
	
		
		public static void testDecryptWithSinlgeMessage() {
			String expectedStraight = "worm";
			System.out.println("TestingMethods.testDecryptWithSinlgeMessage(BFFZ, front) = " + 
			VigenereCipher_Sanchez.decrypt("BFFZ", "front") + " : " + " should equal " + expectedStraight);
		}
		
	public static void main(String[] args) {
		testGetColumn();
		System.out.println();
		
		testGetMatrixEntry();
		System.out.println();
		
		testEncryptWithMessage();
		System.out.println();
		
		testEncryptWithSingleMessage();
		System.out.println();
		
		testDecryptWithMessage();
		System.out.println();
		
		testDecryptWithSinlgeMessage();
		System.out.println();
		
		
		
		
		
	}

}
