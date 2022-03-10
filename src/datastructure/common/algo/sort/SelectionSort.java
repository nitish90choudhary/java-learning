package com.learn.common.algo.sort;

//It is a O(n2) algo
// Swapping the minimum value to first

public class SelectionSort {
	public static void main(String[] args) {
		SelectionSort selectionSort = new SelectionSort();
		int[] arr = { 1, 100, 12, 45, 14, 22, 65, 7 };
		print(arr);

		print(selectionSort.sort2(arr));
	}

	static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println("");
	}

	private int[] sort(int[] arr) {

		//Loop for array item iterations
		for (int i = 0; i < arr.length; i++) {
			//find min in the array and replace with index
			int minIndex = findMinIndex(arr, i);

			//swap min
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
		return arr;
	}

	private int[] sort2(int[] arr) {

		//Loop for array item iterations
		for (int i = 0; i < arr.length; i++) {
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[minIndex] > arr[j]) {
					minIndex = j;
				}
			}
			//swap min
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;

			System.out.print("Pass " + i + " :");
			print(arr);
		}
		return arr;
	}

	int findMinIndex(int[] arr, int start) {
		int minIndex = start;
		for (int i = start; i < arr.length - 1; i++) {
			if (arr[minIndex] > arr[i + 1])
				minIndex = i + 1;
		}
		return minIndex;
	}
}
