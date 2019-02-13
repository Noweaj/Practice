package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Divisor {
	
	public static void main(String[] args) throws IOException {
		
		String filename = "input1.txt";
		
		BufferedReader br = new BufferedReader(new FileReader(filename));
		try {
			String[] array = br.readLine().replaceAll("\\s+$", "").split(" ");
			
			for(int i=0; i<array.length; i++) {
				int input = Integer.parseInt(array[i]);
				printDivisor(input);
				System.out.println(" ");
			}
		} finally {
			br.close();
		}
	}
	
	private static void printDivisor(int input) {
		List<Integer> mList = new ArrayList<Integer>();
		
		for(int i=1; i<input+1; i++) {
			if(input%i == 0)
				System.out.print(i+" ");
		}
	}

}
