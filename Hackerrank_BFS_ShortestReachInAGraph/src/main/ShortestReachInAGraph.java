package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node{
	int id;
	List<Node> linkedNodes = new LinkedList<>();
	
	public Node(int id) {
		this.id = id;
	}
	
	public void addNode(Node node) {
		linkedNodes.add(node);
	}
	
	public List<Node> getNodes(){
		return linkedNodes;
	}
}

public class ShortestReachInAGraph {
	
	private static int calculateDistance(int n, Node curNode, Node startNode) {
		final int edgeLength = 6;
		
		if(curNode == null || startNode == null) {
			return -1;
		}
		
		Queue<Node> firstQueue = new LinkedList<>();
		Queue<Node> secondQueue = new LinkedList<>();
		
		firstQueue.offer(curNode);
		
		int level = 0;
		boolean[] visitedNodes = new boolean[n];
		
		while(!firstQueue.isEmpty() || !secondQueue.isEmpty()) {
			
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
String filename = "input1.txt";
		
		BufferedReader br = new BufferedReader(new FileReader(filename));
		try {
			
			int q = Integer.parseInt(br.readLine()); // the number of queries
			
			for(int i=0; i<q; i++) {
				String[] iArray = br.readLine().replaceAll("\\s+$", "").split(" ");
				int n = Integer.parseInt(iArray[0]); // the number of nodes
				int m = Integer.parseInt(iArray[1]); // the number of edges
				
				Node[] nodes = new Node[n];
				
				for(int j=0; j<m; j++) {
					String[] jArray = br.readLine().replaceAll("\\s+$", "").split(" ");
					int u = Integer.parseInt(jArray[0])-1; // subtract 1 to fit into array index
					int v = Integer.parseInt(jArray[1])-1;
					
					Node uNode = nodes[u];
					if(uNode == null) {
						uNode = new Node(u);
						nodes[u] = uNode;
					}
					
					Node vNode = nodes[v];
					if(vNode == null) {
						vNode = new Node(v);
						nodes[v] = vNode;
					}
					
					// Connect bi-directional
					uNode.addNode(vNode);
					vNode.addNode(uNode);
				}
				
				int s = Integer.parseInt(br.readLine())-1; // the index of the starting node
				
				for(int k=0; k<nodes.length; k++) {
					if(k != s) {
						int dist = calculateDistance(n, nodes[k], nodes[s]);
						System.out.print(dist + " ");
					}
				}
				System.out.println();
			}
			
		} finally {
			br.close();
		}
	}

}
