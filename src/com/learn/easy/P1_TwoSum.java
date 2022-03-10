package com.learn.easy;

import java.util.HashMap;

public class P1_TwoSum {

	/**
	 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
	 * <p>
	 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
	 * <p>
	 * You can return the answer in any order.
	 * Example 1:
	 * <p>
	 * Input: nums = [2,7,11,15], target = 9
	 * Output: [0,1]
	 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
	 * Example 2:
	 * <p>
	 * Input: nums = [3,2,4], target = 6
	 * Output: [1,2]
	 * Example 3:
	 * <p>
	 * Input: nums = [3,3], target = 6
	 * Output: [0,1]
	 * <p>
	 * Constraints:
	 * <p>
	 * 2 <= nums.length <= 103
	 * -109 <= nums[i] <= 109
	 * -109 <= target <= 109
	 * Only one valid answer exists.
	 */
	public static void main(String[] args) {
		int[] nums = { 3, 2, 4 };
		int target = 6;
		int[] results = twoSum(nums, target);
		//print(results);
		results = twoSum2(nums, target);
		print(results);
	}

	/**
	 * Brute force technique
	 * Time complexity: O(n2)
	 * Space complexity: O(1)
	 */
	private static int[] twoSum(int[] nums, int target) {
		int start = 0;
		while (start <= nums.length - 1) {
			for (int i = start + 1; i < nums.length; i++) {
				if (target == nums[start] + nums[i]) {
					return new int[] { start, i };
				}
			}
			start++;
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	/**
	 * 1-pass Hash table
	 * Time complexity: O(n) ; lookup in hasmap takes O(1)
	 * Space complexity: O(n)
	 *
	 * @param num
	 */
	private static int[] twoSum2(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int compliment = target - nums[i];
			if (map.containsKey(compliment))//look back: return immediately
				return new int[] { map.get(compliment), i };
			else
				map.put(nums[i], i);

		}
		throw new IllegalArgumentException("No two sum solution");
	}

	private static void print(int[] num) {
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + "\t");
		}

	}
}