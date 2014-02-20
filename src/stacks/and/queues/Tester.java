package stacks.and.queues;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;
import utils.Helper;

public class Tester {

	public void exec()
	{
		Helper.setFile("src//inputs//tobe.txt");
		this.testFixedCapacityGenericStack();
	}
	
	public void testLinkedQueue()
	{
		LinkedQueueOfStrings queue = new LinkedQueueOfStrings();
		while(!StdIn.isEmpty())
		{
			String s = StdIn.readString();
			if(s.equals("-"))
				StdOut.print(queue.dequeue()+" ");
			else
				queue.enqueue(s);
		}
	}
	
	public void testGenericStack()
	{
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		StdOut.println(stack.pop());
		StdOut.println(stack.pop());
		StdOut.println(stack.pop());
	}
	
	public void testFixedCapacityGenericStack()
	{
		FixedCapacityStack<Integer> stack = new FixedCapacityStack<Integer>(10);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		stack.push(7);
		stack.push(8);
		stack.push(9);
		stack.push(10);
		StdOut.println(stack.pop());
		StdOut.println(stack.pop());
		StdOut.println(stack.pop());
	}
}
