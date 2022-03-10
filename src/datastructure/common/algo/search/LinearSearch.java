package com.learn.common.algo.search;

import java.util.Arrays;

// Time complexity = O(n)
public class LinearSearch {
	public static void main(String[] args) {
		int[] arr = { 12, 32, 4, 56, 77, 34, 23, 99, 45, 3, 12, 45 };
		LinearSearch linearSearch = new LinearSearch();

		System.out.println("Data is " + Arrays.toString(arr));
		System.out.println("Element is at :" + linearSearch.linearSearch(arr, 77));
		System.out.println("Better LS , Element is at :" + linearSearch.betterLinearSearch(arr, 77));
	}

	public int linearSearch(int[] arr, int search_item) {

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == search_item)
				return i;
		}
		return -1;
	}

	// it searches from left and right
	public int betterLinearSearch(int[] arr, int search_item) {

		for (int left = 0, right = arr.length - 1; left <= right; left++, right--) {

			if (arr[left] == search_item)
				return left;
			if (arr[right] == search_item)
				return right;
		}
		return -1;
	}
}
