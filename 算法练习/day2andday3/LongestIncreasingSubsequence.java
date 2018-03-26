package com.google.javase.day2andday3;
//最长递增子序列
public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int[]array= {2,1,5,3,6,4,8,9,7};
		LIS1(array);
		LIs2(array);
	}
//O(nlogn)  二分查找法
	public static void LIs2(int[] array) {
		// TODO Auto-generated method stub
		int longest[]=new int [array.length];
		int pos=1;
		longest[0]=array[0];
		for(int i=1;i<array.length;++i) {
			int team;
			team=dichotomy(longest,pos,array[i]);
			if(team==-1) {
				continue;
			}
			else {
				longest[team]=array[i];
			}
			if(team>pos-1) {
				pos++;
			}
		}
		System.out.println(pos);
	}
	private static int dichotomy(int []longest,int len,int key) {
		int left=0,right=len-1;
		while(left<=right) {
			if(longest[right]<key) 
				return right+1;
			if(longest[left]>key)
				return left;
			int mid=(right+left)/2;
			if(longest[mid]==key) return -1;
			if(longest[mid]>key)
				right=mid-1;
			else
				left=mid+1;
			
		}
		return -1;
	}
//O(n)^2
	public static void LIS1(int[] array) {
		// TODO Auto-generated method stub
		int max=0;
		int []longest=new int[array.length];
		for(int i=0;i<longest.length;++i) {
			longest[i]=1;
		}
		for(int i=1;i<array.length;++i) {
			for(int j=0;j<i;j++) {
				if(array[j]<array[i]&&longest[j]+1>longest[i]) {
					longest[i]=longest[j]+1;
				}
				if(max<longest[i]) {
					max=longest[i];
				}
			}
		}
		System.out.println(max);
	}
}
