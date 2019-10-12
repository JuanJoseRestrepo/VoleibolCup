package ui;
import java.util.Scanner;

import model.*;
public class Main {

	private worldCup cup;
	private Scanner reader;
	
	public Main() {
		reader = new Scanner(System.in);
		cup = new worldCup("files\\clubsVoleibol.csv.csv");
	}
	

	public void showMenu() {
		int inputUser = 0;
		
		System.out.println("/////////////");
		System.out.println("////////////");
		
		while(inputUser != 3) {
			inputUser = reader.nextInt();
			reader.nextLine();
			if(inputUser == 1) {
				Competitor e = new Competitor("b","b","b","b","b","b","b","b");
				Competitor e1 = new Competitor("c","b","b","b","b","b","b","b");
				cup.addCompetitorOrdenate(e);
				cup.addCompetitorOrdenate(e1);
			}else if(inputUser == 2) {
				Spectator e = new Spectator("b","a","a","a","a","a","a","a");
				Spectator e1 = new Spectator("a","a","a","a","a","a","a","a");
				Spectator e2 = new Spectator("c","a","a","a","a","a","a","a");
				cup.addSpectatorCVS(e);
				cup.addSpectatorCVS(e1);
				cup.addSpectatorCVS(e2);
			}else {
				System.out.println("Hasta la proxima!!!");
				cup.serializableABB();
				cup.serializableCompetitor();
			}
		}
		
	}
	public static void main(String[] args) {
		Main m = new Main();
		m.showMenu();
	}
}
