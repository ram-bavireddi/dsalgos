package org.ram.reference;
import java.util.Scanner;

public class WinnerTest {

	public static void main(String[] args) {
		
		
		
		int andrea[]= {1,2,3};
		int maria[]	= {2,1,3};
						
						System.out.println(winner(andrea,maria,"Odd"));
		
	}
	
	private static String winner(int andrea[],int maria[],String s) {
		
		int index;
		int sum=0;
		if(s.equals("Even")) {
			index=0;	
		}
		else {
			index=1;
		}
		
		for(int i=index;i<andrea.length;i=i+2)
		{
			
			sum=sum+andrea[i]-maria[i];
			
		}
		
		if(sum==0)
			return "Tied";
		if(sum>0)
			return "Andrea";
		else
		return "Maria";
		
	}

}
