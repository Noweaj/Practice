package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	
	static int activityNotifications(int[] expenditure, int d) {
		
		int ret = 0;
		
		
		return ret;
	}

	public static void main(String[] args) throws IOException {
		
		String filename = "input1.txt";
		
		BufferedReader br = new BufferedReader(new FileReader(filename));
		try {
			String[] nd = br.readLine().replaceAll("\\s+$", "").split(" ");
			
			int n = Integer.parseInt(nd[0]);
			int d = Integer.parseInt(nd[1]);
			
			String[] expenditureItems = br.readLine().replaceAll("\\s+$", "").split(" ");
			int[] expenditure = new int[n];
			for(int i=0; i<n; i++) {
				expenditure[i] = Integer.parseInt(expenditureItems[i]);
			}
			
			int result = activityNotifications(expenditure, d);
			
		} finally {
			br.close();
		}
	}
}
