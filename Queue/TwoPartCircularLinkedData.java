package Queue;

import java.util.EmptyStackException;

public class TwoPartCircularLinkedData<T> implements QueueInterface<T> {
	Node back;
	Node free;
	final int size = 10;
	int numberOfEntries;

	public TwoPartCircularLinkedData() {
		// TODO Auto-generated constructor stub
		this.numberOfEntries = 0;
		free = new Node();
		free.next=free;
		back = free;

	}

	@Override
	public void enqueue(T newEntry) {
		// TODO Auto-generated method stub
		if (numberOfEntries == 10) {
			return;
		}
		else if(isEmpty()) {
			free.data=newEntry;
			Node newNode = new Node(null, free.next);
			free.next=newNode;
			free=newNode;
			numberOfEntries++;
		}else{
			Node newNode = new Node(null,back.next);

			back.next=newNode;
			back=newNode;
			numberOfEntries++;
		}
	}

	@Override
	public T dequeue() {
		// TODO Auto-generated method stub
		if(!isEmpty()){
			return null;
		}else{
			throw new EmptyStackException();
		}
		
	}

	@Override
	public T getFront() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (free == back) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	class Node {
	
		T data;
		Node next;

		public Node() {

		}

		public Node(T data) {
			this.data = data;
		}

		public Node(Node next) {
			this.next = next;
		}

		public Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}
		
	}

}
