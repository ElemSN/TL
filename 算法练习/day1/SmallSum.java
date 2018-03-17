package com.google.javase.day1;
/*
 * 小和问题
	在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。求一个数组
	的小和。
	例子：
	[1,3,4,2,5]
	1左边比1小的数，没有；
	3左边比3小的数，1；
	4左边比4小的数，1、3；
	2左边比2小的数，1；
	5左边比5小的数，1、3、4、2；
	所以小和为1+1+3+1+1+3+4+2=16
 */
public class SmallSum {

	public static void main(String[] args) {
		int sum;
		int a[]= {1,3,4,2,5};
		sum=smallSum(a,0,a.length-1);
		System.out.println(sum);

	}
/*
 * 函数作用：求小和
 * 函数参数：数组a left左边界right右边
 * 返回值：小和
 */
	public static int smallSum(int []a,int left,int right) {
		if(left==right) {
			return 0;
		}
		int mid;
		mid=(left+right)>>1;
		return smallSum(a,left,mid)+smallSum(a,mid+1,right)+mergeSum(a,left,mid,right);	
	}
/*
 * 函数作用：求将两个模块合并后的小和并进行排序
 * 函数参数：数组a left左边界right右边mid中间的数
 * 返回值：合并后的和值
 */
	public static int mergeSum(int[] a, int left, int mid, int right) {
		int help[]=new int[right-left+1];
		int sum=0,k=0;
		//参数作用：i左边的数组小标j右边数组下标
		int i=left,j=mid+1;
		while(i<mid+1||j<right+1) {
			if(j==right+1||(i<mid+1&&a[i]<a[j])) {
				//右边数组没有跑完
				if(j!=right+1) {
					sum+=(right+1-j)*a[i];
				}
				help[k++]=a[i++];
			}
			else {
				help[k++]=a[j++];
			}
		}
		for(i=0;i<help.length;++i) {
			a[i+left]=help[i];
		}
		return sum;
	}

}
