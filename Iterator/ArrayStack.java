package Iterator;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;
import Stack.StackArray;


public class ArrayStack<T> extends StackArray<T> {
	
	private final T[] array;
	private int indexOfTopElement;
	private static final int DEFAULT_CAPACITY = 20;
	private boolean initialized = false;

	
	public ArrayStack(int capacity) {
		@SuppressWarnings("unchecked")
		T[] tempArr = (T[]) new Object[capacity];
		array = tempArr;
		indexOfTopElement = -1;
		initialized = true;
	}
	
	
	public ArrayStack() {
		this(DEFAULT_CAPACITY);
	}

	public IteratorInterface<T> iterator() {
		return new IteratorForArrayStack();
	}
	
	private class IteratorForArrayStack implements IteratorInterface<T>{
		
		private int nextPosition;
		private int previousPosition;
		private boolean wasNextCalled;
		
		private IteratorForArrayStack() {
			nextPosition = indexOfTopElement;
			previousPosition = nextPosition + 1;
			wasNextCalled = false;
		}
		
		
		public boolean hasNext() {		
			return nextPosition > -1;
			
		}
		

		public T next() {
			if(hasNext()) {
				T temp = array[nextPosition];
				nextPosition--;
				previousPosition--;
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
			return previousPosition <= indexOfTopElement;
		}
		
		
		public T previous() {
			if(hasPrevious()) {
				T temp = array[previousPosition];
				previousPosition++;
				nextPosition++;
				wasNextCalled = true;
				return temp;
			}
			else {
				throw new NoSuchElementException();
			}
		}
	}
	


	
	@Override
	public void push(T newEntry) {
		checkInitialization();
		if(!isFull()) {
			indexOfTopElement++;
			array[indexOfTopElement] = newEntry;
		}
	}

	
	@Override
	public T pop(){
		checkInitialization();
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		else {
			T temp = array[indexOfTopElement];
			array[indexOfTopElement] = null;
			indexOfTopElement--;
			return temp;
		}
	}

	@Override
	public T peek() {
		checkInitialization();
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		else {
			return array[indexOfTopElement];
		}
	}


	@Override
	public boolean isEmpty() {
		return indexOfTopElement < 0 ;
	}

	
	@Override
	public void clear() {
		while(!isEmpty()) {
			array[indexOfTopElement] = null;
			indexOfTopElement--;
		}
	}
	
	
    private void checkInitialization()
    {
        if (!initialized)
             throw new SecurityException("ArrayStack object is not initialized " +
                                        "properly.");
   }
	
	
	
	public boolean isFull() {
		return indexOfTopElement >= array.length - 1;
	}
}
