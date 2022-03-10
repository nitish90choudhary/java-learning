package com.learn.common.algo.ds;

import com.learn.common.pojo.Node;

public class DoublyEndedLinkedList {

	private Node head;
	private Node tail;

	public void addNodeAtTail(int data) {
		Node node = new Node(data);
		if (this.head == null) {
			this.head = node;
			this.tail = node;
		}
		if (this.tail != null) {
			this.tail.setNextNode(node);
			this.tail = node;
		}
	}

	@Override
	public String toString() {
		String str = "LinkedList{";
		Node current = this.head;
		while (current != null) {
			str += current.toString() + ", ";
			current = current.getNextNode();
		}
		str += "}";
		return str;
	}
}
