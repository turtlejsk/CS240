package Stack;

import java.util.EmptyStackException;

public class StackLinked<T> implements StackInterface<T> {
	Node H;
	Node T;
	int numberOfEntries;

	public StackLinked() {
		// TODO Auto-generated constructor stub
		numberOfEntries = 0;
		H = new Node();
		T = H;
	}

	@Override
	public void push(T newEntry) {
		// TODO Auto-generated method stub
		/*
		 * if (numberOfEntries == 0) { Node n = new Node(newEntry); H.next = n;
		 * T = n; numberOfEntries++; } else {
		 */
		Node n = new Node(newEntry);
		T.next = n;
		T = n;
		numberOfEntries++;

	}

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		if (!isEmpty()) {
			T temp = T.data;
			Node a = H;
			for (int i = 0; i < numberOfEntries - 1; i++) {
				a = a.next;
			}
			a.next = null;
			T = a;
			numberOfEntries--;
			return temp;
		} else {
			System.out.println("Stack is Empty.");
			throw new EmptyStackException();
		}
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		if (!isEmpty()) {
			return T.data;
		} else {
			System.out.println("Stack is Empty.");
			throw new EmptyStackException();
		}
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (H.next == null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		H.next=null;
	}

	public void print() {
		if (!isEmpty()) {
			Node a = H.next;
			for (int i = 0; i < numberOfEntries; i++) {
				System.out.println(a.data);
				a = a.next;
			}
		}else{
			System.out.println("Stack is Empty.");
			throw new EmptyStackException();
		}
	}

	class Node {
		Node next;
		T data;

		public Node() {
		}

		public Node(T data) {
			this.data = data;
		}

		public Node(T data, Node next) {
			this.next = next;
			this.data = data;
		}
	}
}
