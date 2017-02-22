package Queue;

public class QueueTest {
	public static void main(String[] args) {
		/*CircularQueue cq= new CircularQueue();
		cq.enqueue(3);
		cq.enqueue(5);
		cq.enqueue(7);
		cq.dequeue();
		cq.print();
		
		SingleLinkedQueue slq = new SingleLinkedQueue();
		slq.enqueue(4);
		slq.enqueue(6);
		slq.enqueue(8);
		slq.dequeue();
*/
		TwoPartCircularLinkedData<Integer> tld = new TwoPartCircularLinkedData<Integer>();
		tld.enqueue(3);
		tld.enqueue(5);
		
		DoubleEndedQueue<Integer> deq = new DoubleEndedQueue<>();
		deq.addToFront(1);
		deq.addToFront(3);
		System.out.println(deq.front.data);
		System.out.println(deq.rear.data);
		deq.addToBack(5);
		System.out.println(deq.front.data);
		System.out.println(deq.rear.data);
		deq.removeFront();
		System.out.println(deq.front.data);
		System.out.println(deq.rear.data);
		deq.removeBack();
		System.out.println(deq.front.data);
		System.out.println(deq.rear.data);
	}
}
