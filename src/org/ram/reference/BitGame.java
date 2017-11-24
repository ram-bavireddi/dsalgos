package org.ram.reference;

public class BitGame {

	public static void main(String[] args) {
		
		
		System.out.println(maxXor(2,4,8));

	}

static int maxXor(int left,int right,int k) {
	int a,b,max=0;
	int result=0;

	for(a=left;a<right;a++) {
		for(b=a+1;b<=right;b++) {
			result=a^b;
			if(result>max && result<=k) {
				max=result;
			}	
		}
	}
	
	return max;
}
}