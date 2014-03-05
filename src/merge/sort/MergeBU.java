package merge.sort;

public class MergeBU {

	private static void merge(Comparable[] a, int lo, int mid, int hi)
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
		int N = a.length;
		aux = new Comparable[N];
		for (int sz = 1; sz < N; sz = sz+sz)
			for(int lo = 0; lo < N-sz; lo += sz+sz)
				merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
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