package dynamic;

public class QuickUnionUF extends UF
{

	private int[] id;
	
	public QuickUnionUF(int n)
	{
		id = new int[n];
		for (int i = 0; i < n; i++)
			id[i] = i;
	}
	
	private int root(int i)
	{
		while(i != id[i])
			i = id[i];
		return i;
		
	}

	public void union(int p, int q)
	{
		int i = root(p);
		int j = root(q);
		id[i] = j;
	}
	
	public boolean connected(int p, int q)
	{
		return root(p) == root(q);
	}
	
	public String getIdsOrder(){
		String resp = ""; 
		for (int i = 0; i < id.length; i++){
			resp += Integer.toString(id[i]) + ' ';
		}
		return resp;
	}
	
}