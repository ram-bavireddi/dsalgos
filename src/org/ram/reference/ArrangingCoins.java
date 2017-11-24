package org.ram.reference;
import java.util.Scanner;

public class ArrangingCoins {
	
	public static void main(String ar[]) {
		
		System.out.println("Enter n");
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int coins[]=new int[n];
		for(int i=0;i<n;i++) {
			coins[i]=scan.nextInt();
		}
		
		int stairs[]=arrangeCoins(coins);
		
		for(int i=0;i<stairs.length;i++) {
			System.out.print(stairs[i]);
		}
		
	}

	private static int[] arrangeCoins(int[] coins) {
		
		int stairs[]=new int[coins.length];
		
		for(int i=0;i<coins.length;i++) {
			stairs[i]=findStairs(coins[i]);
		}
		
		return stairs;
		
	}

	private static int findStairs(int coins) {
		int stairs=0;
		int leftCoins=coins;
		
		for(int i=1;i<=leftCoins;i++) {
			 leftCoins=leftCoins-i;
			stairs++;
			
		}
		
		return stairs;
		
	}

}
