package com.learn.leet;

public class DiffOfOddAndEven {
	public static void main(String[] args) {
		int input = 12341243;

		int odd = 0;
		int even = 0;

		while (input != 0) {
			int remainder = input % 10;
			if (remainder % 2 == 0)
				even += remainder;
			else
				odd += remainder;
			input = input / 10;

		}

		System.out.println("Difference of oddd and even:" + (even - odd));
	}
}
