package com.google.javase.day1and2work;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SysConvert {
/*
 * 给定一个十进制数M，以及需要转换的进制数N。将十进制数M转化为N进制数 
	输入描述:
	输入为一行，M(32位整数)、N(2 ≤ N ≤ 16)，以空格隔开。
	为每个测试实例输出转换后的数，每个输出占一行。
	如果N大于9，则对应的数字规则参考16进制（比如，10用A表示，等等）
 */
	private static String []a= {"0", "1", "2", "3", "4", "5", "6", "7", 
						 "8", "9", "A", "B", "C", "D", "E", "F"};
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        String[] str = br.readLine().trim().split(" ");
        int m = Integer.parseInt(str[0]);
        int n = Integer.parseInt(str[1]);
        System.out.println(sysConvert(m,n));
	}
	public static String sysConvert(int m,int n) {
		  StringBuilder s = new StringBuilder();
		  if(m==0) {
			  return "0";
		  }
		  boolean f=m>0;
		  if(f) {
			 m=-m;
		  }
		while(m!=0) {
			s.insert(0,a[-(m%n)]);
			m/=n;
		}
		if(!f) {
			s.insert(0, "-");
		}
		return s.toString();
	}

}
