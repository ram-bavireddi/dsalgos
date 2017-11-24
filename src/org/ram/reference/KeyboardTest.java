package org.ram.reference;

import java.util.Scanner;

public class KeyboardTest {

	public static void main(String[] args) {

		int a[][] = new int[3][3];
		Scanner scan = new Scanner(System.in);

		System.out.println("enter");
		String str = scan.next();

		String keyboard = scan.next();

		int index = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++, index++) {
				a[i][j] = Integer.parseInt(keyboard.substring(index, index + 1));
			}
		}

		
		int digits[] = new int[str.length()];
		for (int i = 0; i < str.length(); i++) {
			digits[i] = Integer.parseInt(str.substring(i, i + 1));

		}

		System.out.println(entryTime(a, digits));

	}

	static int entryTime(int a[][], int digits[]) {

		int totalTime = 0;
		int locI = 0;
		int locJ = 0;

		for (int idx = 0; idx < digits.length; idx++) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (a[i][j] == digits[idx]) {
						

						if (locI == 0 && locJ == 0 && idx==0) {
							locI = i;
							locJ = j;
						} 
						
						else if(i==locI && j==locJ){
							}
							else if(i==locI+2 || i==locI-2 || j==locJ+2 || j==locJ-2) {
								totalTime = totalTime+2;
								locI = i;
								locJ = j;
							}
							
							else {
								totalTime = totalTime+1;
								locI = i;
								locJ = j;
							}
						}
					}
				}
			}

		
		return totalTime;
	}
}
