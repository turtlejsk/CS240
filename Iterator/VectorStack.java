package Iterator;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Vector;
import Stack.StackInterface;


public class VectorStack<T> implements StackInterface<T>, Iterable<T> {

	private final Vector<T> vector;
	private boolean initialized = false;
	
	/**
	 * An iterator that can do actions
	 */
	private class VectorStackIterator implements IteratorInterface<T> {
		
		private int nextPosition;
		private int previousPosition;
		@SuppressWarnings("unused")
		private boolean wasNextCalled;
		
		private VectorStackIterator() {
			nextPosition = vector.size() - 1;
			previousPosition = vector.size();
			wasNextCalled = false;
		}
		

		public boolean hasNext() {
			return nextPosition > -1;
			
		}
		

		public T next() {
			if(hasNext()) {
				T temp = vector.elementAt(nextPosition);
				nextPosition--;
				previousPosition--;
				wasNextCalled = true;
				return temp;
			}
			else {
				throw new NoSuchElementException("The iterator has already reached the end");
			}
			
		}
		

		public void remove() {
			throw new UnsupportedOperationException();
			
		}
		

		public boolean hasPrevious() {
			return previousPosition < vector.size();
		}
		
		

		public T previous() {
			if(hasPrevious()) {
				T temp = vector.elementAt(previousPosition);
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
	
	
	public VectorStack(int capacity) {
		vector = new Vector<>(capacity);
		initialized = true;
	}
	
	
	public VectorStack() {
		this(10);
	}
	
	

	public void push(T newEntry) {
		checkInitialization();
		vector.addElement(newEntry);
	}

	

	public T pop() {
		if (isEmpty())
			throw new EmptyStackException();
		else
			return vector.remove(vector.size() - 1);		
	}
	

	
	public T peek() {
		if (isEmpty())
			throw new EmptyStackException();
		else
			return vector.get(vector.size() - 1);
		
	}

	
	public boolean isEmpty() {
		return vector.isEmpty();
	}
	

	public void clear() {
		vector.clear();
	} // end StackInterface

	

    private void checkInitialization()
    {
        if (!initialized)
             throw new SecurityException("VectorStack object is not initialized " +
                                        "properly.");
   }
    
   
    public int currentSize() {
    	return vector.size();
    }

	@Override
	public Iterator<T> iterator() {
		return (Iterator<T>) new VectorStackIterator();
	}
	
}
