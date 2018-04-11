package com.google.javase.day3;

public class RotateMatrix {
/*
 * 转圈打印矩阵
 * 【题目】 给定一个整型矩阵matrix，请按照转圈的方式打印它。
 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 1，2，3，4，8，12，16，15，14，13，9，5，6，7，11， 10
 */
	
	public static void main(String[] args) {
		int n=4,m=5;
		int num[][]=new int[n][m];
		int cnt=1;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				num[i][j]=cnt++;
			}
		}
		matrix(num);
	}

	private static void matrix(int[][] num) {
		int tr=0,tc=0,dr=num.length-1,dc=num[0].length-1;	
		while(tr<=dr) {
			printEdge(num, tr++,tc++, dr--, dc--);
		}
		
	}
	private static void printEdge(int[][] num, int tr, int tc, int dr, int dc) {
		if(tr==dr) {
			for(int i=tc;i<=dc;++i) {
				System.out.print(num[tr][i]+" ");
			}
		}
		else if(tc==dc) {
			for(int i=tr;i<dr;++i) {
				System.out.print(num[i][tc]+" ");
			}
		}
		else {
			int curR=tr;
			int curC=tc;
			while(curC<dc) {
				System.out.print(num[tr][curC]+" ");
				curC++;
			}
			while(curR<dr) {
				System.out.print(num[curR][dc]+" ");
				curR++;
			}
			while(curC>tc) {
				System.out.print(num[dr][curC]+" ");
				curC--;
			}
			while(curR>tr) {
				System.out.print(num[curR][tc]+" ");
				curR--;
			}
		}
	
	}


}
