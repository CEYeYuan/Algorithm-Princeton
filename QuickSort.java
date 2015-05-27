import java.io.*;
public class QuickSort{
	private static int count=0;
	
	public static void main(String[] args){
		BufferedReader rd=null;
		String filename="QuickSort.txt";
		String line=null;
		int i=0;	
			
		int[] input=new int[100000];
		try{
			rd=new BufferedReader(new FileReader(filename));
		
			while (true){
				line=rd.readLine();
					if (line==null) break;
					else{
						input[i]=Integer.parseInt(line);	
				 		i++;
					}
			}
		}
		catch (IOException io){
			System.out.println(io.getMessage());

		}
		//int[] arr={8,3,2,96,1,4,6,7};
		QuickSort(0,9999,input);
	    
	   for (i=5000;i<5026;i++){
	    	System.out.println(count);
	    }
	}
	public static void  QuickSort(int l,int h,int[] input){
		if (h<=l)
			return ;
		if(h-l==1){
			count++;
			if (input[l]<=input[h])  return;
			else swap(l,h,input); 	 return;
		}
		else{
			count+=h-l;
			int pivot=choosepivot(l,h,input);
			int bar=partition(pivot,input,l,h);
			QuickSort(l,bar-1,input);
			QuickSort(bar+1,h,input);
		}	
	}
	public static int choosepivot(int l, int h,int[] input){
		//return input[l];
		/*int pivot=input[h];
		swap(h,l,input);
		return pivot;*/
		int min=input[l];
		int max=input[h];
		int median=input[(l+h)/2];
		if ((min<=median&&median<=max)||(max<median&&median<=min)){
			swap((l+h)/2,l,input);
			return median;
		}
		else if((min<=median&&max<=min)||(min<=max&&median<=min)){
			return min;
		}
		else{ //if ((median<=max&&max<=min)||(min<=max&&max<=median)){
			swap(h,l,input);
			return max;
		}

	}
	public static int partition(int pivot,int[] input,int l,int h){
			int i=l+1;
			int j=l+1;
		while (j<h+1) {
		 	if (input[j]>=pivot) ;
		 	else{
              swap(i,j,input);
              i++;
		 	}
		 	j++;}
		 
		 swap(l,i-1,input);
		 return i-1; 

		}
	
	public static void swap(int i, int j,int[] input){
		int tmp=input[i];
		input[i]=input[j];
		input[j]=tmp;
	}
}