package org.ram.reference;

public class PsychometricTesting {
	
	public static void main(String []ar) {
		
		int scores[]= {4,8,7};
		int lowerLimits[]= {2,4};
		int upperLimits[]= {8,4};
		
		int offers[]=jobOffer(scores,lowerLimits,upperLimits);
		
		for(int i=0;i<offers.length;i++) {
			System.out.println(offers[i]);
		}
		
	}

	
	static int[] jobOffer(int scores[],int lowerLimits[],int upperLimits[]) {
		
		int offers[]=new int[lowerLimits.length];
		int indx=0;
		for(int i=0;i<lowerLimits.length;i++,indx++) {
			int count=0;
			for(int j=0;j<scores.length;j++) {
				if(scores[j]>=lowerLimits[indx] && scores[j]<=upperLimits[indx]) {
					count++;
				}
				offers[i]=count;
			}
		}
		
		return offers;
	}
}

