package org.ram.reference;

public class IronManFight {
	
	public static void main(String ar[]) {
		
		int p[]= {-5,4,-2,3,1,-1,-6,-1,0,5};
		
		int requiredCharge = requiredChargeToFight(p);
			System.out.println(requiredCharge);
		
	}
	
private static int requiredChargeToFight(int[] p) {
	int remainCharge=1;
	int requiredCharge=1;
	
	
	for(int i=0;i<p.length;i++) {
		
		if(p[i]< 0 && remainCharge<=Math.abs(p[i])) {
			
			requiredCharge=requiredCharge+Math.abs(p[i])-remainCharge+1;
			
			remainCharge=1;
			
		}
		
		else {
		remainCharge = remainCharge + p[i];
		}
		
	}
		return requiredCharge;
	}
	
	}
