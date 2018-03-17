package com.google.javase.day2andday3;

public class GapTowNumbersMax {
/*
*给定一个数组，求如果排序之后，相邻两数的最大差值，
*要求时间复杂度O(N)，
*且要求不能用非基于比较的排 
*/
	 public int gapTowNumbersMax(int []arr) {
		int Max=Integer.MIN_VALUE;
		int Min=Integer.MAX_VALUE;
		int red=0;
		int []max=new int[arr.length+1];
		int []min=new int[arr.length+1];
		boolean []bool=new boolean[arr.length+1];
		for(int i=0;i<arr.length;++i) {
			Max=Max<arr[i]?arr[i]:Max;
			Min=Min>arr[i]?arr[i]:Min;
		}
		for(int i=0;i<arr.length;++i) {
			int d=0;
			d=getBucket(arr[i],arr.length,Max-Min,Min);
			max[d]=(!bool[d])||arr[i]>max[d]?arr[i]:max[d];
			min[d]=(!bool[d])||arr[i]<min[d]?arr[i]:min[d];
			bool[d]=true;
		}
		for(int i=0,j=0;i<arr.length+1;++i) {
			if(bool[i]) {
				red=red<min[i]-max[j]?min[i]-max[j]:red;
				j=i;
			}
		}
		return red;
		
	}

	private int getBucket(int i, int j, int m, int min) {
		return (i-min)*j/m;
		
	}
}
