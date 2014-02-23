package dynamic;


import java.io.FileInputStream;
import java.io.FileNotFoundException;

import main.Helper;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;




public class Tester
{

	public void exec()
	{
		this.testQuickUnionWeighted();
	}
	
	private void testQuickFind(){
		StdOut.println("------- Quick Find");
		Helper.setFile("src//inputs//quick-input.txt");
		
		int N = StdIn.readInt();
		QuickFindUF qf = new QuickFindUF(N);
		while (!StdIn.isEmpty())
		{
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			qf.union(p, q);
			StdOut.println(p + "-" + q + ": " + qf.getIdsOrder());
		}
		
	}
	
	private void testQuickUnion(){
		StdOut.println("------- Quick Union");
		Helper.setFile("src//inputs//quick-union.txt");
		
		int N = StdIn.readInt();
		QuickUnionUF qu = new QuickUnionUF(N);
		while (!StdIn.isEmpty())
		{
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if (!qu.connected(p, q))
			{
				qu.union(p, q);
				StdOut.println(p + "-" + q + ": " + qu.getIdsOrder());
			}
		}
	}
	
	private void testQuickUnionWeighted(){
		StdOut.println("------- Quick Union");
		
		Helper.setFile("src//inputs//quick-union.txt");
		
		int N = StdIn.readInt();
		QuickImprovedUnionUF qu = new QuickImprovedUnionUF(N);
		while (!StdIn.isEmpty())
		{
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if (!qu.connected(p, q))
			{
				qu.union(p, q);
				StdOut.println(p + "-" + q + ": " + qu.getIdsOrder());
			}
		}
	}
}
