package elementary.sort;

import main.Helper;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class Tester {

	public void exec()
	{
		Helper.setFile("src//inputs//numbers-to-sort.txt");
		this.testShellSort();
	}
	public void testSelectionSort(){
		Selection s = new Selection();
		Integer[] list = new Integer[10];
		int i = 0;
		while(!StdIn.isEmpty()){
			list[i] = StdIn.readInt();
			i++;
		}
		s.sort(list);
		StdOut.print("ended: ");
		for (Integer integer : list) {
			StdOut.print(integer.toString()+' ');			
		}
	}
	public void testShellSort(){
		Shell s = new Shell();
		Integer[] list = new Integer[10];
		int i = 0;
		while(!StdIn.isEmpty()){
			list[i] = StdIn.readInt();
			i++;
		}
		s.sort(list);
		StdOut.print("ended: ");
		for (Integer integer : list) {
			StdOut.print(integer.toString()+' ');			
		}
	}
	public void testInsertionSort(){
		Insertion s = new Insertion();
		Integer[] list = new Integer[10];
		int i = 0;
		while(!StdIn.isEmpty()){
			list[i] = StdIn.readInt();
			i++;
		}
		s.sort(list);
		StdOut.print("ended: ");
		for (Integer integer : list) {
			StdOut.print(integer.toString()+' ');			
		}
	}
}
