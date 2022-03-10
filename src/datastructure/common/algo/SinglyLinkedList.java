package com.learn.common.algo;

import com.learn.common.pojo.Node;

public class SinglyLinkedList {

	Node node4 = new Node(28, null);
	Node node3 = new Node(55, node4);
	Node node2 = new Node(25, node3);
	Node head = new Node(20, node2);

	public static void main(String[] args) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
		singlyLinkedList.printList(singlyLinkedList.head);

		Node newNode = new Node(100, null);
		singlyLinkedList.addNode(singlyLinkedList.head, newNode, 2);
		singlyLinkedList.printList(singlyLinkedList.head);
	}

	void printList(Node head) {
		System.out.println("Printing Singly LinkedList");
		while (head != null) {
			System.out.print(head.getData() + " ----> ");
			head = head.getNextNode();
		}
		System.out.println("NULL");
	}

	void addNode(Node head, Node node, int index) {
		System.out.println("Adding node in Singly LinkedList at index: " + index);
		int nodeCount = 0;
		Node ptr = head;
		while (index > nodeCount) {
			nodeCount++;
			ptr = ptr.getNextNode();
		}
		node.setNextNode(ptr.getNextNode());
		ptr.setNextNode(node);
	}

	void deleteNodeAtIndex(int index) {
		System.out.println("Deleting node from Singly LinkedList from index: " + index);
	}

	void deleteNode(int data) {
		System.out.println("Deleting node from Singly LinkedList");
	}
}

