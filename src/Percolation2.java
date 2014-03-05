
public class Percolation2 {
	private int[][] sites;
	private int[] base ;
    private int[] sz;
	private int N;
	private int count;
	
   public Percolation2(int N)           // create N-by-N grid, with all sites blocked
   {
	   this.N = N;
	   sites = new int[N][N];
	   base = new int[N*N+2];
	   sz = new int[N*N+2];
	   int index = 1;
	   
	   for(int i = 0 ; i < N; i++){
		   for (int j = 0; j < N; j++){
			   base[index] = -1;
			   sites[i][j] = index;
			   index++;
		   }
	   }
   }
   public void open(int i, int j)         // open site (row i, column j) if it is not already
   {
	   if(!isOpen(i,j)){
		   base[getSiteIndex(i,j)] = getSiteIndex(i,j);
		   unionAdjacentsIfIsOpen(i,j);
		   if(i == 1)
			   union(0,getSiteIndex(i,j));
		   if(i == N)
			   union(N*N+1,getSiteIndex(i,j));
	   }
   }
   public boolean isOpen(int i, int j)    // is site (row i, column j) open?
   {
	   int index = getSiteIndex(i,j);
	   return base[index] != (int)-1;
	   
   }
   public boolean isFull(int i, int j)    // is site (row i, column j) full?
   {
	   return connected(0,getSiteIndex(i,j));
	   
   }
   public boolean percolates()            // does the system percolate?
   {
	   return connected(0, N*N+1);
   }
   
   private void unionAdjacentsIfIsOpen(int i, int j)
   {
	   if(i > 1 && isOpen(i-1,j))
		   union(getSiteIndex(i, j), getSiteIndex(i-1,j));
	   if(i < N && isOpen(i+1,j))
		   union(getSiteIndex(i, j), getSiteIndex(i+1,j));
	   if(j > 1 && isOpen(i,j-1))
		   union(getSiteIndex(i, j), getSiteIndex(i,j-1));
	   if(j < N && isOpen(i,j+1))
		   union(getSiteIndex(i, j), getSiteIndex(i,j+1));
   }
   
   private int getSiteIndex(int i, int j)
   {
	   checkMatrixIndex(i);
	   checkMatrixIndex(j);
	   return sites[i-1][j-1];
   }
   
   private void checkMatrixIndex(int i){
	   if(i <= 0 || i > N){
		   throw new IndexOutOfBoundsException();
	   }
   }
   
   private int count() {
       return count;
   }

   private boolean connected(int p, int q) {
       return find(p) == find(q);
   }
   
   private int find(int p) {
       while (p != base[p])
           p = base[p];
       return p;
   }
   private void union(int p, int q) {
       int rootP = find(p);
       int rootQ = find(q);
       if (rootP == rootQ) return;

       // make smaller root point to larger one
       if   (sz[rootP] < sz[rootQ]) { base[rootP] = rootQ; sz[rootQ] += sz[rootP]; }
       else                         { base[rootQ] = rootP; sz[rootP] += sz[rootQ]; }
       count--;
   }

}