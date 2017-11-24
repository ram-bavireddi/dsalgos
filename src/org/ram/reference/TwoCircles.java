package org.ram.reference;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TwoCircles {
	
	public static void main(String[] args){
		
		/*
		 * 4
12 0 21 14 0 23
0 45 8 0 94 9
35 0 13 10 0 38
0 26 8 0 9 25
		 */
		
		try(Scanner scanner = new Scanner(System.in)){
			
			int noOfTests = Integer.parseInt(scanner.nextLine());
			
			List<int[]> testsList = new ArrayList<>();
			
			int counter = noOfTests;
			while(counter-- > 0){
				readTestData(scanner,testsList);
				
			}
			
			for(int[] testData:testsList){
				printTwoCircleProperties(testData);
			}
			
		}catch(Exception e){
			
			System.out.println("Error while reading/processing the test data"+e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void readTestData(Scanner scanner, List<int[]> testsList){
		//c1x (c1's center x axis value),c1y (c1's center y axis value),c1R (c1's radius)
		//c2x (c2's center x axis value),c2y (c2's center y axis value),c2R (c2's radius)
		
		int[] testData = new int[6];
		
		String testLine = scanner.nextLine();
		String[] tokens = testLine.split(" ");
		testData[0] = Integer.parseInt(tokens[0]);
		testData[1] = Integer.parseInt(tokens[1]);
		testData[2] = Integer.parseInt(tokens[2]);
		testData[3] = Integer.parseInt(tokens[3]);
		testData[4] = Integer.parseInt(tokens[4]);
		testData[5] = Integer.parseInt(tokens[5]);
		
		testsList.add(testData);
		
	}
	
	
	public static void printTwoCircleProperties(int[] twoCircles){
	
		boolean isOnXAxis = twoCircles[1] == 0 ? true : false;
		
		int c1CenterPoint = 0;
		int c1Radius = twoCircles[2] ;
		int c2CenterPoint = 0;
		int c2Radius = twoCircles[5] ;
		
		if(isOnXAxis){
			c1CenterPoint =  twoCircles[0];
			c2CenterPoint = twoCircles[3];
		}else {
			c1CenterPoint = twoCircles[1];
			c2CenterPoint = twoCircles[4];
			
		}
		
		if(isConcentric(c1CenterPoint,c1Radius,c2CenterPoint,c2Radius)){
			
			System.out.println("Concentric");
			
		}else if(isTouching(c1CenterPoint,c1Radius,c2CenterPoint,c2Radius)){
			
			System.out.println("Touching");
			
		}else if(isDisjoinInside(c1CenterPoint,c1Radius,c2CenterPoint,c2Radius)){
			
			System.out.println("Disjoint-Inside");
			
		}else if(isDisjoinOutside(c1CenterPoint,c1Radius,c2CenterPoint,c2Radius)){
			System.out.println("Disjoint-Outside");
		}else {
			System.out.println("Intersecting");
		}
		
	}
	
	
	public static boolean isConcentric(int c1CenterPoint,int c1Radius,int c2CenterPoint,int c2Radius){
		
		return c1CenterPoint == c2CenterPoint;
	}
	
	public static boolean isTouching(int c1CenterPoint,int c1Radius,int c2CenterPoint,int c2Radius){
		
		if( (c1CenterPoint + c1Radius) ==  (c2CenterPoint + c2Radius) ){
			return true;
		} else if((c1CenterPoint + c1Radius) ==  (c2CenterPoint - c2Radius)){
			return true;
		} else if((c1CenterPoint - c1Radius) ==  (c2CenterPoint + c2Radius)){
			return true;
		}else if((c1CenterPoint - c1Radius) ==  (c2CenterPoint - c2Radius)){
			return true;
		}else return false;
	}
	
	public static boolean isDisjoinInside(int c1CenterPoint,int c1Radius,int c2CenterPoint,int c2Radius){
		
		
		boolean isC1CenterLessThanC2Center = c1CenterPoint < c2CenterPoint ;
		
		if(isC1CenterLessThanC2Center)	{
			
			//if c1 contains c2, then c2 boundaries should be  inside c1 boundaries
			if( ((c2CenterPoint + c2Radius) < (c1CenterPoint + c1Radius) ) && ((c2CenterPoint - c2Radius) > (c1CenterPoint + c1Radius) ) ){
				return true;
			
			} else if(((c2CenterPoint - c2Radius) < (c1CenterPoint - c1Radius) ) && ((c2CenterPoint + c2Radius) > (c1CenterPoint + c1Radius) )) { //if c2 contains c1, then c1 boundaries should be inside c2 boundary
				
				return true;
			}
			
		} else { //here, c2 center is less than c1
			
			//if c1 contains c2, then c2 boundaries should be  inside c1 boundaries
			if( ((c2CenterPoint + c2Radius) < (c1CenterPoint + c1Radius) ) && ((c2CenterPoint - c2Radius) > (c1CenterPoint - c1Radius) ) ){
				return true;
			
			} else if(((c2CenterPoint - c2Radius) < (c1CenterPoint - c1Radius) ) && ((c2CenterPoint + c2Radius) > (c1CenterPoint + c1Radius) )) { //if c2 contains c1, then c1 boundaries should be inside c2 boundary
				
				return true;
			}
			
		}
			
		return false;
		
	}
	
	public static boolean isDisjoinOutside(int c1CenterPoint,int c1Radius,int c2CenterPoint,int c2Radius){
		
		boolean isC1CenterLessThanC2Center = c1CenterPoint < c2CenterPoint ;
		
		if(isC1CenterLessThanC2Center){
			return c1CenterPoint + c1Radius < c2CenterPoint - c2Radius;
		} else {
			
			return c2CenterPoint + c2Radius < c1CenterPoint - c1Radius;
		}
	}

}
