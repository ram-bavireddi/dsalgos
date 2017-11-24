package org.ram.reference;

public class LargestSubsetSum {

	public static long[] maxSubsum(int k[]) {

		long maxsub[]=new long[k.length];
		
		for (int j = 0; j < k.length; j++) {
			int sum = 0;
			for (int i = 1; i <= k[j]; i++) {

				if (k[j] % i == 0)
					sum = sum + i;

			}
			maxsub[j]=sum;
		}
		
		return maxsub;
	}

	public static void main(String[] args) {
		
		int array[] = {2,4,10,6};
		long sum[]=maxSubsum(array);
		for(int i=0;i<sum.length;i++) {
			System.out.println(sum[i]);
		}
	
	}

}


