package Queue;

import java.util.EmptyStackException;
/**
@author JSK
*/
public class SingleLinkedQueue<T> implements QueueInterface<T> {

	Node front;
	Node back;
	int numberOfEntries;

	public SingleLinkedQueue() {
		// TODO Auto-generated constructor stub
		front = new Node();
		back = front;
		numberOfEntries = 0;
	}

	@Override
	public void enqueue(T newEntry) {
		// TODO Auto-generated method stub
		Node newNode = new Node(newEntry);
		back.next = newNode;
		back = newNode;
		numberOfEntries++;

	}

	@Override
	public T dequeue() {
		// TODO Auto-generated method stub
		if (!isEmpty()) {
			T temp = front.data;
			front.next = front.next.next;
			numberOfEntries--;
			return temp;
		} else {
			System.out.println("Stack is Empty.");
			throw new EmptyStackException();
		}
	}

	@Override
	public T getFront() {
		// TODO Auto-generated method stub
		return front.data;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (numberOfEntries != 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		front.next=null;
	}

	class Node {
		T data;
		Node next;

		public Node() {

		}

		public Node(T data) {
			this.data = data;
		}
	}
}
