package com.google.javase.day1;
/*
 * 可以用荷兰国旗问题来改进快速
 */
public class ImproveQuickSort {

	public static void main(String[] args) {
		
		int arr[]={1,3,4,2,5,4,6};
		quickSort(arr,0,arr.length-1);
		for(int i=0;i<arr.length;++i) {
			System.out.println(arr[i]);
		}
	}

	public static void quickSort(int[] arr, int left, int right) {

		if(right>left) {
			int []p=sort(arr,left,right);
			quickSort(arr,left,p[0]);
			quickSort(arr,p[1],right);
		}	
	}

	private static int[] sort(int[] arr, int left, int right) {
		int less=left,more=right-1;
		int i=left;
		while(more>=i) {
			if(arr[i]>arr[right]) {
				swap(arr,i,more--);
			}
			else {
				if(arr[i]<arr[right]){
					swap(arr,i,less++);		
				}
				i++;
			}
		}
		swap(arr,right,more+1);
		return new int[]{less-1,more+1};
	}
	private static void swap(int[] arr, int i, int j) {
		int zjz;
		zjz=arr[j];
		arr[j]=arr[i];
		arr[i]=zjz;
	}
}
