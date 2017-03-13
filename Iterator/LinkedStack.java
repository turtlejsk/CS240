package Iterator;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import Stack.StackInterface;


public class LinkedStack<T> implements StackInterface<T>, Iterable<T> {

	private Node firstNode;
	private int numberOfEntries;
	

	public LinkedStack() {
		firstNode = null;
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
		

		@SuppressWarnings("unused")
		private void setNextNode(Node next) {
			 this.next = next;
		}
		
	}
	

	public void push(T newEntry) {
		Node newNode = new Node(newEntry, firstNode);
		firstNode = newNode;
		numberOfEntries++;
	}

	

	public T pop() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		else {
			T data = firstNode.getData();
			firstNode.setData(null);
			firstNode = firstNode.getNextNode();
			numberOfEntries--;
			return data;
		}
	}

	

	public T peek() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		else {
			
			return firstNode.getData();
		}
	}

	
	public boolean isEmpty() {
		return numberOfEntries <= 0;
	}

	

	public void clear() {
		while(!isEmpty()) {
			pop();
		}
	}

	

	private class LinkedStackIterator implements Iterator<T>{
		private Node next;
		
		private LinkedStackIterator() {
			next = firstNode;
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
	

	@Override
	public Iterator<T> iterator() {
		return new LinkedStackIterator();
	}
}
