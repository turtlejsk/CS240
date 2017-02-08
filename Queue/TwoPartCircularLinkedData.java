package Queue;

public class TwoPartCircularLinkedData<T> implements QueueInterface<T> {
	

	public TwoPartCircularLinkedData() {
		// TODO Auto-generated constructor stub
		
	}
	
	@Override
	public void enqueue(T newEntry) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T dequeue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getFront() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	
	class Node{
		T data;
		Node next;
		
		public Node(){
			
		}
		public Node(T data){
			this.data = data;
		}
	}

}
