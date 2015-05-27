public class PercolationStats {
	private double[] arr;
	private int testtimes;
	private double miu;
	private double sigma;
   public PercolationStats(int N, int T)  {
   	 if (N <1 || T < 1)
   	 	throw new IllegalArgumentException("args must greater than 0!");
   	 else{
   	 	arr=new double[T];
   	 	testtimes=T;
   	 	for(int p=0;p<T;p++){
   	 		Percolation test=new Percolation(N);
   	 		int times=0;
   	 		int i=StdRandom.uniform(1,N+1);
   	 		int j=StdRandom.uniform(1,N+1);
   	 		while(test.percolates()==false){
   	 			while(test.isOpen(i,j)==true){
   	 				i=StdRandom.uniform(1,N+1);
   	 			 	j=StdRandom.uniform(1,N+1);
   	 			}
   	 			test.open(i,j);
   	 			times++;
   	 	}
   	 	arr[p]=times*1.0/(N*N);
   	 	}
   	 }
   }   // perform T independent experiments on an N-by-N grid
   public double mean() {
   	double total=0;
   	for(int i=0;i<testtimes;i++){
   		total+=arr[i];

   	}
   	miu=total/testtimes;
   	return miu;


   }                     // sample mean of percolation threshold
   public double stddev()  {
   		double total=0;
   		for(int i=0;i<testtimes;i++){
   		total+=(arr[i]-mean())*(arr[i]-mean());
   	}
   	sigma=total/(testtimes-1);
   	return sigma;
   }                  // sample standard deviation of percolation threshold
   public double confidenceLo()   {
   	return mean()-1.96*stddev()/Math.sqrt(testtimes);
   }           // low  endpoint of 95% confidence interval
   public double confidenceHi()  {
   	return mean()+1.96*stddev()/Math.sqrt(testtimes);
   }            // high endpoint of 95% confidence interval

   public static void main(String[] args)  {
   	PercolationStats t=new PercolationStats(100,50);
   	System.out.println(t.mean());
   	System.out.println(t.stddev());


   }  // test client (described below)
}
