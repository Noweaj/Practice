package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FindIndexOfX {
	
	public static void findIdxOfX(int x, int[] input) {
		int cnt = 0;
		search(0, input.length-1, x, input, cnt);
	}
	
	public static void search(int idx1, int idx2, int x, int[] input, int cnt) {
		if(idx1-idx2 == 0) {
			if(input[idx1] == x) {
				System.out.println(idx1);
			}
		} else {
			cnt++;
			search(idx1, (idx2-idx1)/2, x, input, cnt);
			search((idx2-idx1)/2+1, idx2, x, input, cnt);
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		String filename = "input1.txt";
		
		BufferedReader br = new BufferedReader(new FileReader(filename));
		try {
			
			String[] nx = br.readLine().replaceAll("\\s+$", "").split(" ");
			int n = Integer.parseInt(nx[0]); // # of shifts
			int x = Integer.parseInt(nx[1]); // the integer X we need to find index of
			
			String[] arrStr = br.readLine().replaceAll("\\s+$", "").split(" ");
			int[] arrInt = new int[arrStr.length];
			for(int i=0; i<arrStr.length; i++) {
				arrInt[i] = Integer.parseInt(arrStr[i]);
			}
			
			// Shift n times
			for(int i=0; i<n; i++) {
				int idxFirst = arrInt[0];
				//int idxLast = arrInt[arrInt.length-1];
				for(int j=0; j<arrInt.length-1; j++) {
					arrInt[j] = arrInt[j+1];
				}
				arrInt[arrInt.length-1] = idxFirst;
			}
			
			findIdxOfX(x, arrInt);
			
		} finally {
			br.close();
		}
	}

}
