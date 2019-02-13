package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node{
	int color;
	List<Integer> adjacent = new ArrayList<>();
	//
	int source = -1;
	int distance = -1;
}

public class FIndTheNearestClone {
	
	private static int findTheShortest(int n, int[] graphFrom, int[] graphTo, long[] id, int val) {
		Node[] nodes = new Node[n];
		
		for(int i=0; i<graphFrom.length; i++) {
			nodes[graphFrom[i]].adjacent.add(graphTo[i]);
			nodes[graphTo[i]].adjacent.add(graphFrom[i]);
		}
		
		for(int i=0; i<n; i++) {
			nodes[i].color = (int) id[i];
		}
		
		
		
		
		
	}
	
	/*
	private static int findTheShortest(int n, int[] graphFrom, int[] graphTo, long[] id, int val) {
		Node[] nodes = new Node[n];
		for(int i=0; i<nodes.length; i++) {
			nodes[i] = new Node();
		}
		
		for(int i=0; i<graphFrom.length; i++) {
			int index1 = graphFrom[i];
			int index2 = graphTo[i];
			
			if(index1 >= nodes.length || index1 >= nodes.length) {				
				return -1;
			}
			
			nodes[index1].adjacent.add(index2);
			nodes[index2].adjacent.add(index1);
		}
		
		for(int i=0; i<nodes.length; i++) {
			nodes[i].color = (int) id[i];
		}
		
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=0; i<nodes.length; i++) {
			if(nodes[i].color == val) {
				nodes[i].source = i;
				nodes[i].distance = 0;
				
				queue.offer(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int head = queue.poll();
			
			for(int adjacent : nodes[head].adjacent) {
				if(nodes[adjacent].source != nodes[head].source) {
					if(nodes[adjacent].source > 0) {
						return nodes[adjacent].distance + nodes[head].distance + 1;
					} else {
						nodes[adjacent].source = nodes[head].source;
						nodes[adjacent].distance = nodes[head].distance + 1;
						
						queue.offer(adjacent);
					}
				}
			}
		}
		
		return -1;
	}
	*/
	
	public static void main(String[] args) throws IOException {
		String filename = "input3.txt";
		
		BufferedReader br = new BufferedReader(new FileReader(filename));
		try {
			
			String[] nm = br.readLine().replaceAll("\\s+$", "").split(" ");
			int n = Integer.parseInt(nm[0]);
			int m = Integer.parseInt(nm[1]);
			
			int[][] gnodes = new int[m][2];
			for(int i=0; i<m; i++) {
				String[] array = br.readLine().replaceAll("\\s+$", "").split(" ");
				gnodes[i][0] = Integer.parseInt(array[0]);
				gnodes[i][1] = Integer.parseInt(array[1]);
			}

			String[] colorIdStr = br.readLine().replaceAll("\\s+$", "").split(" ");
			long[] colorId = new long[n];
			for(int i=0; i<n; i++) {
				colorId[i] = Long.parseLong(colorIdStr[i]);
			}
			
			int analyze = Integer.parseInt(br.readLine());
			
			int ans = findTheShortest(n, gnodes[0], gnodes[1], colorId, analyze);
			System.out.println(ans);
			
		} finally {
			br.close();
		}
	}

}
