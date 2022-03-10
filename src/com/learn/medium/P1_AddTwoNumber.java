package com.learn.medium;

public class P1_AddTwoNumber {

	/*
	 You are given two non-empty linked lists representing two non-negative integers.
	 The digits are stored in reverse order, and each of their nodes contains a single digit.
	 Add the two numbers and return the sum as a linked list.

	 You may assume the two numbers do not contain any leading zero, except the number 0 itself.
	 Input: l1 = [2,4,3], l2 = [5,6,4]
	 Output: [7,0,8]
	 Explanation: 342 + 465 = 807.
	 Example 2:
	 Input: l1 = [0], l2 = [0]
	 Output: [0]

	 Example 3:
	 Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
	 Output: [8,9,9,9,0,0,0,1]

	 Constraints:
	 The number of nodes in each linked list is in the range [1, 100].
	 0 <= Node.val <= 9
	 It is guaranteed that the list represents a number that does not have leading zeros.
	 */
	public static void main(String[] args) {
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(4);
		ListNode node3 = new ListNode(3);

		ListNode node4 = new ListNode(5);
		ListNode node5 = new ListNode(6);
		ListNode node6 = new ListNode(7);
		node1.next = node2;
		node2.next = node3;
		node3.next = null;

		node4.next = node5;
		node5.next = node6;
		node6.next = null;

		print(node1);
		print(node4);

		ListNode result = addTwoNumbers(node1, node4);
		print(result);
	}

	private static void print(ListNode list) {
		while (list != null) {
			System.out.print(list.val + "--->");
			list = list.next;
		}
		System.out.println();
	}

	/**
	 * @param l1 -first linked list
	 * @param l2 - second linked list
	 * @return sum of linked list
	 * Time complexity : O(max(m, n))
	 */
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// Input: l1 = [2,4,3], l2 = [5,6,4]
		//	 Output: [7,0,8]
		ListNode current = null;
		ListNode head = current;
		if (l1 == null || l2 == null)
			throw new IllegalArgumentException("Null list");

		int carry = 0;
		while (l1 != null || l2 != null) {
			ListNode node = new ListNode();
			int x = (l1 != null) ? l1.val : 0;
			int y = (l2 != null) ? l2.val : 0;
			int sum = 0;

			sum = x + y + carry;
			carry = sum / 10;
			node.val = sum % 10;
			if (current == null)
				head = current = node;
			else {
				current.next = node;
				current = current.next;
			}
			if (l1 != null)
				l1 = l1.next;
			if (l2 != null)
				l2 = l2.next;
		}
		if (carry > 0)
			current.next = new ListNode(carry);

		return head;
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
}