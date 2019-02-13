package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	
	static void minimumBribes(int[] q) {
		
		boolean tooChaotic = false;
		int n=0; // # of bribing operations
		
		for(int i=0; i<q.length; i++) {
			if(q[i]-(i+1) > 2) {
				tooChaotic = true;
				break;
			}
			if(q[i] > i+1) {
				n+= q[i] - (i+1);
			}
		}
		
		if(tooChaotic) {
			System.out.println("Too chaotic");
		} else {
			System.out.println(n);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		String filename = "input.txt";
		
		BufferedReader br = new BufferedReader(new FileReader(filename));
		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			
			while(line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			
			String everything = sb.toString();

			System.out.println(everything);
		} finally{
			br.close();
		}
		
	}

}