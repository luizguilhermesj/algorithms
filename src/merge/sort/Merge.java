package merge.sort;

import sun.misc.Sort;

public class Merge extends Sor{

	private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi)
	{
		assert isSorted(a, lo, mid);
		assert isSorted(a, mid+1, hi);
		
		int i = lo, j = mid+1;
		for (int k = lo; k <= hi; k++)
		{
			if (i > mid)
				a[k] = aux[j++];
			else if (j > hi)
				a[k] = aux[i++];
			else if (less(aux[j], aux[i]))
				a[k] = aux[j++];
			else
				a[k] = aux[i++];
		}
	}
	
	private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi)
	{
		if (hi <= lo)
			return;
		int mid = lo + (hi - lo) / 2;
		sort (a, aux, lo, mid);
		sort (a, aux, mid+1, hi);
		merge(a, aux, lo, mid, hi);
	}
	
	public static void sort(Comparable[] a)
	{
		Comparable[] aux = new Comparable[a.length];
		sort(a, aux, 0, a.length - 1);
	}

	private static boolean less(Comparable v, Comparable w)
	{
		return v.compareTo(w) < 0;
	}
}
