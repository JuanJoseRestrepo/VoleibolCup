package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import exceptions.notRepeatPerson;

public class worldCup implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String archives;
	private Competitor firstCompetitor;
	private Spectator root;
	
	public worldCup(String archives) {
		this.archives = archives;
		loadSpectator();
		loadCompetitor();
		deserializableABB();
		deserializableCompetitor();
	}
	
	public String getArchives() {
		return archives;
	}
	public void setArchives(String archives) {
		this.archives = archives;
	}
	
	public Competitor getFirstCompetitor() {
		return firstCompetitor;
	}

	public void setFirstCompetitor(Competitor firstCompetitor) {
		this.firstCompetitor = firstCompetitor;
	}

	public Spectator getRoot() {
		return root;
	}

	public void setRoot(Spectator root) {
		this.root = root;
	}
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void serializableABB() {
		
		File fl = new File("files\\Clubs1.dat");
		
		try {
			FileOutputStream flo = new FileOutputStream(fl);
			ObjectOutputStream ob = new ObjectOutputStream(flo);
			
			ob.writeObject((getRoot()));
			ob.close();
			
		}catch(IOException e) {
			e.getCause();
		}
		
	}
	
	public void serializableCompetitor() {
		
		File fl = new File("files\\Clubs.dat");
		
		try {
			FileOutputStream flo = new FileOutputStream(fl);
			ObjectOutputStream ob = new ObjectOutputStream(flo);
			
			ob.writeObject((getFirstCompetitor()));
			ob.close();
			
		}catch(IOException e) {
			e.getCause();
		}
		
	}
	
	public void deserializableABB() {
		File fl = new File("files\\Clubs1.dat");
		try {
		FileInputStream fis = new FileInputStream(fl);
		ObjectInputStream ois = new ObjectInputStream(fis);
		setRoot((Spectator) ois.readObject());
		ois.close();
		}catch(ClassNotFoundException e) {
			e.getCause();
		}catch(IOException e) {
			e.getCause();
		}
	}
	
	public void deserializableCompetitor() {
		File fl = new File("files\\Clubs.dat");
		try {
		FileInputStream fis = new FileInputStream(fl);
		ObjectInputStream ois = new ObjectInputStream(fis);
		setFirstCompetitor((Competitor) ois.readObject());
		ois.close();
		}catch(ClassNotFoundException e) {
			e.getCause();
		}catch(IOException e) {
			e.getCause();
		}
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
		File fl = new File("D:\\VoleibolCup\\files\\clubsVoleibol.csv");
		
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
		File fl = new File("D:\\VoleibolCup\\files\\clubsVoleibol.csv");
		
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
				if(e.getIdPerson().compareToIgnoreCase(first.getIdPerson()) <= 0) {
					e.setNext(first);
					first.setPrevious(e);
					firstCompetitor = e;
				}else {
					
					while(first != null && first.getIdPerson().compareToIgnoreCase(e.getIdPerson()) <= 0) {
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
