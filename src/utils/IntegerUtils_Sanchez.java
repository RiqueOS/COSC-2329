package utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public interface IntegerUtils_Sanchez 
{

		public static boolean isEven(int k) {
			
			boolean hasNoRemainder = ((k % 2) == 0);
			
		
			
			if(k == 0) {
				return false;
				// done not exist
				// my bizzare case
			}
			
			return hasNoRemainder;
			// Straight case : 4 --> true
			// Extreme case: 0 --> true
			// bizzare case: 0 --> DNE
			
			
			
		}
		
		
		public static boolean isOdd(int k) {
			
			if(k == 0) {
				return false;
				// done not exist
				// my bizzare case
			}
			
			boolean hasARemainder = ((k % 2) != 0);
			return hasARemainder;
			
			// Straight case : 4 --> false
			// Extreme case : 0 --> 
			// Bizzare case : 0 --> DNE
			
			
		}
		
		public static boolean isPrime(int k) {
			// check if the integer is less than one
			// prime number can only be divde by itself or by one
			// Straight case : 5 --> true
			// Extreme case : 0 --> false
			// bizzare case : 9 --> false
			if(k <= 1) {
				return false;
			}
			
			for(int i = 2; i * i <= k ; i++) {
				if(k % i == 0) {
					return false;
				}
			}
			
			return true;
			
			
		}
		
		
		public static int greatestCommmonFactor(int m, int n) {
			// finding the greatest common factor for int m and n
			
			// Straight case : 25 , 5 --> 5
			// extreme case : 0 , 0 --> -1
			// bizare case : -5 , 25 --> -1 DNE
			
			if( m < 0 || n < 0 ) {
				System.out.println(" no negative");
				return -1;
			}
			
			int gcf = 1; 
			// looping from 1 all the way till both number find there greatestCommonFactor
			for ( int i = 1; i <= m && i <= n; i++) {
				// finding where i divides into both numbers evenly, that our GCF
				// the AND condition checks what makes BOTH integers divide evenly with no remainder
				if(m % i == 0 && n % i == 0 ) {
					gcf = i;	
			}
			
			
			
			
			}
			return gcf;
			
			
		}
		
		public static int getGreatestConstrainedMultiple(int k, int maximum) {
			// base case. maximum can not be less than k
			// weed out all the werid cases and incorrect input
			if(k <= 0 || maximum <= 0 || k > maximum) {
				System.out.println("Can not exist");
				return -1;
			
			}
			// using integer division to find how many times k fits into max
			// multiply that result with k and you get your answer that either hits maximum or is less than it
			return (maximum / k) * k;
			
			// Straight case : 7 ,49 --> 49
			// extreme case : 500 , 100 --> -1
			// bizzare case : 0 , 100 --> -1
	
			
		}
		
		public static int getMaximum(Set<Integer> integerSet) {
			ArrayList <Integer> listFromSet = new ArrayList<>(integerSet);
			
			// a good base case to make sure no empty set gets sent. 
			if(listFromSet.size() == 0) {
				System.out.println("empy list, no maximum");
				return -1;
			}
			
			for(int index = 0; index < listFromSet.size(); index++) {
				if(listFromSet.get(index) == null) {
					
				System.out.println("contains null");
				return -1;
				}
			}
			
			// my starting point, and what i will use to update 
			int currentMax = listFromSet.get(0);
			
			for(int i = 1; i < listFromSet.size(); i++) {
				if(listFromSet.get(i) > currentMax) {
					currentMax = listFromSet.get(i);
				}
				
				
				}
			
			return currentMax;
			
			
			//Straight 2,3,4,6 --> 6
			// extreme {} --> -1 DNE
			// bizzare 2,3,4,null --> -1 DNE
				
			}
		
		
			public static int getMinimum(int[] intArray) {
				// same syntax as  getMaximum
				if(intArray.length == 0) {
					System.out.println("list is empty");
					return -1;
				}
				
				int currentMin = intArray[0];
				for(int index = 0; index < intArray.length ; index++) {
					if(intArray[index] < currentMin) {
						currentMin = intArray[index];
					}
				}
				
				return currentMin;
				
				// Straight 1,100,2,4 --> 1
				// extreme {} --> -1 DNE list empty
				// bizzare {-1} --> -1
				
			}
			
			public static boolean isSorted(int[] intArray) {
			
				// base case, if list is empty the list is sorted 
				if(intArray.length == 0) {
					return true;
				}
				
				//1,2,3,4,5,6
				 
				
				for(int i = 0; i < intArray.length - 1; i++) {
					if(intArray[i] > intArray[i + 1]) {
						return false;
					}
					
					
				}
				return true;
				
				//Stright 1,2,3,4 --> true
				// extreme [] --> true
				// bizzare 1,2,34,2,8 --> false
				
				
				
			}
			/// look for target variable, when target variable found 
			public static  int getSmallestIndexOfMatch(int[] intArray, int target)	{
				
				
				for(int i = 0; i < intArray.length - 1; i++) {
					if(intArray == null || intArray.length == 0) {
						return -1;
					}
					
					System.out.println("Target does not exist");
					
				}
				
				
				for(int i = 0; i < intArray.length - 1; i++) {
					if(intArray[i] == target) {
						// looping from left to right so will always grab the smallest index even if their is dupicate
						return i;
	
					}
					
					
					
					// Straight [1,2,3,4] , 4 --> 3
					// extreme [3,4,5,6,5,5] , 5 --> 2
					// bizzare [3,4,5] , 7 --> -1 DNE
					
				}
				
			System.out.println("no match found")	;
			return -1;			
				
			}
			
			
			public static Set<Integer> getCommonDecimalDigits(int a, int b){
				Set<Integer> firstSetOfDigits = digitHelper(a);
				Set<Integer> secondSetOfDigits = digitHelper(b);
				
				firstSetOfDigits.retainAll(secondSetOfDigits);
				return firstSetOfDigits;
				
				// use the "retainALL" method to help find the intersection between two set list 
				// Straight 32,42 --> 2
				// extreme -32, 12 --> 2
				// bizzare 423, 567 --> [] empty
				
			}
			
			public static Set<Integer> digitHelper(int num){
				Set<Integer> digSet = new HashSet<>();
				num = Math.abs(num);// helps handle negative inputs 
				
				// makes sure to include zero if they find common or is the only number involved
				if(num == 0) {
					digSet.add(0);
					return digSet;
				}
				// % mod operator in this case give me the last digit of the number. 
				// / integer division here just removes the last digit and help repeates the loop intill its less then zero
				while (num > 0) {
					digSet.add(num % 10);
					num =	num / 10;
				}
				
				return digSet;
			
			
			
			}
			
			public static int reverse(int k) {
			// same idea as the helper method, only thing diffirent is everytime you mutiply by 10 your shifting everything one place to the left
			// and dropping the new cut off digit from using mod, into the right. 
				int newNumber = 0;
				
				while ( k != 0) {
					int lastDigit = k % 10; // save last digit
					newNumber = newNumber * 10 + lastDigit; //  add the last digit 
					newNumber = newNumber / 10;
				}
				
				return newNumber;
				 
			 }
			
			//straight 12 --> 21
			// extreme 
			
			
			
			}
		


	
		
	



