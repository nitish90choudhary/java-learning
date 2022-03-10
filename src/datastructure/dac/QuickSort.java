package com.learn.dac;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = { 12, 32, 4, 56, 77, 34, 23, 99, 45, 3, 12, 45 };
		QuickSort quickSort = new QuickSort();
		System.out.print("Before : ");
		quickSort.display(arr);
		System.out.println("QuickSort : ");
		quickSort.quickSort(arr, 0, arr.length - 1);
		quickSort.display(arr);

	}

	/**
	 * <p>The algorithm picks a pivot element, rearranges the array elements in such a way that all elements smaller
	 * than the picked pivot element move to left side of pivot, and all greater elements move to right side. Finally,
	 * the algorithm recursively sorts the subarrays on left and right of pivot element.
	 * </p>
	 * <p>There are many different versions of quickSort that pick pivot in different ways.
	 * 1. Always pick first element as pivot.
	 * 2. Always pick last element as pivot (implemented below)
	 * 3. Pick a random element as pivot.
	 * 4. Pick median as pivot.
	 * The key process in quickSort is partition().
	 * Target of partitions is, given an array and an element x of array as pivot, put x at its correct position
	 * in sorted array and put all smaller elements (smaller than x) before x, and put all greater elements
	 * (greater than x) after x. All this should be done in linear time.
	 * </p>
	 *
	 * @param arr
	 * @param index
	 * @param end
	 * @return
	 */
	public void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int pi = partition(arr, low, high);
			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high);
		}

	}

	public int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (arr[j] < pivot) {
				i++;
				//swap arr[i] and arr[j]
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		//swap arr[i+1] and arr[high]/pivot
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;
		return (i + 1);
	}

	private void display(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println("");
	}
}
