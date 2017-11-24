package org.ram.reference;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountingGroup {

	public static void main(String ar[]) {
		Scanner scan = new Scanner(System.in);

		System.out.println("enter the size of array");

		int m = scan.nextInt();

		System.out.println("enter the size of array");

		int n = scan.nextInt();

		int array[][] = new int[m][n];

		System.out.println("enter the of array element");

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {

				array[i][j] = scan.nextInt();
			}
		}

		int size = scan.nextInt();

		int[] k = new int[size];

		for (int i = 0; i < k.length; i++) {
			k[i] = scan.nextInt();
		}

		int counts[] = findGroups(array, k);

		for (Object c : counts) {
			System.out.println(c);
		}

	}


		
		private static int count = 0;
		public static int[] findGroups(int[][] array, int[] groups) {
			int result[] = new int[groups.length];
			boolean isVisited[][] = new boolean[array.length][array[0].length];
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			for(int row=0; row<array.length; row++){
				for(int col=0; col<array[0].length; col++){
					if(!isVisited[row][col] && array[row][col] == 1){
						dfs(row, col, array, isVisited);
						if(map.containsKey(count)){
							map.put(count, map.get(count)+1);
						}else{
							map.put(count, 1);
						}
						count = 0;
					}
				}
			}
			for(int i=0; i<groups.length; i++){
				if(map.containsKey(groups[i])){
					result[i] = map.get(groups[i]);
				}else{
					result[i] = 0;
				}
			}
			return result;
		}
		private static void dfs(int row, int col, int[][] array,
				boolean[][] isVisited) {
			isVisited[row][col] = true;
			count++;
			int rows[] = {-1, 0, 0, 1};
			int cols[] = {0, -1, 1, 0};
			for(int i=0; i<4; i++){
				if(isSafe(row+rows[i], col+cols[i], array, isVisited)){
					dfs(row+rows[i], col+cols[i], array, isVisited);
				}
			}
		}
		private static boolean isSafe(int i, int j, int[][] array,
				boolean[][] isVisited) {
			if(i >= 0 && i < array.length && j>=0 && j<array[0].length && !isVisited[i][j] && array[i][j]==1){
				return true;
			}
			return false;

	}
}
