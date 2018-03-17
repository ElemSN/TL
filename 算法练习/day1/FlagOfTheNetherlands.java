package com.google.javase.day1;
/*
 * 问题二（荷兰国旗问题）
	给定一个数组arr，和一个数num，请把小于num的数放在数组的
	左边，等于num的数放在数组的中间，大于num的数放在数组的
	右边。
	要求额外空间复杂度O(1)，时间复杂度O(N)
 */
public class FlagOfTheNetherlands {

	public static void main(String[] args) {
		int []arr={1,3,4,2,5,4,6};
		int num=4;
		flagOfTheNetherlands(arr,num);
		for(int i=0;i<arr.length;++i) {
			System.out.println(arr[i]);
		}
	}

	public static void flagOfTheNetherlands(int[] arr, int num) {
		for(int less=0,more=arr.length-1,i=0;more>=i;) {
			if(arr[i]>num) {
				swap(arr,i,more--);
				
			}
			else {
				if(arr[i]<num) {
					swap(arr,i,less++);
					
				}
				i++;
			}
		}
	}
	private static void swap(int[] arr, int i, int j) {
		int zjz;
		zjz=arr[j];
		arr[j]=arr[i];
		arr[i]=zjz;
	}
}