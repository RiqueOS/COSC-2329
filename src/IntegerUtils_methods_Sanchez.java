package test;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import utils.IntegerUtils_Sanchez;
public class IntegerUtils_methods_Sanchez 
{

	
	private static void test_isEven() 
	{
		int input = -48;
		boolean expected_Straight = true;
		System.out.println("IU.isEven(" + input +") = " + 
		IntegerUtils_Sanchez.isEven(input) + ": " + "should equal " + expected_Straight);
		
		input = 0;
		boolean expected_extreme = false;
		System.out.println("IU.isEven(" + input +") = " + 
		IntegerUtils_Sanchez.isEven(input) + ": " + "should equal " + expected_extreme);
		
		
		
				
	}
	
	private static void test_isOdd() {
		int input = 0;
		boolean expected_Straight = false;
		System.out.println("IU.isOdd(" + input+") = " + 
		IntegerUtils_Sanchez.isOdd(input) + ": " + "should equal " + expected_Straight);
		
		
		int input_V2 = 99;
		boolean expected_straight = true;
		System.out.println("IU.isOdd(" + input_V2+") = " + 
		IntegerUtils_Sanchez.isOdd(input_V2) + ": " + "should equal " + expected_straight);
	}
	
	
	private static void test_isPrime() {
		int input = 5;
		boolean expected_Straight = true;
		System.out.println("IU.isPrime(" + input+") = " + 
		IntegerUtils_Sanchez.isOdd(input) + ": " + "should equal " + expected_Straight);
		
		input = 0;
		boolean expected_extreme = false;
		System.out.println("IU.isPrime(" + input+") = " + 
		IntegerUtils_Sanchez.isOdd(input) + ": " + "should equal " + expected_extreme);
		
		
		// Found a bug
		int input_V2 = 9;
		boolean expected_bizotic = false;
		System.out.println("IU.isPriime(" + input_V2+") = " + 
		IntegerUtils_Sanchez.isOdd(input_V2) + ": " + "should equal " + expected_bizotic);
		
	}
	
	private static void test_GCF() {
		int expected_Straight = 5;
		System.out.println("IU.test_GCF(25,5) = " + 
		IntegerUtils_Sanchez.greatestCommmonFactor(25, 5) + ":" + " Should equal " + expected_Straight);
		
		int expected_extreme = -1;
		System.out.println("IU.test_GCF(5,25) = " + 
		IntegerUtils_Sanchez.greatestCommmonFactor(0, 25) + ":" + " Should equal " + expected_extreme);
				
	}
	
	private static void test_GCM() {
		int expected_straight = 49;
		System.out.println("IU.test_GCM(7,49) = " +
		IntegerUtils_Sanchez.getGreatestConstrainedMultiple(7, 49) + " : " + "Should equal " + expected_straight);
		
		int expected_extreme = 100;
		System.out.println("IU.test_GCM(2,100) = " +
		IntegerUtils_Sanchez.getGreatestConstrainedMultiple(2, 100) + " : " + "Should equal " + expected_extreme);
	
		
		int expected_bizzare= -1;
		System.out.println("IU.test_GCM(500,100) = " +
		IntegerUtils_Sanchez.getGreatestConstrainedMultiple(500, 100) + " : " + "Should equal " + expected_bizzare);
	
		int expected_bizzare_v1= -1;
		System.out.println("IU.test_GCM(0,100) = " +
		IntegerUtils_Sanchez.getGreatestConstrainedMultiple(0, 100) + " : " + "Should equal " + expected_bizzare_v1);
	
		
	}
	
	private static void test_getMaximum() {
		Set<Integer> testSet = new HashSet<>();
		testSet.add(2);
		testSet.add(4);
		testSet.add(99);
		testSet.add(8);
		testSet.add(10);
		
		int expected_Straight = 10;
		System.out.println("IU.test_getMaximum({2,4,6,8,10} = " +
		IntegerUtils_Sanchez.getMaximum(testSet) + " : " + " Should equal " + expected_Straight);
		
		
		Set<Integer> testSet1 = new HashSet<>();
		testSet.add(2);
		testSet.add(4);
		testSet.add(null);
		testSet.add(8);
		testSet.add(10);
		
		int expected_bizzare = -1;
		System.out.println("IU.test_getMaximum({2,4,null,8,10} = " +
		IntegerUtils_Sanchez.getMaximum(testSet1) + " : " + " Should equal " + expected_bizzare);
		
		Set<Integer> testSet2 = new HashSet<>();
		
		
		int expected_extreme = -1;
		System.out.println("IU.test_getMaximum({} = " +
		IntegerUtils_Sanchez.getMaximum(testSet2) + " : " + " Should equal " + expected_extreme);
	}
	
	
	
