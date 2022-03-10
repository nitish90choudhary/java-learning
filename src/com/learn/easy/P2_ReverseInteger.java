package com.learn.easy;

public class P2_ReverseInteger {

	/**
	 * Given a signed 32-bit integer x, return x with its digits reversed.
	 * If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1],
	 * then return 0.
	 * <p>
	 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
	 * <p>
	 * <p>
	 * <p>
	 * Example 1:
	 * <p>
	 * Input: x = 123
	 * Output: 321
	 * Example 2:
	 * <p>
	 * Input: x = -123
	 * Output: -321
	 * Example 3:
	 * <p>
	 * Input: x = 120
	 * Output: 21
	 * Example 4:
	 * <p>
	 * Input: x = 0
	 * Output: 0
	 * <p>
	 * <p>
	 * Constraints:
	 * <p>
	 * -231 <= x <= 231 - 1
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		int value = 12030;
		System.out.println("input: " + value);
		System.out.println("output: " + reverseInteger(value));
	}

	private static int reverseInteger(int num) {
		if (num > Integer.MAX_VALUE || num < Integer.MIN_VALUE)
			return 0;
		String fin = "";
		while (num != 0) {
			int remainder = num % 10;
			num = num / 10;
			fin += remainder;
		}

		return Integer.parseInt(fin);
	}

	private static void print(int[] num) {
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + "\t");
		}

	}
}

/**
 * Approach 1: Pop and Push Digits & Check before Overflow
 * Intuition
 * <p>
 * We can build up the reverse integer one digit at a time. While doing so, we can check beforehand whether or not appending another digit would cause overflow.
 * <p>
 * Algorithm
 * <p>
 * Reversing an integer can be done similarly to reversing a string.
 * <p>
 * We want to repeatedly "pop" the last digit off of xx and "push" it to the back of the \text{rev}rev. In the end, \text{rev}rev will be the reverse of the xx.
 * <p>
 * To "pop" and "push" digits without the help of some auxiliary stack/array, we can use math.
 * <p>
 * //pop operation:
 * pop = x % 10;
 * x /= 10;
 * <p>
 * //push operation:
 * temp = rev * 10 + pop;
 * rev = temp;
 */