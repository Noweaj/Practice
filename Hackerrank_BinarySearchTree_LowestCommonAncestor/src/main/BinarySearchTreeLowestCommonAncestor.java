package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Node{
	Node left;
	Node right;
	int data;
	
	Node(int data){
		this.data = data;
		left = null;
		right = null;
	}
}

public class BinarySearchTreeLowestCommonAncestor {
	
	// ==============================================================
	
	/*
	class Node
		int data;
		Node left;
		Node right;
	*/
	
	public static Node lca(Node root, int v1, int v2) {
		// write code here
		if(root == null) {
			return null;
		}
		
		if(v1 > v2) {
			int temp = v1;
			v1 = v2;
			v2 = temp;
		}
		
		while(root.data < v1 || root.data > v2) {
			if(root.data < v1) {
				root = root.right;
			} else if(root.data > v2) {
				root = root.left;
			}
		}
		
		return root;
	}
	
	
	// ==============================================================
	
	public static Node insert(Node root, int data) {
		if(root == null) {
			return new Node(data);
		} else {
			Node cur;
			if(data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			
			return root;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		String filename = "input1.txt";
		
		BufferedReader br = new BufferedReader(new FileReader(filename));
		try {
			
			int n = Integer.parseInt(br.readLine());
			
			String[] nodeDataArray = br.readLine().replaceAll("\\s+$", "").split(" ");
			
			String[] vArray = br.readLine().replaceAll("\\s+$", "").split(" ");
			int v1 = Integer.parseInt(vArray[0]);
			int v2 = Integer.parseInt(vArray[1]);
				
			Node root = null;
			for(int i=0; i<n; i++) {
				root = insert(root, Integer.parseInt(nodeDataArray[0]));
			}
			
			Node ans = lca(root, v1, v2);
			System.out.println(ans.data);
		} finally {
			br.close();
		}
	}

}
