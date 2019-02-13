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

public class TreeLevelOrderTraversal {
	
// ==============================================================
	
	/*
	Class Node
		int data;
		Node left;
		Node right;
	*/
	
	public static void levelOrder(Node root) {
		
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
	
	public static void main(String[] args) throws IOException{
		
		String filename = "input1.txt";
		
		BufferedReader br = new BufferedReader(new FileReader(filename));
		try {
			
			int t = Integer.parseInt(br.readLine());
			
			String[] arrayInt = br.readLine().replaceAll("\\s+$", "").split(" ");
			
			Node root = null;
			for(int i=0; i<t; i++) {
				root = insert(root, Integer.parseInt(arrayInt[i]));
			}
			
			levelOrder(root);	
			
		} finally {
			br.close();
		}
	}

}
