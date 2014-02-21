package stacks.and.queues;

import main.Helper;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class Tester {

	public void exec()
	{
		Helper.setFile("src//inputs//tobe.txt");
		this.testFixedCapacityGenericStack();
	}
	public void basicStack(){
		StackOfStrings stack = new StackOfStrings();
		Helper.setFile("src//inputs//tobe.txt");
		while(!StdIn.isEmpty()){
			String s = StdIn.readString();
			if(s.equals("-"))
				StdOut.print(stack.pop()+" ");
			else
				stack.push(s);
		}
	}
	public void fixedArray(){
		FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(10);
		Helper.setFile("src//inputs//tobe.txt");
		while(!StdIn.isEmpty()){
			String s = StdIn.readString();
			if(s.equals("-"))
				StdOut.print(stack.pop()+" ");
			else
				stack.push(s);
		}
	}
	public void ResizingArray(){
		ResizingArrayStackOfStrings stack = new ResizingArrayStackOfStrings();
		Helper.setFile("src//inputs//tobe.txt");
		while(!StdIn.isEmpty()){
			String s = StdIn.readString();
			if(s.equals("-"))
				StdOut.print(stack.pop()+" ");
			else
				stack.push(s);
		}
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
