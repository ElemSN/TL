package com.google.javase.day3;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args){  
	       /* int n;
	                     Scanner sca=new Scanner(System.in);
	        n=sca.nextInt();
	        String []st=new String[n];  
	        for(int i=0;i<n;i++)
	        	st[i]=sca.next();
	        for(int k=0;k<n;k++) {
	        	char []s=st[k].toCharArray();
	        	int i;
	        	boolean bool=false;
		        for( i=0;i<s.length-1;i++) {
		        	for(int j=i+i;j<s.length;j++) {
		        		char[]c=new String(st[k]).toCharArray();
		        		if(isComplete(c)) {
		        			bool=true;
		        			break;
		        		}
		        		char z=c[i];
		        		c[i]=c[j];
		        		c[j]=z;
		        		if(isComplete(c)) {
		        			bool=true;
		        			break;
		        		}
		        	}
		        	if(bool) {
	        			break;
	        		}
		        }
		        if(i!=s.length-1) {
		        	System.out.println("Yes");
		        }
		        else {
		        	System.out.println("No");
		        }
			
	        }*/
		System.out.println(-10%-3);
	    }

	public static boolean isComplete(char[] s) {
		Stack<Character> left = new Stack<Character>();
		int i=0;
		while (i<s.length) {
			if (s[i]=='(') {
				left.push(s[i]);
			} else if (s[i]==')') {
				
				if (left.isEmpty())
					return false;
				char c=left.pop();
				if (s[i]==')') {
					if (c!='(')
						return false;
				}
			}
			i++;
		}
		return left.isEmpty();
	}
}
