package main;

import java.io.IOException;
import java.util.Stack;
import java.io.BufferedReader;
import java.io.FileReader;

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

public class Main {
	
	public static void preOrder(Node root) {
		// Write your code here.
		
		if(root == null) {
			return;
		}
		
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public static Node insert(Node root, int data) {
		// Write your code here.
		if(root == null) {
			root = new Node(data);
			return root;
		} else {
			Node currNode;
			if(data <= root.data) {
				currNode = insert(root.left, data);
				root.left = currNode;
			} else {
				currNode = insert(root.right, data);
				root.right = currNode;
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
				int data = Integer.parseInt(arrayInt[i]);
				root = insert(root, data);
			}
			
			preOrder(root);
			
		} finally {
			br.close();
		}
	}

}
