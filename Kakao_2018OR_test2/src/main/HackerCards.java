package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HackerCards {

	private static Integer[] hackerCards(int[] collection, int d) {
		List<Integer> mList = new ArrayList<>();
		
		List<Integer> colList = new ArrayList<>();
		for(int i=0; i<collection.length; i++) {
			colList.add(collection[i]);
		}
		
		boolean flag = true;
		int cnt = 1;
		int sum = 0;
		while(flag) {
			if(!colList.contains(cnt)) {
				if(sum+cnt <= d) {
					mList.add(cnt);
					sum += cnt;
				} else {
					flag = false;
				}
			}
			cnt++;
		}
		
		Integer[] ret = new Integer[mList.size()];
		ret = mList.toArray(ret);
		return ret;
	}
	
	public static void main(String[] args) throws IOException {

		String filename = "input.txt";
		
		BufferedReader br = new BufferedReader(new FileReader(filename));
		try {
			
			int n = Integer.parseInt(br.readLine());
			
			int[] collection = new int[n];
			for(int i=0; i<n; i++) {
				collection[i] = Integer.parseInt(br.readLine());
			}
			
			int d = Integer.parseInt(br.readLine());
			
			Integer[] ret = hackerCards(collection, d);
			for(int i=0; i<ret.length; i++) {
				System.out.println(ret[i]);
			}
			
		} finally {
			br.close();
		}
	}
}
