public class Percolation {

 private WeightedQuickUnionUF percolate;// call weightedquick union class
 private boolean[] open;
 private int N;
   public Percolation(int N) throws IllegalArgumentException {
        if (N<=0){
         throw new IllegalArgumentException();
        }

        else{
         open=new boolean[N*N+2];//may 2D array to 1D array, also add two addtional virtual node
         this.N=N;//0 and N*N+1 are the top and bottom "virtual node"
         percolate=new WeightedQuickUnionUF(N*N+2);
         for (int i=1;i<N+1;i++){
          percolate.union(0,i);
         }
        /* for(int i=N*N-N+1;i<N*N+1;i++){// connect the virtual node to it's corresponding row(i.e 1st and last)
          percolate.union(N*N+1,i);
         }*/
      for (int i=0;i<N*N+2;i++){
      open[i]=false;
      }
      

        }}
     
    
                  // create N-by-N grid, with all sites blocked
   public void open(int i, int j) throws IndexOutOfBoundsException  {
   	if(i<1||j<1||i>N||j>N)
   		throw new IndexOutOfBoundsException();
   	else{
   		open[(i-1)*N+j]=true;
     	if (1<i&&i<N&&1<j&&j<N){
     		if(isOpen(i-1,j))
        		percolate.union((i-1)*N+j,(i-2)*N+j);
   	  		if(isOpen(i+1,j))
   	  			percolate.union((i-1)*N+j,i*N+j);
     		if(isOpen(i,j-1))
        		percolate.union((i-1)*N+j,(i-1)*N+j-1);
       		if(isOpen(i,j+1))
        		percolate.union((i-1)*N+j,(i-1)*N+j+1);
     }
     else{
      if(i==1){
       if (j==1){
        if(isOpen(i,j+1))
        percolate.union((i-1)*N+j,(i-1)*N+j+1);
        if(isOpen(i+1,j))
        percolate.union((i-1)*N+j,(i)*N+j);
       }
       else if (j==N){
        if(isOpen(i,j-1))
        percolate.union((i-1)*N+j,(i-1)*N+j-1);
        if(isOpen(i+1,j))
        percolate.union((i-1)*N+j,(i)*N+j);
       }
       else{
        if(isOpen(i,j-1))
        percolate.union((i-1)*N+j,(i-1)*N+j-1);
        if(isOpen(i,j+1))
        percolate.union((i-1)*N+j,(i-1)*N+j+1);
        if(isOpen(i+1,j))
        percolate.union((i-1)*N+j,(i)*N+j);

       }
      }
      else if (i==N){
       if (j==1){
        if(isOpen(i,j+1))
        percolate.union((i-1)*N+j,(i-1)*N+j+1);
        if(isOpen(i-1,j))
        percolate.union((i-1)*N+j,(i-2)*N+j);
       }
       else if (j==N){
        if(isOpen(i,j-1))
        percolate.union((i-1)*N+j,(i-1)*N+j-1);
        if(isOpen(i-1,j))
        percolate.union((i-1)*N+j,(i-2)*N+j);
       }
       else{
        if(isOpen(i,j-1))
        percolate.union((i-1)*N+j,(i-1)*N+j-1);
        if(isOpen(i,j+1))
        percolate.union((i-1)*N+j,(i-1)*N+j+1);
        if(isOpen(i-1,j))
        percolate.union((i-1)*N+j,(i-2)*N+j);

       }

      }
      else{
       if(j==1){
        if(isOpen(i,j+1))
        percolate.union((i-1)*N+j,(i-1)*N+j+1);
        if(isOpen(i+1,j))
        percolate.union((i-1)*N+j,(i)*N+j);
        if(isOpen(i-1,j))
        percolate.union((i-1)*N+j,(i-2)*N+j);

       }
       else{//j==N
        if(isOpen(i,j-1))
        percolate.union((i-1)*N+j,(i-1)*N+j-1);
        if(isOpen(i+1,j))
        percolate.union((i-1)*N+j,(i)*N+j);
        if(isOpen(i-1,j))
        percolate.union((i-1)*N+j,(i-2)*N+j);

       }
      }
     }


   	}
   
    }       // open site (row i, column j) if it is not open already
   public boolean isOpen(int i, int j) throws IndexOutOfBoundsException{
   	if(i<1||j<1||i>N||j>N)
   		throw new IndexOutOfBoundsException();
   	else{
   		boolean ret=open[(i-1)*N+j];
   		if(ret&&i==N&&percolate.connected(0,(i-1)*N+j)){
   			percolate.union((i-1)*N+j,N*N+1);
   		}
    	return ret;
   }  }   // is site (row i, column j) open?
   public boolean isFull(int i, int j) throws IndexOutOfBoundsException {
   		if(i<1||j<1||i>N||j>N)
   			throw new IndexOutOfBoundsException();
    	return open[(i-1)*N+j]&&percolate.connected(0,(i-1)*N+j);
   	}
   	    
    
     // is site (row i, column j) full?
   public boolean percolates()      {
    return percolate.connected(0,N*N+1);
   }       // does the system percolate?

   public static void main(String[] args)  {
   } // test client (optional)
}
