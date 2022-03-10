package com.learn.common.algo.search;

import java.util.Arrays;

//Time complexity : O(logn)
public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = { 12, 14, 21, 16, 17, 45, 67, 89, 191 };
		int term = 451;
		System.out.println("Data : " + Arrays.toString(arr));
		int index = search(arr, 0, arr.length, term);

		System.out.println("Element " + term + " is present at :" + index);
	}

	private static int search(int[] arr, int i, int j, int term) {
		if (j >= i) {
			int mid = (i + j) / 2;

			if (arr[mid] == term)
				return mid;
			else if (arr[mid] > term) // search left
				return search(arr, i, mid, term);
			else
				return search(arr, mid + 1, j - 1, term); //search right
		}
		return -1;
	}
}
