package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;

import exceptions.notRepeatPerson;

public class worldCup implements Serializable {

	private String countryCup;
	private String archives;
	private Competitor firstCompetitor;
	private Spectator root;
	
	public worldCup(String countryCup, String archives) {
		super();
		this.countryCup = countryCup;
		this.archives = archives;
	}
	
	public String getCountryCup() {
		return countryCup;
	}
	public void setCountryCup(String countryCup) {
		this.countryCup = countryCup;
	}
	public String getArchives() {
		return archives;
	}
	public void setArchives(String archives) {
		this.archives = archives;
	}
	
	/*
	 * 
	 */
	public void addSpectatorCVS(Spectator e) {
		Spectator raiz1 = root;
		
		if(root == null) {
			root = e;
		}else {
			raiz1.insertSpectator(e);
		}	
	}
	
	public void loadSpectator() {
		File fl = new File(archives);
		
		try {
		FileReader fr = new FileReader(fl);
		BufferedReader br = new BufferedReader(fr);
		String msj = br.readLine();
		
		while(msj != null) {
			String[] b = msj.split(",");
			String idPersonita = b[0];
			String nameFirstsito = b[1];
			String nameSecondito = b[2];
			String email = b[3];
			String gender = b[4];
			String country = b[5];
			String photo = b[6];
			String birthDay = b[7];
			
			Spectator e = new Spectator(idPersonita,nameFirstsito,nameSecondito,email,gender,country,photo,birthDay);
			addSpectatorCVS(e);
			msj = br.readLine();
			
		}
		br.close();
		fr.close();
		}catch(IOException e) {
			e.getCause();
		}
	}
	
	public void loadCompetitor() {
		File fl = new File(archives);
		
		try {
		FileReader fr = new FileReader(fl);
		BufferedReader br = new BufferedReader(fr);
		String msj = br.readLine();
		
		while(msj != null) {
			String[] b = msj.split(",");
			String idPersonita = b[0];
			String nameFirstsito = b[1];
			String nameSecondito = b[2];
			String email = b[3];
			String gender = b[4];
			String country = b[5];
			String photo = b[6];
			String birthDay = b[7];
			
			Competitor e = new Competitor(idPersonita,nameFirstsito,nameSecondito,email,gender,country,photo,birthDay);
			addCompetitorOrdenate(e);
			msj = br.readLine();
			msj = br.readLine();
		}
		br.close();
		fr.close();
		}catch(IOException e) {
			e.getCause();
		}
	}
	
	public void addSpectatorUser(Spectator e) throws notRepeatPerson {
		
		Spectator raiz1 = root;
		
		if(root == null) {
			root = e;
		}else {
			if(searchSpectator1(e.getIdPerson()) == true) {
				throw new notRepeatPerson("");
			}else {
				raiz1.insertSpectator(e);
			}	
		}
	}

	public boolean searchSpectator1(String idSpectator) {
		Spectator raiz = root;
		boolean t;
		if(idSpectator.compareToIgnoreCase(raiz.getIdPerson()) == 0) {
			return t = true;
		}else {
			return t = raiz.searchSpectator1(idSpectator);
		}
	}
	
	public void addCompetitorOrdenate(Competitor e) {
		Competitor first = firstCompetitor;
		Competitor ant = null;
		if(firstCompetitor == null) {
			firstCompetitor = e;
		}else {
			if(first.getNext() == null) {
				first.setNext(e);
			}else {
				if(e.getIdPerson().compareToIgnoreCase(first.getIdPerson()) < 0) {
					e.setNext(first);
					first.setPrevious(e);
					firstCompetitor = e;
				}else {
					
					while(first != null && first.getIdPerson().compareToIgnoreCase(e.getIdPerson()) < 0) {
						ant = first;
						first = first.getNext();
					}
					
					if(first != null) {
						
						e.setNext(first);
						first.setPrevious(e);
						
						ant.setNext(e);
						e.setPrevious(ant);
					}else {
						e.setNext(first);
						ant.setNext(e);
						e.setPrevious(ant);
					}
					
				}
			}
		}	
	}
	
}
