package com.learn.common.algo.sort;

import java.util.Arrays;

import com.learn.common.pojo.Circle;

//It is a O(n2) algo
public class InsertionSort {
	public static void main(String[] args) {
		InsertionSort insertionSort = new InsertionSort();
		int[] arr = { 1, 100, 12, 45, 14, 22, 65, 45, 7 };
		System.out.println(Arrays.toString(arr));

		System.out.println(Arrays.toString(insertionSort.sort(arr)));

		//circle sorting radius

		Circle[] circleradius = { new Circle(4), new Circle(2), new Circle(12), new Circle(7) };

		System.out.println("Circle :" + Arrays.toString(circleradius));
		System.out.println("Circle after sort :" + Arrays.toString(insertionSort.sort(circleradius)));

	}

	private int[] sort(int[] arr) {

		//Loop for array item iterations
		for (int i = 0; i < arr.length; i++) {
			int current = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > current) { // > will make stable sort
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = current;
			System.out.print("Pass " + i + " :");
			System.out.println(Arrays.toString(arr));
		}
		return arr;
	}

	///generic sort method
	private Circle[] sort(Circle[] arr) {

		//Loop for array item iterations
		for (int i = 0; i < arr.length; i++) {
			Circle current = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j].getRadius() > current.getRadius()) { // > will make stable sort
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = current;
			System.out.print("Pass " + i + " :");
			System.out.println(Arrays.toString(arr));
		}
		return arr;
	}

	///generic sort method
	/*private <T> [] sort(<T>[] arr) {

		//Loop for array item iterations
		for (int i = 0; i < arr.length; i++) {
			<T> current = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j].getRadius() > current.getRadius()) { // > will make stable sort
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = current;
			System.out.print("Pass " + i + " :");
			System.out.println(Arrays.toString(arr));
		}
		return arr;
	}
*/
}
