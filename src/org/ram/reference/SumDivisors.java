package org.ram.reference;

public class SumDivisors {
	
	public static void main(String ar[]) {
		
		int sum=sumDiv(10);
		
		System.out.println(sum);


	}

	private static int sumDiv(int num) {
		int sum=0;
		for(int i=1;i<=num/2;i++) {
		if(num%i==0)
		{
			sum=sum+i;
		}
			
		}
		
		return sum;
	}

}
