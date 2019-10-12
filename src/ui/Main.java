package ui;
import java.util.Scanner;

import model.*;
public class Main {

	private worldCup cup;
	private Scanner reader;
	
	public Main() {
		cup = new worldCup("Peru Copa","files\\clubsVoleibol.csv");
		reader = new Scanner(System.in);
	}
	

	public void showMenu() {
		int inputUser = 0;
		
		System.out.println("/////////////");
		System.out.println("////////////");
	}
	public static void main(String[] args) {
		Main m = new Main();
		m.showMenu();
	}
}
