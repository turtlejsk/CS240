package Stack;

public class StackTest {
	public static void main(String[] args) {
		/*
		StackArray stackA= new StackArray();
		stackA.push(3);
		stackA.push(2);
		stackA.push(1);
		stackA.print();
		System.out.println();
		System.out.println(stackA.peek());
		System.out.println();
		stackA.pop();
		stackA.print();
		System.out.println();
		stackA.pop();
		stackA.print();
		stackA.pop();
		stackA.pop();
		
		StackVector sV = new StackVector();
		sV.push(1);
		sV.push(2);
		sV.print();
		sV.pop();
		System.out.println();
		System.out.println(sV.peek());
		System.out.println();
		sV.print();
		sV.clear();
		sV.print();
		*/
		StackLinked sL = new StackLinked();
		sL.push(3);
		sL.push(5);
		sL.push(7);
		sL.push(9);
		System.out.println(sL.peek());
		sL.pop();
		sL.print();
	}
}
