package ui;
import java.util.InputMismatchException;
import java.util.Scanner;

import exceptions.errorNotRank;
import exceptions.notFoundCompetitor;
import exceptions.notFoundPersonError;
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
		
		System.out.println("///////////////////////////////////////////////////////////////////////////");
		System.out.println("1.Buscar a los espectadores por id");
		System.out.println("2.Buscar a los competidores por id");
		System.out.println("3.A�adir espectador al arbol (Opcional)");
		System.out.println("4.Mostrar paises de los competidores(Lista)");
		System.out.println("5.Mostrar paises de los espectadores(Arbol)");
		System.out.println("6.Salir");
		System.out.println("///////////////////////////////////////////////////////////////////////////");
		
		while(inputUser != 6) {
			
			try {
			inputUser = reader.nextInt();
			reader.nextLine();
			
			if(inputUser <= 0 || inputUser >= 7) {
			throw new errorNotRank("");
			}
			if(inputUser == 1) {
				System.out.println("Por favor digite el id de la persona");
				String msj = reader.nextLine();
				
				long b1 = System.nanoTime();	
				if(cup.searchSpectator2(msj) == "") {
				throw new notFoundPersonError("No se encontro");	
				}else {
				System.out.println(cup.searchSpectator2(msj));
				}
				long b2 = System.nanoTime();
				System.out.println("El tiempo es:" + (b2-b1));
				
				
			}else if(inputUser == 2) {
				System.out.println("Por favor digite el id del competidor");
				String id1 = reader.nextLine();
				
				long b1 = System.nanoTime();
				System.out.println(cup.searchCompetitors(id1));
				long b2 = System.nanoTime();
				
				System.out.println("El tiempo es:" + (b2-b1));
				
			}else if(inputUser == 3){
				
				System.out.println("Por favor digite el id de la persona");
				String idPer = reader.nextLine();
				
				System.out.println("Por favor digite el primer nombre de la persona");
				String primer = reader.nextLine();
				
				System.out.println("Por favor digite el segundo nombre de la persona");
				String segundo = reader.nextLine();
				
				System.out.println("Por favor digite el correo de la persona");
				String correo = reader.nextLine();
				
				System.out.println("Por favor digite el genero de la persona");
				String genero = reader.nextLine();
				
				System.out.println("Por favor digite el pais de la persona");
				String country = reader.nextLine();
				
				System.out.println("Por favor digite el link de la foto de la persona");
				String photo = reader.nextLine();
				
				System.out.println("Por favor digite la fecha de nacimiento");
				String birthday = reader.nextLine();
				
				Spectator e = new Spectator(idPer,primer,segundo,correo,genero,country,photo,birthday);
				cup.addSpectatorUser(e);
				
			}else if(inputUser == 4) {
				System.out.println("Digite el pais que necesita");
				String msj = reader.nextLine();
				
				System.out.println(cup.paintCountry(msj));
			}else if(inputUser == 5) {
				System.out.println("Digite el pais que necesita");
				String msj = reader.nextLine();
				
				cup.pintarArbol(cup.getRoot(),0,msj);
				
			}else{
				System.out.println("Hasta la proxima!!!");
			}
			
			
		}catch(notRepeatPerson e) {
			e.getCause();
			System.out.println("Se encontor uno repetido");
		}catch(InputMismatchException e) {
			System.out.println("Digite por favor un digito valido");
			e.getCause();
		} catch (notFoundPersonError e) {
			System.out.println("No se encontro");
			e.getCause();
		} catch (notFoundCompetitor e) {
			System.out.println("No se encontro al competidor");
			e.getCause();
		} catch (errorNotRank e) {
			System.out.println("Digite un rango valido");
			e.getCause();
		}
			
	}
}
	public static void main(String[] args) {
		Main m = new Main();
		m.showMenu();
	}
}
