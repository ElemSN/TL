package com.google.javase.day1;
/*
 *  逆序对问题
	在一个数组中，左边的数如果比右边的数大，则折两个数构成一个逆序对，请打印所有逆序
	对
 */
public class InversionPair {

	public static void main(String[] args) {
		int a[]={1,3,4,2,5};
		findAllInversion(a,0,a.length-1);
	}

	public static void findAllInversion(int[] a, int left, int right) {
		int mid;
		if(left==right) {
			return;
		}
		mid=(right+left)>>1;
		findAllInversion(a,left,mid);
		findAllInversion(a,mid+1,right);
		findInversion(a,left,mid,right);
	}
	public static void findInversion(int[] a, int left, int mid, int right) {
		int help[]=new int[right-left+1];
		int k=0,i=left,j=mid+1;		
		while(i<mid+1||j<right+1){
			if(i==mid+1||(j<right+1&&a[i]>a[j])) {
				if(i!=mid+1){
					printfInversion(a,i,mid,j);
				}
				help[k++]=a[j++];
			}
			else {
				help[k++]=a[i++];
			}
		}
		for(i=0;i<help.length;++i) {
			a[i+left]=help[i];
		}	
	}
	public static void printfInversion(int []a,int left,int mid,int k) {
		for(;left<mid+1;++left) {
			System.out.println(a[left]+"  "+a[k]);
		}
	}
}
