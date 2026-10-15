package test;

import utils.IntegerUtils_0;

public class IntegerUtilsTests_isPrime_1_PRINTLN_ONLY_VERBOSE
{	
	private static void test_isPrime()
	{
		int input = -3;
		System.out.println("IU.isPrime(" + input +") = " +
							IntegerUtils_0.isPrime(input));
		input = 1;
		System.out.println("IU.isPrime(" + input +") = " +
							IntegerUtils_0.isPrime(input));
		input = 5;
		System.out.println("IU.isPrime(" + input +") = "
							+ IntegerUtils_0.isPrime(input));
	}

	public static void main(String[] args)
	{
		test_isPrime();
	}
}
