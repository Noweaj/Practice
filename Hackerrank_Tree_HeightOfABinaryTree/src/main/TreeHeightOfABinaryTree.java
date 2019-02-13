package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

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

public class TreeHeightOfABinaryTree {
	
	public static int height(Node root) {
		
		class newNode{
			Node node;
			int vd; // vertical distance
			
			newNode(Node node, int vd){
				this.node = node;
				this.vd = vd;
			}
		}
		
		Stack<newNode> mStack = new Stack<newNode>();
		
		mStack.push(new newNode(root, 0));
		int cnt = 0;
		
		while(!mStack.isEmpty()) {
			newNode tempNewNode = mStack.pop();
			if(tempNewNode.vd > cnt) {
				cnt = tempNewNode.vd;
			}
			
			if(tempNewNode.node.left != null) {
				mStack.push(new newNode(tempNewNode.node.left, tempNewNode.vd+1));
			}
			
			if(tempNewNode.node.right != null) {
				mStack.push(new newNode(tempNewNode.node.right, tempNewNode.vd+1));
			}
		}
		
		return cnt;
		
	}
	
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
				int data = Integer.parseInt(arrayInt[i]);
				root = insert(root, data);
			}
			
			int height = height(root);
			System.out.println(height);
			
		} finally {
			br.close();
		}
	}
}
