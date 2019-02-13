package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class RankScores {
	
	public static void rankScore(int n, int[] scores) {
		
		Map<Integer, Integer> mMap = new TreeMap<Integer, Integer>(Collections.reverseOrder());
		for(int i=0; i<n; i++) {
			if(!mMap.containsKey(scores[i])) {
				mMap.put(scores[i], 1);
			} else {
				mMap.put(scores[i], mMap.get(scores[i])+1);
			}
			int rank = findRank(mMap, scores[i]);
			System.out.println("Rank for a score "+scores[i]+" is "+rank);
		}
		
	}
	
	public static int findRank(Map<Integer, Integer> mMap, int target) {
		int ret = 0;
		
		for(Map.Entry<Integer, Integer> entry : mMap.entrySet()) {
			if(entry.getKey() >= target) {
				ret += entry.getValue();
			}
		}
		
		return ret;
	}
	
	public static void main(String[] args) throws IOException {
		
		String filename = "input1.txt";
		
		BufferedReader br = new BufferedReader(new FileReader(filename));
		try {
			
			int n = Integer.parseInt(br.readLine());
			
			String[] array = br.readLine().replaceAll("\\s+$", "").split(" ");
			int[] scores = new int[n];
			for(int i=0; i<n; i++) {
				scores[i] = Integer.parseInt(array[i]);
			}
			
			rankScore(n, scores);
			
		} finally {
			br.close();
		}
	}

}
