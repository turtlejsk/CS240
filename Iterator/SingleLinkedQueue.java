package Iterator;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import Queue.QueueInterface;


public class SingleLinkedQueue<T> implements QueueInterface<T>, Iterable<T>{

	private Node front;
	private Node back;
	private int numberOfEntries;
	
	public SingleLinkedQueue() {
		front = null;
		back = null;
		numberOfEntries = 0;
	}
	
	
	
	private class SingleLinkedQueueIterator implements Iterator<T>{
		Node next;
		
		
		private SingleLinkedQueueIterator() {
			next = front;
		}
		

		public boolean hasNext() {		
			return next != null;
		}

		
		

		public T next() {
			if(hasNext()) {
				T temp = next.getData();
				next = next.getNextNode();
				return temp;
			}
			else {
				throw new NoSuchElementException();
			}
		}
	}
	

	private class Node {
		private T data;
		private Node next;
		
		

		private Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}
		

		private T getData() {
			return data;
		}
		

		private void setData(T data) {
			this.data = data;
		}
		

		private Node getNextNode() {
			return next;
		}
		
		

		private void setNextNode(Node next) {
			 this.next = next;
		}
		
	}
	

	public void enqueue(T newEntry) {
		Node newNode = new Node(newEntry, null);
		if(isEmpty()) {
			front = newNode;
			back = newNode;
		}
		else {
			back.setNextNode(newNode);
			back = newNode;
		}
		numberOfEntries++;
	}

	

	public T dequeue() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		else {
			T data = front.getData();
			front.setData(null);
			front = front.getNextNode();
			numberOfEntries--;
			return data;
		}
	}

	

	public T getFront() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		else 
			return front.getData();
	}


	public boolean isEmpty() {
		return numberOfEntries <= 0;
	}

	
	public void clear() {
		while(!isEmpty()) {
			dequeue();
		}
	}


	@Override
	public Iterator<T> iterator() {
		return new SingleLinkedQueueIterator();
	}

}
