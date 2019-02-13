package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	
	static void countSwaps(int[] a) {
		
		boolean isSorted = false;
		
		int numSwap = 0;
		
		while(!isSorted) {
			int cnt = 0;
			for(int i=0; i<a.length-1; i++) {
				if(a[i] > a[i+1]) {
					swap(a, i, i+1);
					cnt++;
					numSwap++;
				}
	
			}
			if(cnt == 0) {
				isSorted = true;
			}
		}
		
		System.out.println("Array is sorted in " + numSwap + " swaps.");

		int firstElement = a[0];
		int lastElement = a[a.length-1];
        System.out.println("First Element: " + firstElement);
        System.out.println("Last Element: " + lastElement);
	}
	
	static void swap(int[]a, int b, int c) {
		int temp = a[b];
		a[b] = a[c];
		a[c] = temp;
	}
	
	public static void main(String[] args) throws IOException{
		
		String filename = "input1.txt";
		
		BufferedReader br = new BufferedReader(new FileReader(filename));
		try {
			
			int n = Integer.parseInt(br.readLine());
			
			String[] arrayStr = br.readLine().replaceAll("\\s+$", "").split(" ");
			int[] arrayInt = new int[n];
			for(int i=0; i<arrayStr.length; i++) {
				arrayInt[i] = Integer.parseInt(arrayStr[i]);
			}
			
			countSwaps(arrayInt);
			
		} finally {
			br.close();
		}
	}

}