	public static void test_getMin() {
		int testlist[] = {1,100,-5,-6,-10,-11};
		
		
		int expected_straight = -11;
		System.out.println("IU.test_getMiniumum[1,100,-5,-6,-10,-11] = " +
		IntegerUtils_Sanchez.getMinimum(testlist) + ": " + " Should equal " + expected_straight );
		
		int testlist_V1[] = {};
		
		
		int expected_extreme = -1;
		System.out.println("IU.test_getMiniumum[] = " +
		IntegerUtils_Sanchez.getMinimum(testlist_V1) + ": " + " Should equal " + expected_extreme );
		
		int testlist_V2[] = {0};
		int expected_bizzare = 0;
		System.out.println("IU.test_getMiniumum[0] = " +
		IntegerUtils_Sanchez.getMinimum(testlist_V2) + ": " + " Should equal " + expected_bizzare);
		
		int testlist_V3[] = {-5,3,5,6};
		int expected_V3 = -5;
		System.out.println("IU.test_getMinimum[-5,3,5,6} = " +
		IntegerUtils_Sanchez.getMinimum(testlist_V3) + ": " + " should equal "  + expected_V3);
				
	}
	
	public static void test_isSorted() {
		int testlist[] = {1,2,3,4,5};
		
		boolean expected_straight = true;
		System.out.println("IU.test_isSorted[1,2,3,4,5] = " + 
		IntegerUtils_Sanchez.isSorted(testlist) + ": " + " should equal " + expected_straight);
		
		int testlist_V1[] = {};
		boolean expected_extreme = true;
		System.out.println("IU.test_isSorted[] = " + 
		IntegerUtils_Sanchez.isSorted(testlist_V1) + ": " + " should equal " + expected_extreme);
		
		int testlist_V2[] = {5,42,6,7,1};
		boolean expected_Straight = false;
		System.out.println("IU.test_isSorted[5,42,6,7,1] = " +
		IntegerUtils_Sanchez.isSorted(testlist_V2) + ": " + " Should equal " + expected_Straight);
				
		
		
	}
	
	public static void test_getSmallestIndexOfMatch() {
		int testlist[] = {1,4,5,77,5,3};
		int expected_straight = 2;
		System.out.println("IU.testSmallerIndexofMatch[1,4,5,77,5,3] + " + 
		IntegerUtils_Sanchez.getSmallestIndexOfMatch(testlist, 5) + ": " + "Should equal" + expected_straight);
		
		int testlistV2[] = {1,4,2,77,5,5,5,5,3};
		int expected_straightt = 4;
		System.out.println("IU.testSmallerIndexofMatch[1,4,5,77,5,3] + " + 
		IntegerUtils_Sanchez.getSmallestIndexOfMatch(testlistV2, 5) + ": " + "Should equal" + expected_straightt);
		
		
	}
	
	public static void test_getCommonDecimalDigits() {
		String expected = "{2,3}";
		System.out.println("IU.test_getCommonDecimalDigits(123, 238) " +
		IntegerUtils_Sanchez.getCommonDecimalDigits(123, 238) + ": " + " Should equal " + expected);
		
		String expected_v2 = "0";
		System.out.println("IU.test_getCommonDecimalDigits(-123, 678) " +
		IntegerUtils_Sanchez.getCommonDecimalDigits(-123, 678) + ": " + " Should equal " + expected_v2);
				
		
	}
	
	public static void test_getReverse() {
		int expected = 5432;
				System.out.println("IU.test_getReverse(2345) " +
		IntegerUtils_Sanchez.reverse(2345) + ": " + " Should equal " + expected);
	}



	public static void main(String[]args)	
	{
		 test_isEven();
		 System.out.println();
		 
		 
		 test_isOdd();
		 System.out.println();
		 
		 
		 test_isPrime();
		 System.out.println();
		 
		 
		 test_GCF();
		 System.out.println();
		 
		 
		 test_GCM();
		 System.out.println();
		 
		 
		 test_getMaximum();
		 System.out.println();
		 
		 test_getMin();
		 System.out.println();
		 
		 test_isSorted();
		 System.out.println();
		 
		 test_getSmallestIndexOfMatch();
		 System.out.println();
		 
		 test_getCommonDecimalDigits();
		 System.out.println();
		 
		 test_getReverse();
		 System.out.println();
		 
	}

}
