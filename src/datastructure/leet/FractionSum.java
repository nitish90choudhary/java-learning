package com.learn.leet;

public class FractionSum {

	/*
	 * Input should be Array of String : ["2/3+5/9","1/3+4/3"]
	 *
	 * Output should be an Array of String with sum in reduced form
	 * */
	public static void main(String[] args) {
		int[] numerators = new int[] { 2, 5 };
		int[] denominators = new int[] { 3, 6 };
		//result should be: 9/6

		String[] input = new String[] { "2/3+5/9", "1/3+4/3" };
		String[] output = new String[input.length];

		for (int i = 0; i < input.length; i++) {

			String val1 = input[i].substring(0, input[0].indexOf('+'));
			String val2 = input[i].substring(input[0].indexOf('+') + 1);

			numerators[0] = Integer.parseInt(val1.substring(0, val1.indexOf('/')));
			denominators[0] = Integer.parseInt(val1.substring(val1.indexOf('/') + 1));

			numerators[1] = Integer.parseInt(val2.substring(0, val2.indexOf('/')));
			denominators[1] = Integer.parseInt(val2.substring(val2.indexOf('/') + 1));

			int lcm = calculateLCM(denominators[0], denominators[1]);

			//calculate sum of  Numerator
			int sum = (lcm / denominators[0]) * numerators[0] + (lcm / denominators[1]) * numerators[1];

			output[i] = reduce(sum, lcm);
		}

		for (int i = 0; i < output.length; i++) {
			System.out.print(output[i]+"\t");
		}

//		// 1. Calculate GCD
//		int hcf = calculateHCF(3, 6);
//		//System.out.println("HCF:" + calculateHCF(24, 10));
//
//		//2. Calculate LCM using num1*num2=HCF*LCM
//		int lcm = calculateLCM(3, 6);
//		System.out.println("LCM:" + calculateLCM(24, 10));
//
//		//calculate sum of  Numerator
//		int sum = (lcm / denominators[0]) * numerators[0] + (lcm / denominators[1]) * numerators[1];
//
//		// Reduce the form and get result
//		System.out.println("sum is: " + reduce(sum, lcm));
	}

	private static int calculateHCF(int a, int b) {
		while (b != 0) {
			int temp;
			temp = a;
			a = b;
			b = temp % a;
		}

		return a;
	}

	private static int calculateLCM(int a, int b) {
		return (a * b) / calculateHCF(a, b);
	}

	private static String reduce(int a, int b) {
		int hcf = calculateHCF(a, b);
		return (a / hcf) + "/" + (b / hcf);
	}

}
