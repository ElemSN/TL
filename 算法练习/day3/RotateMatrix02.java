package com.google.javase.day3;
/*
 * 旋转正方形矩阵
 *【题目】 给定一个整型正方形矩阵matrix，请把该矩阵调整成顺时针旋转90度的样子。
 *【要求】 额外空间复杂度为O(1)。
 */
public class RotateMatrix02 {

	public static void main(String[] args) {
		int n=4,cnt=1;
		int [][]matrix=new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				matrix[i][j]=cnt++;
			}
		}
		printMatrix(matrix);
		System.out.println("=======================");
		rotate(matrix);
		printMatrix(matrix);
	}

	private static void rotate(int[][] matrix) {
		int tr=0,tc=0,dr=matrix.length-1,dc=matrix[matrix.length-1].length-1;
		while(tr<dr) {
			rotateEdge(matrix,tr++,tc++,dr--,dc--);
		}
	}
	private static void rotateEdge(int matrix[][],int tr, int tc, int dr, int dc) {
		int tmp;
		int times=dc-tc;
		for(int i=0;i<times;i++) {
			tmp=matrix[dr-i][tc];
			matrix[dr-i][tc]=matrix[dr][dc-i];
			matrix[dr][dc-i]=matrix[tr+i][dc];
			matrix[tr+i][dc]=matrix[tr][tc+i];
			matrix[tr][tc+i]=tmp;	
		}
		
	}

	private static void printMatrix(int[][] matrix) {
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				System.out.print(matrix[i][j]+"       ");
			}
			System.out.println();
		}
	}
	
}
