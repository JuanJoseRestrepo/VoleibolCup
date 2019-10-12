package ui;
import java.util.Scanner;

import model.*;
public class Main {

	private worldCup cup;
	private Scanner reader;
	
	public Main() {
		cup = new worldCup("files\\clubsVoleibol");
		reader = new Scanner(System.in);
	}
	

	public void showMenu() {
		int inputUser = 0;
		
		System.out.println("/////////////");
		System.out.println("////////////");
		
		while(inputUser != 3) {
			inputUser = reader.nextInt();
			reader.nextLine();
			if(inputUser == 1) {
				
			}else if(inputUser == 2) {
				
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
