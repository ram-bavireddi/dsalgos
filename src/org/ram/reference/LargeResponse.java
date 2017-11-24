package org.ram.reference;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class LargeResponse {

	
	private static final String FILENAME = "C:\\Users\\sanjay_raikwar\\eclipse-workspace\\Hackerrank\\src\\java8\\a.txt";

	public static void main(String[] args) {
		
		
		int sum=0 , count=0;
		
		try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				
					StringTokenizer stringTokenizer = new StringTokenizer(sCurrentLine);
				
				int total=stringTokenizer.countTokens();

				for(int i=0;i<total-1;i++)
				{
					stringTokenizer.nextToken();
				}
				
				System.out.println();
				
				int token=Integer.parseInt(stringTokenizer.nextToken());
			if(token>5000) {
				count=count+1;
				sum=sum+token;
			}
			
				
			}
			
			System.out.println(count);
			System.out.println(sum);
			
			write(count,sum);

		} catch (IOException e) {
			e.printStackTrace();
		}

		}
	
	
	static void write(int count,int sum) {
		
		
		final String name = "C:\\Users\\sanjay_raikwar\\eclipse-workspace\\Hackerrank\\src\\java8\\bytes_a.txt";

		

			try (BufferedWriter bw = new BufferedWriter(new FileWriter(name))) {

				String content = count+"\n"+sum;

				bw.write(content);

				// no need to close it.
				//bw.close();

				System.out.println("Done");

			} catch (IOException e) {

				e.printStackTrace();

			}

		}
	

	}

