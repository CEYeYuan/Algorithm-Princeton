/*print all prime less than n*/
class printPrime{
	public static void main(String args[]){
		int n=200;
		printPrimeLessThan(n);
	}

	public static void printPrimeLessThan(int n){
		boolean[] arr=new boolean[n+1];
		for (int i=2;i<=n;i++){
			arr[i]=true;
		}
		for (int j=2;j*j<=n;j++){
		/*for a composite number, if we search from 2-sqrt(n),we still can't 
		find a prime factor, we can say it's not composite. Because if it's composite,
		it turns out that all its prime factor is greater than sqrt(n), so even it only
		has two prime factor, the production of these two will be greater itself.*/
			for (int composite=2*j;composite<=n;composite+=j){
				if (arr[composite])
					arr[composite]=false;
			}
		}

		for (int i=2;i<=n;i++){
			if (arr[i])
				System.out.print(i+" ");

		}
	}
}