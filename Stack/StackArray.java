package Stack;

import java.util.EmptyStackException;

public class StackArray<T> implements StackInterface<T> {

	T[] stack;
	int numberOfEntries;

	public StackArray() {
		stack= (T[])new Object[10];
		numberOfEntries = 0;
	}

	@Override
	public void push(T newEntry) {
		// TODO Auto-generated method stub
		if (numberOfEntries == stack.length) {
			System.err.println("Stack is full.");
		} else {
			this.stack[this.numberOfEntries] = newEntry;
			numberOfEntries++;
		}
	}

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		if (!isEmpty()) {
			numberOfEntries--;
			return stack[numberOfEntries];
		} else {
			System.out.println("Stack is Empty.");
			throw new EmptyStackException();
		}

	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		if (!isEmpty()) {
			return stack[numberOfEntries-1];
		} else {
			System.out.println("Stack is Empty.");
			throw new EmptyStackException();
		}

	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(numberOfEntries==0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		this.numberOfEntries=0;
	}
	public void print(){
		System.out.println("Print Stack");
		for(int i = 0;i<numberOfEntries;i++){
		System.out.println(this.stack[i]);
		}
	}
}
