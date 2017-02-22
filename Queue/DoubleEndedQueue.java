package Queue;

import java.util.EmptyStackException;

import Queue.SingleLinkedQueue.Node;

public class DoubleEndedQueue<T> implements DequeInterface<T> {

	Node front;
	Node rear;
	int size;

	public DoubleEndedQueue() {
		// TODO Auto-generated constructor stub
		this.size = 0;
	}

	@Override
	public void addToFront(T newEntry) {
		// TODO Auto-generated method stub
		Node newNode = new Node(newEntry,front);
		if (isEmpty()) {
			front = newNode;
			rear = newNode;
		} else {
			front.setPrev(newNode);
			front = newNode;
		}
		size++;
	}

	@Override
	public void addToBack(T newEntry) {
		// TODO Auto-generated method stub
		Node newNode = new Node(rear,newEntry);
		if (isEmpty()) {
			front = newNode;
			rear = newNode;
		} else {
			rear.setNext(newNode);
			rear = newNode;
		}
		size++;
	}

	@Override
	public T removeFront() {
		// TODO Auto-generated method stub
		T temp;
		Node newfront = front.getNext();
		temp = front.getData();
		front.getNext().setPrev(null);
		front.setNext(null);
		front = newfront;
		size--;
		return temp;
	}

	@Override
	public T removeBack() {
		// TODO Auto-generated method stub
		if (!isEmpty()) {
			T temp;
			Node newRear = rear.getPrev();
			temp = rear.getData();
			rear.getPrev().setNext(null);
			rear.setPrev(null);
			rear = newRear;
			size--;
			return temp;
		} else {
			throw new EmptyStackException();
		}
	}

	@Override
	public T getFront() {
		// TODO Auto-generated method stub
		return front.getData();
	}

	@Override
	public T getBack() {
		// TODO Auto-generated method stub
		return rear.getData();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (size == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		front = null;
		rear = null;
	}

	class Node {
		T data;
		Node prev;
		Node next;

		public Node() {

		}

		public Node(T data) {
			this.data = data;
		}

		public Node(Node prev, T data, Node next) {
			this.prev = prev;
			this.data = data;
			this.next = next;
		}

		public Node(Node prev, T data) {
			this.prev = prev;
			this.data = data;
		}

		public Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}

		public T getData() {
			return data;
		}

		public Node getNext() {
			return next;
		}

		public Node getPrev() {
			return prev;
		}

		public void setData(T data) {
			this.data = data;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public void setPrev(Node prev) {
			this.prev = prev;
		}
	}

}
