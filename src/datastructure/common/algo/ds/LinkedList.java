package com.learn.common.algo.ds;

import com.learn.common.pojo.Node;

public class LinkedList {

	private Node head;

	public void addNodeAtHead(int data) {
		Node node = new Node(data);
		node.setNextNode(this.head);
		this.head = node;
	}

	public void addNodeAtEnd(int data) {
		Node node = new Node(data);
		Node current = this.head;
		while (current != null) {
			if (current.getNextNode() == null) {
				current.setNextNode(node);
				break;
			}
			current = current.getNextNode();
		}
	}

	public void addNodeAtIndex(int data, int index) {
		Node newNode = new Node(data);
		int idx = 0;
		Node current = this.head;
		while (current != null) {
			if (idx == index - 1) {
				newNode.setNextNode(current.getNextNode());
				current.setNextNode(newNode);
			}
			current = current.getNextNode();
			idx++;
		}
	}

	public void addNodeInSortedList(int data) {
		Node newNode = new Node(data);
		Node current = this.head;
		Node currentNext;
		//Empty list
		if (this.head == null) {
			addNodeAtHead(data);
			return;
		}
		//list with one data
		if (this.head.getNextNode() == null) {
			addNodeAtEnd(data);
			return;
		}
		//List with more than one data
		if (this.head.getNextNode() != null) {
			currentNext = this.head.getNextNode();
			while (currentNext != null) {
				if (currentNext.getData() > data) {
					newNode.setNextNode(currentNext);
					current.setNextNode(newNode);
					return;
				}
				current = currentNext;
				currentNext = currentNext.getNextNode();
			}
			addNodeAtEnd(data);
		}
	}

	public void deleteNodeAtHead() {
		this.head = this.head.getNextNode();
	}

	public int findNodeIndex(int data) {
		int index = 0;
		boolean found = false;
		Node current = this.head;
		while (current != null) {
			if (current.getData() == data) {
				found = true;
				break;
			}
			current = current.getNextNode();
			index++;
		}
		return found ? index : -1;
	}

	public Node find(int data) {
		Node current = this.head;
		while (current != null) {
			if (current.getData() == data) {
				return current;
			}
			current = current.getNextNode();
		}
		return null;
	}

	public int length() {
		int length = 0;
		Node current = this.head;
		while (current != null) {
			length++;
			current = current.getNextNode();
		}
		return length;
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
