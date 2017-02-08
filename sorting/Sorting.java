package sorting;

	/*
	size=10
	LAB2 2/8
	HW2 2/6
	HW3 2/13
	iterative&recursive
	 */
public class Sorting {
	
	
	public static void main(String args[]){
		int array[]= new int[10];
		array[0]=33;
		array[1]=77;
		array[2]=44;
		array[3]=88;
		array[4]=22;
		array[5]=66;
		array[6]=11;
		array[7]=99;
		array[8]=55;
		array[9]=0;
		
	}
	
	public static void swap(int a, int b,int arr[]){
		int temp;
		temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
	public static void printArr(int arr[]){
		for(int i=0;i<10;i++){
			System.out.println(arr[i]);
		}
	}
	
	public static int findIndexBig(int arr[]){
		int temp=-1;
		for(int i=0;i<10;i++){
			if(arr[i]<temp){
				
			}else{
				temp=i;
			}
		}
		
		return temp;
	}
	
	public static void selSortI(int arr[]){
		for(int i=10;i>0;i--){
			//find biggest
			int index=findIndexBig(arr);
			swap(index,i,arr);
		}
	}
	
	
	public static void selSortR(int arr[]){
		
	}
}
