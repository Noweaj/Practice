package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

class Player{
	String name;
	int score;
	
	Player(String name, int score){
		this.name = name;
		this.score = score;
	}
}

class Checker implements Comparator<Player>{
	public int compare(Player a, Player b) {

		Integer aScore = a.score;
		Integer bScore = b.score;
		if(aScore.compareTo(bScore) == 0) {
			String aName = a.name;
			String bName = b.name;
			return aName.compareTo(bName);
		} else {
			return bScore.compareTo(aScore);
		}
		
	}
}

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		String filename = "input1.txt";
		
		BufferedReader br = new BufferedReader(new FileReader(filename));
		
		try {
			int n = Integer.parseInt(br.readLine());
			
			Player[] player = new Player[n];
			Checker checker = new Checker();
			
			for(int i=0; i<n; i++) {
				String[] arrayStr = br.readLine().replaceAll("\\s+$", "").split(" ");
				player[i] = new Player(arrayStr[0], Integer.parseInt(arrayStr[1]));
			}
			
			Arrays.sort(player, checker);
			for(int i=0; i<player.length; i++) {
				System.out.printf("%s %s\n", player[i].name, player[i].score);
				//System.out.println(player[i].name + " " + player[i].score);
			}
		} finally {
			br.close();
		}
		
		
	}

}
