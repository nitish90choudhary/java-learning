package com.learn.common.algo.sort;

//It is a O(n2) algo
public class BubbleSort {
	public static void main(String[] args) {
		BubbleSort bubbleSort = new BubbleSort();
		int[] arr = { 1, 100, 12, 45, 14, 22, 65, 7 };
		print(arr);

		print(bubbleSort.sort(arr));
	}

	static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println("");
	}

	private int[] sort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {

			for (int j = 0; j < arr.length - 1 - i; j++) {

				if (arr[j] > arr[j + 1]) {
					//swap
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}

			}
			System.out.print("Pass " + i + " :");
			print(arr);
		}
		return arr;
	}
}
