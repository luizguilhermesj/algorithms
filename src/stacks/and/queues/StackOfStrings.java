package stacks.and.queues;

public class StackOfStrings {

	private Node first = null;
	
	private class Node{
		String item;
		Node next;
	}
	
	public void push(String item){
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
	}
	public String pop(){
		String item = first.item;
		first = first.next;
		return item;
	}
	public boolean isEmpty(){
		return first == null;
	}
	public int size(){
		return 0;
	}
	
}
