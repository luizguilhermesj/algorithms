package dynamic;
public class QuickImprovedUnionUF {

	private int[] id;
	private int[] sz;
	
	public QuickImprovedUnionUF(int n)
	{
		id = new int[n];
		sz = new int[n];
		for (int i = 0; i < n; i++){
			id[i] = i;
			sz[i] = 1;
		}
	}
	
	private int root(int i)
	{
		while(i != id[i]){
			i = id[i];
		}
		return i;
		
	}

	public void union(int p, int q)
	{
		int i = root(p);
		int j = root(q);
		
		if (i == j) return;
		if (sz[i] < sz[j]){
			id[i] = j;
			sz[j] += sz[i];
		}else{
			id[j] = i;
			sz[i] += sz[j];
		}
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
