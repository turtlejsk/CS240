package Stack;

import java.util.EmptyStackException;
import java.util.Vector;

public class StackVector<T> implements StackInterface<T> {

	Vector<T> stack;
	int numberOfEntries;

	public StackVector() {
		stack = new Vector<T>();
		numberOfEntries = 0;
	}

	@Override
	public void push(T newEntry) {
		// TODO Auto-generated method stub
		stack.add(newEntry);
		numberOfEntries++;
	}

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		if (!isEmpty()) {
			numberOfEntries--;
			T temp = stack.get(numberOfEntries - 1);
			stack.remove(numberOfEntries);
			return temp;
		} else {
			System.out.println("Stack is Empty");
			throw new EmptyStackException();
		}
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		if (!isEmpty()) {
			return stack.get(numberOfEntries - 1);
		} else {
			System.out.println("Stack is Empty");
			throw new EmptyStackException();
		}
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (numberOfEntries == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		stack.clear();
	}
	
	public void print(){
		for(int i =0; i<numberOfEntries;i++){
			System.out.println(stack.get(i));
		}
	}

}
