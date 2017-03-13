package Iterator;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import Queue.QueueInterface;;


public class CircularQueue<T> implements QueueInterface<T>, Iterable<T> {

	private Node free;
	private Node back;
	private int numberOfEntries;
	private int numberOfNodes;
	private boolean initialized = false;
	
	
	// initiate the circular linked data.
	public CircularQueue() {
		free = new Node(null,null);
		back = free;
		back.setNextNode(free);
		numberOfEntries = 0;
		numberOfNodes = 1;
		initialized = true;
	}
	
	
	
	// Node contains data field and a reference to another node.
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
			checkInitialization();
			if (!isFull()) {
				if(numberOfNodes <= 10) {
					Node temp = new Node(newEntry,back.getNextNode());
					back.setNextNode(temp);
					back = temp;
					numberOfNodes++;
				}
				else {
					back.getNextNode().setData(newEntry);
					back = back.getNextNode();
				}
				numberOfEntries++;
			}
		}

	
		public T dequeue() {
			checkInitialization();
			if(isEmpty()) {
				throw new EmptyStackException();
			}
			else {
				T temp = free.getNextNode().getData();
				free.getNextNode().setData(null);
				free = free.getNextNode();
				numberOfEntries--;
				return temp;
			}
		}

		
		public T getFront() {
			checkInitialization();
			if(isEmpty()) {
				throw new EmptyStackException();
			}
			else {
				return free.getNextNode().getData();
			}
		}

	
		public boolean isEmpty() {
			return numberOfEntries <= 0;
		}

	
		public void clear() {
			while(!isEmpty()) {
				dequeue();
			}
		}
		
		
		public boolean isFull() {
			return numberOfEntries >= 9;
		}
		
		
	    private void checkInitialization()
	    {
	        if (!initialized)
	             throw new SecurityException("CircularLinkedData object is not initialized " +
	                                        "properly.");
	   }
	    
	public Iterator<T> iterator() {
		
		return new CircularLinkedDataIterator();
	}
	
	

	private class CircularLinkedDataIterator implements Iterator<T> {
		private Node next;
		
		private CircularLinkedDataIterator() {
			next = free.getNextNode();
		}
		
	
		public boolean hasNext() {		
			return next.getData() != null;
			
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

}
