package com.learn.dac;

public class MaxMin {

	public static void main(String[] args) {
		int[] arr = { 12, 114, 211, 16, 171, 145, 67, 89, 191,0 };

		System.out.println("Max Element is : " + max(arr,0,arr.length ));
		System.out.println("Min Element is : " + min(arr,0,arr.length ));
	}

	private static int max(int[] arr, int index, int length) {
		if (index >= length -2) {
			if (arr[index] > arr[index + 1])
				return arr[index];
			else
				return arr[index + 1];
		}

		int max = max(arr, index + 1, length);
		if (arr[index] > max)
			return arr[index];
		else
			return max;

	}

	private static int min(int[] arr, int index, int length) {
		if (index >= length -2) {
			if (arr[index] < arr[index + 1])
				return arr[index];
			else
				return arr[index + 1];
		}

		int min = min(arr, index + 1, length);
		if (arr[index] < min)
			return arr[index];
		else
			return min;

	}
}
