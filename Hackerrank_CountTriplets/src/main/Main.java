package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Main {
	
	static long countTriplets(List<Long> arr, long r) {
		
		if(arr.size() < 3) {
			return 0;
		}
		
		Map<Integer, List<Long>> mMap = new HashMap<Integer, List<Long>>();
		
		for(int i=0; i<arr.size(); i++) {
			for(int j=i+1; j<arr.size()+1; j++) {
				for(int k=j+1; k<arr.size()+1; k++) {
					if(!mMap.containsKey(i)) {
						
					}
				}
			}
		}
		
		long cnt = 0;
				
		return cnt;
	}
	
	public static void main(String[] args) throws IOException{
	
		String filename = "input1.txt";
		
		BufferedReader br = new BufferedReader(new FileReader(filename));
		try {
			String[] nr = br.readLine().replaceAll("\\s+$", "").split(" ");
			
			int n = Integer.parseInt(nr[0]);
			long r = Long.parseLong(nr[1]);
			
			String[] nextLine = br.readLine().replaceAll("\\s+$", "").split(" ");
			Long[] nextLineLong = new Long[n] ;
			for(int i=0; i<nextLine.length; i++) {
				nextLineLong[i] = Long.parseLong(nextLine[i]);
			}
			List<Long> arr = Arrays.asList(nextLineLong);
			
			long ans = countTriplets(arr, r);
			System.out.println(ans);
			
			//System.out.println(arr.toString()); // input.txt check
			
		} finally {
			br.close();
		}
	}

}
