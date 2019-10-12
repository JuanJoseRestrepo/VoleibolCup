package ui;
import java.util.InputMismatchException;
import java.util.Scanner;

import exceptions.notRepeatPerson;
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
			
			try {
			inputUser = reader.nextInt();
			reader.nextLine();
			if(inputUser == 1) {

//				System.out.println(cup.searchSpectator2("1"));
				cup.pintarArbolito();
			}else if(inputUser == 2) {
				Spectator e = new Spectator("baaaaa","aaaaaaaaaa","aaaaaaaa","aaaaaaaaaa","aaaaaaaaa","aaaaaa","aaaaa","aaa");
				cup.addSpectatorUser(e);

			}else {
				System.out.println("Hasta la proxima!!!");
				cup.serializableABB();
				cup.serializableCompetitor();
			}
			
			
		}catch(notRepeatPerson e) {
			e.getCause();
			System.out.println("Se encontor uno repetido");
		}catch(InputMismatchException e) {
			System.out.println("Digite por favor un digito valido");
			e.getCause();
		}
			
	}
}
	public static void main(String[] args) {
		Main m = new Main();
		m.showMenu();
	}
}
