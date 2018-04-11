package com.google.javase.day3;

/*
 * “之”字形打印矩阵【题目】 给定一个矩阵matrix，
 * 按照“之”字形的方式打印这个矩阵，
 * 例如： 1 2 3 4 5 6 7 8 9  10 11 12“之”字形打印的结果为
 * ：1，2，5，9，6，3，4，7，10，11，8，12【要求】 额外空间复杂度为O(1)
 */
public class ZigZagPrintMatrix {

	public static void main(String[] args) {
		int n = 3, cnt = 1, m = 4;
		int[][] matrix = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				matrix[i][j] = cnt++;
			}
		}
		printMatrixZigZag(matrix);
	}

	private static void printMatrixZigZag(int[][] matrix) {
		int tr = 0, tc = 0;
		int dr = 0, dc = 0;
		int endR = matrix.length - 1;
		int endC = matrix[0].length - 1;
		boolean bool = true;
		while (tc < endC + 1) {
			print(matrix, tr, tc, dr, dc, bool);
			bool = !bool;
			tc = tr == endR ? tc + 1 : tc;
			tr = tr == endR ? tr : tr + 1;
			dr = dc == endC ? dr + 1 : dr;
			dc = dc == endC ? dc : dc + 1;
		}
	}

	private static void print(int[][] matrix, int tr, int tc, int dr, int dc, boolean bool) {
		if (bool) {
			for (int i = 0; tc + i <= dc; i++) {
				System.out.print(matrix[tr - i][tc + i] + " ");
			}
		} 
		else {
			for (int i = 0; dr + i <= tr; i++) {
				System.out.print(matrix[dr + i][dc - i] + " ");
			}
		}
	}

}
