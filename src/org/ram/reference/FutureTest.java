package org.ram.reference;

public class FutureTest {
	
	public static void main(String ar[]) {
		
		int days=calculate(3,5,1);
		
		System.out.println(days);
	}
	
	static int calculate(int A,int K,int P){
		int days=1;
		
		while(true) {
			
			int aSolution=(A*days)+P;
			int kSolution=(K*days);
			
			if(aSolution<kSolution)
			{
				return days;
			}
			
			days++;
			
			continue;
				
		}
		
	}

}
