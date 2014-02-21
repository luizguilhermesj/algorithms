package week2.stack;

import main.Helper;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class Tester {
	public void exec(){
		ResizingArray();
	}
	public void basicStack(){
		StackOfStrings stack = new StackOfStrings();
		Helper.setFile("src//week2//stack//tobe.txt");
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
		Helper.setFile("src//week2//stack//tobe.txt");
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
		Helper.setFile("src//week2//stack//tobe.txt");
		while(!StdIn.isEmpty()){
			String s = StdIn.readString();
			if(s.equals("-"))
				StdOut.print(stack.pop()+" ");
			else
				stack.push(s);
		}
	}
}
