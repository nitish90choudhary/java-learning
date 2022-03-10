package com.learn.common.algo.ds;

public class LinkedListDemo {
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();

		linkedList.addNodeAtHead(10);
		linkedList.addNodeAtHead(60);
		linkedList.addNodeAtHead(25);
		linkedList.addNodeAtHead(110);
		linkedList.addNodeAtHead(30);

		System.out.println(linkedList);
		System.out.println("Length of list: " + linkedList.length());
		linkedList.deleteNodeAtHead();
		System.out.println("After deletion of head node: " + linkedList);
		System.out.println("Find node index at : " + linkedList.findNodeIndex(60));
		System.out.println("Find node : " + linkedList.find(60));
		linkedList.addNodeAtIndex(600, 2);
		System.out.println("Add node at index 2 : " + linkedList);

		LinkedList linkedList2 = new LinkedList();

		linkedList2.addNodeInSortedList(10);
		System.out.println("Add node in empty list : " + linkedList2);
		linkedList2.addNodeInSortedList(111);
		System.out.println("Add node in 1 data list : " + linkedList2);
		linkedList2.addNodeInSortedList(20);
		System.out.println("Add node in between two data  : " + linkedList2);
		linkedList2.addNodeInSortedList(200);
		System.out.println("Add  200 data  : " + linkedList2);
		linkedList2.addNodeInSortedList(190);
		System.out.println("Add  190 data  : " + linkedList2);

	}
}
