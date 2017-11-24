package org.ram.reference;

import java.util.Scanner;
import java.util.Stack;

public class Balanced {

	public static void main(String ar[]) {

		
		Scanner scan = new Scanner(System.in);
		
		int len= scan.nextInt();
		String expression[] = new String[len];
		int maxReplacement[]= new int[len];	
		
		for(int i=0;i<len;i++) {
		expression[i] = scan.next();
		
		}
		for(int i=0;i<len;i++) {
		maxReplacement[i] = scan.nextInt();
		}
		
		 int a[]=balancedOrNot(expression,maxReplacement);
		 
		 for(int k:a) {
			 System.out.println(k);
		 }

	}

	private static int[] balancedOrNot(String expression[], int[] maxReplacement) {

		int arr[] = new int[expression.length];
		for (int j = 0; j < expression.length; j++) {

			Stack s = new Stack();

			for (int i = 0; i < expression[j].length(); i++) {

				char c = expression[j].charAt(i);

				if (c == '<')
					s.push('<');
				else if (c == '>' && (!s.isEmpty())) {
					if (s.peek().equals('<')) {
						s.pop();
					} else {
						s.push('>');
					}
				} else {
					s.push('>');
				}
			}

			String remain = "";

			if (s.isEmpty()) {
				arr[j] = 1;
			}

			else {
				
				while (!s.isEmpty()) {
					remain = remain + s.pop();
				}

				if (remain.length() <= maxReplacement[j]) {
					arr[j] = 1;
				} else {
					arr[j] = 0;
				}

			}
		}
		
		return arr;
	}

}
