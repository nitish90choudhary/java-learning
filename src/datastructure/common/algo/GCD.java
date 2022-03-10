package com.learn.common.algo;

public class GCD {
	// using Euclid's approach

	public static void main(String[] args) {
		GCD gcd = new GCD();
//		System.out.println("GCD of 20, 8 is: " + gcd.gcd(20, 8));
//		System.out.println("GCD of 60, 96 is: " + gcd.gcd(60, 96));
//
//		System.out.println("//Using loop");
//		System.out.println("GCD of 20, 8 is: " + gcd.gcd2(20, 8));
//		System.out.println("GCD of 60, 96 is: " + gcd.gcd2(60, 96));

		String str= "2/7+3/7";
		System.out.println(str.substring(0,str.indexOf('+')));
		//System.out.println(Integer.parseInt(str.substring(str.indexOf('/'),str.indexOf('+')-1)));
	}

	// using recursion
	private int gcd(int a, int b) {
		int remainder = a % b;
		if (remainder == 0)
			return b;
		else
			return gcd(b, remainder);
	}

	// using while loop
	private int gcd2(int a, int b) {
		while (b != 0) {
			int t = a;
			a = b;
			b = t % a;
		}
		return a;
	}

}
