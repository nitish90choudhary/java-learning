package com.learn.common.algo.ds;

public class DoubleEnddedLinkedListDemo {
	public static void main(String[] args) {
		DoublyEndedLinkedList dlinkedList = new DoublyEndedLinkedList();

		dlinkedList.addNodeAtTail(10);
		dlinkedList.addNodeAtTail(60);
		dlinkedList.addNodeAtTail(25);
		dlinkedList.addNodeAtTail(110);
		dlinkedList.addNodeAtTail(30);

		System.out.println(dlinkedList);

	}
}
