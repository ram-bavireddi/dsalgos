package org.ram.reference;

import java.util.Scanner;

public class ShowTicket {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("enter the size of array");

		int size = scan.nextInt();

		int tickets[] = new int[size];

		System.out.println("enter the of array element");

		for (int i = 0; i < tickets.length; i++) {
			tickets[i] = scan.nextInt();
		}

		System.out.println("index of person");
		int p = scan.nextInt();

		int time = waitingTime(tickets, p);
		
		System.out.println("waiting time is="+time);

	}

	static int waitingTime(int tickets[], int position) {
		int time = 1;

		while(true ) 
		{
			if((tickets[position]==1) && (position==0)){
				return time;
				}
			int current = tickets[0] - 1;
			
			if (current == 0){
				int tkts[]=removeZero(tickets);
				tickets=tkts;
				position=position-1;
			}
			
			else {
			position = suffle(tickets, position,current);
			}
			  time = time + 1;	
				
		}
		
		
	}

	static int suffle(int tickets[], int position , int current) {

		
		int i = 0;

		for (i = 0; i < tickets.length - 1; i++) {

			tickets[i] = tickets[i + 1];
		}
		if (position == 0) {
			position = tickets.length - 1;
		} else {
			position--;
		}
	
			tickets[i] = current;

		return position;

	}
	
	public static int[] removeZero(int[] tickets) {
	    
		int tkt[]=new int [tickets.length-1];
	    for(int i=1;i<tickets.length;i++)
	    	tkt[i-1]=tickets[i];
	    return tkt;

}
}
