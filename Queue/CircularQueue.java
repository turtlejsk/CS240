package Queue;

import java.util.EmptyStackException;

public class CircularQueue implements QueueInterface<Integer> {
	int array[];
	int front;
	int back;
	int numberOfEntry;

	public CircularQueue() {
		array = new int[10];
		front = 0;
		back = 0;
		numberOfEntry = 0;
	}

	@Override
	public void enqueue(Integer newEntry) {
		// TODO Auto-generated method stub
		if((back+1)%10==front&&numberOfEntry!=0){
			System.err.println("Queue is full");
		}
		array[back] = newEntry;
		back++;
		back %= 10;
		numberOfEntry++;
	}

	@Override
	public Integer dequeue() {
		// TODO Auto-generated method stub
		if (!isEmpty()) {
			front++;
			front%=10;
			numberOfEntry--;
			return array[front - 1];
		} else {
			System.out.println("Stack is Empty.");
			throw new EmptyStackException();
		}
	}

	@Override
	public Integer getFront() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			return array[front];
		} else {
			System.out.println("Stack is Empty.");
			throw new EmptyStackException();
		}
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (numberOfEntry != 0) {
			return false;
		} else {
			return true;
		}

	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		array = new int[10];
	}
	public void print(){
		for(int i =front; i<back;i++){
			System.out.println(array[i]);
		}
	}
}
