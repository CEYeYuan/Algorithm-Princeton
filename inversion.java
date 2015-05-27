import java.io.*;
public class inversion{
	static long inversion=0;

	public static void main(String[] args){
		BufferedReader rd=null;
		String filename="IntegerArray.txt";
		String line=null;
		int i=0;		
		int[] input=new int[100000];
		try{
			rd=new BufferedReader(new FileReader(filename));
		
			while (i<100000){
					/*    if (rd.readLine()!=null){
					    	line=rd.readLine();
					    	input[i]=Integer.parseInt(line);	

					    }
				    i++;*/

				    //where is the bug?  you get two lines in the text, but you only parse one of them. So half
				    //of the text is not stored in the array, which cause half of the array to be its initial value 0 
			
					line=rd.readLine();
					if (line!=null)
					input[i]=Integer.parseInt(line);	
				 	i++;

			}
		}
		catch (IOException io){
			System.out.println(io.getMessage());

		}

		//int a[]={ 4, 80, 70, 23, 9, 60, 68, 27, 66, 78, 12, 40, 52, 53, 44, 8, 49, 28, 18, 46, 21, 39, 51, 7, 87, 99, 69, 62, 84, 6, 79, 67, 14, 98, 83, 0, 96, 5, 82, 10, 26, 48, 3, 2, 15, 92, 11, 55, 63, 97, 43, 45, 81, 42, 95, 20, 25, 74, 24, 72, 91, 35, 86, 19, 75, 58, 71, 47, 76, 59, 64, 93, 17, 50, 56, 94, 90, 89, 32, 37, 34, 65, 1, 73, 41, 36, 57, 77, 30, 22, 13, 29, 38, 16, 88, 61, 31, 85, 33, 54 };
		int output[]=mergesort(input);
		System.out.println(inversion);
	    
	   for (i=0;i<10;i++){
	    	System.out.println(output[i]);
	    }
	}
	public static int[] mergesort(int[] input){
		if (input.length==0 || input.length==1){
			return input;
		}
		else{
			int[] left=new int[input.length/2];
		    for(int i=0;i<left.length;i++){
				left[i]=input[i];
				}
			int[] right=new int[input.length-input.length/2];
			for(int i=0;i<right.length;i++){
				right[i]=input[left.length+i];
				}

		return merge(mergesort(left),mergesort(right));

		}
		
		
	}
	public static int[] merge(int[] left,int[] right){
		int[] merge=new int[left.length+right.length];
		int i=0;
		int j=0;
		int k=0;
		if (left.length==0){
			return right;
		}
		
		while(true){
				if(i<left.length&&j<right.length){

				if(left[i]<=right[j]){
				merge[k]=left[i];
				i++;
				k++;
			    }
			    else{
			    merge[k]=right[j];
				j++;
				k++;
				inversion+=left.length-i;

			    }

				}
				else{
					break;
				}
			

			}
			
		
			while(true){
				if(i==left.length&&j==right.length) return merge;
			    else if(i==left.length){
			    	merge[k]=right[j];
			    	j++;
			    	k++;
			    } 
			    else if(j==right.length){
			    	merge[k]=left[i];

			    	i++;
			    	k++;

			    }

			}
			
		


	}
}