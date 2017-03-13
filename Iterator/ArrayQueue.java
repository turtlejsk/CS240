package Iterator;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import Queue.QueueInterface;


public class ArrayQueue<T> implements QueueInterface<T>, Iterable<T>{

	private final T[] array;
	private int front;
	private int back;
	private int numberOfEntries;
	private boolean initialized = false;
	
	

	private class ArrayQueueIterator implements IteratorInterface<T> {
		private int nextPosition;
		private int previousPosition;
		@SuppressWarnings("unused")
		private boolean wasNextCalled;
		
		private ArrayQueueIterator() {
			nextPosition = front;
			previousPosition = front - 1;
			wasNextCalled = false;
		}
		
	
		public boolean hasNext() {		
			return array[nextPosition] != null;
			
		}
		
		public T next() {
			if(hasNext()) {
				T temp = array[nextPosition];
				nextPosition++;
				nextPosition = nextPosition % array.length;
				previousPosition++;
				previousPosition = previousPosition % array.length;
				wasNextCalled = true;
				return temp;
			}
			else {
				throw new NoSuchElementException("The iterator reached the end");
			}
			
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
			
		}
		
		public boolean hasPrevious() {
			return array[previousPosition] != null;
		}
		
		public T previous() {
			if(hasPrevious()) {
				T temp = array[previousPosition];
				nextPosition--;
				if(nextPosition < 0)
					nextPosition = array.length - 1;
				previousPosition--;
				if(previousPosition < 0)
					previousPosition = array.length - 1;
				wasNextCalled = true;
				return temp;
			}
			else {
				throw new NoSuchElementException();
			}
		}
	}
	

	
	public ArrayQueue() {
		this(11);
	}
	
	
	public ArrayQueue(int capacity) {
		@SuppressWarnings("unchecked")
		T[] tempArray = (T[])new Object[capacity];
		array = tempArray;
		numberOfEntries = 0;
		front = 0;
		back = 0;
		initialized = true;
		
	}
	
	
	public void enqueue(T newEntry) {
		checkInitialization();
		if(!isFull()) {
			array[back] = newEntry;	
			back++;
			back = back % array.length;
			numberOfEntries++;
		}
	}

	
	public T dequeue() {
		checkInitialization();
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		else {
			T temp = array[front];
			array[front] = null;
			front++;
			front = front % array.length;
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
			return array[front];
		}
	}

	
	public boolean isEmpty() {
		return numberOfEntries == 0;
	}

	
	public void clear() {
		while(!isEmpty()) {
			dequeue();
		}
	}
	
    private void checkInitialization() {
        if (!initialized)
             throw new SecurityException("ArrayQueue object is not initialized " +
                                        "properly.");
   }
    
   
 	public boolean isFull() {
 		return numberOfEntries >= array.length - 1;
 	}


	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return (Iterator<T>) new ArrayQueueIterator();
	}
 
}
