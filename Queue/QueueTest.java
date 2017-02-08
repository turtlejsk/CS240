package Queue;

public class QueueTest {
	public static void main(String[] args) {
		/*CircularQueue cq= new CircularQueue();
		cq.enqueue(3);
		cq.enqueue(5);
		cq.enqueue(7);
		cq.dequeue();
		cq.print();
		*/
		SingleLinkedQueue slq = new SingleLinkedQueue();
		slq.enqueue(4);
		slq.enqueue(6);
		slq.enqueue(8);
		slq.dequeue();
		slq.print();
		
	}
}
