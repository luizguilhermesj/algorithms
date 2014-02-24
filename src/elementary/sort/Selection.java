package elementary.sort;

import java.util.Arrays;

import main.Helper;
import edu.princeton.cs.introcs.StdOut;

public class Selection {

	public static void sort(Comparable[] a)
	{
		int N = a.length;
		for (int i = 0; i < N; i++){
			int min = i;
			for (int j = i+1; j < N; j++)
				if(less(a[j],a[min]))
					min = j;
			exch(a, i, min);
			Helper.printArray(a, i);
		}
	}
	
	public static boolean less(Comparable v, Comparable w)
	{
		return v.compareTo(w) < 0;
		
	}
	
	public static void exch(Comparable[] a, int i, int j)
	{
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
}
