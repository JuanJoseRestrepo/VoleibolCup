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

import exceptions.notFoundCompetitor;
import exceptions.notFoundPersonError;
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
		verifyNotReCharger();
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
	
	public void verifyNotReCharger() {
		File fl = new File("files\\Clubs1.dat");
		File fl1 = new File("files\\Clubs.dat");
		if(!fl.exists() && !fl1.exists()) {
			loadSpectatorAndSpectator();
		}
		
	}
	
	public int longitud() {
		int resul = 0;
		Competitor m = firstCompetitor;
		
		while(m != null) {
			resul++;
			m = m.getNext();
		}
		
		return resul;
		
	}
	
	public Competitor indiceElement(int posicion) {
		Competitor samu = firstCompetitor;
		
		if(posicion != 0) {
			for(int i = 0; i < posicion;i++) {
				
				samu = samu.getNext();
				
			}
		}else {
			
			samu = firstCompetitor;
			
		}
		
		return samu;
	}
	
	public String buscarRecursivamente(String idPerson) {
		String msj = "";
		
		return  msj = recorridoRecursivo(idPerson, getFirstCompetitor());
		
	}
	
    public String recorridoRecursivo (String idPerson,Competitor e) {
    	String msj = "";
    	if(e == null) {
    		return msj = "No se encontro";
    	}
    	if(e.getIdPerson().compareToIgnoreCase(idPerson) == 0) {
    	return msj = e.toString();	
    	}else {
    	return msj = recorridoRecursivo(idPerson, e.getNext());
    	}
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
	
	public void loadSpectatorAndSpectator() {
		File fl = new File(archives);
		
		try {
		FileReader fr = new FileReader(fl);
		BufferedReader br = new BufferedReader(fr);
		String msj = br.readLine();
		int i = 0;
		while(msj != null) {
			if(i % 2 == 0) {
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
			}else if(i % 2 != 0){
				
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
			}
			i++;
		}
		System.out.println("---------");
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
			if(searchSpectator1(e.getIdPerson()) != null) {
				throw new notRepeatPerson("No se puede repetir");
			}else {
				raiz1.insertSpectator(e);
			}	
		}
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public Spectator searchSpectator1(String idSpectator) {
		Spectator raiz = root;
		
		if(idSpectator.compareToIgnoreCase(raiz.getIdPerson()) == 0) {
			return root;
		}else {
			return raiz.searchSpectator1(idSpectator);
		}
	}
	
	public String searchSpectator2(String idSpectator) throws notFoundPersonError {
		Spectator raiz = root;
		String msj = "";
		if(idSpectator.compareToIgnoreCase(raiz.getIdPerson()) == 0) {
			return msj = root.toString();
		}else {
			return msj  = raiz.searchSpectator3(idSpectator);
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
	
	public String searchCompetitors(String idPerson) throws notFoundCompetitor {
		String msj = "";
		Competitor first = firstCompetitor;
		boolean t = false;
		while(first != null && !t) {
			if(first.getIdPerson().compareToIgnoreCase(idPerson) == 0) {
				msj = first.toString();
				t = true;
			}else {
				first = first.getNext();
			}
		}
		
		if(t == false) {
			throw new notFoundCompetitor("No se encontro");
		}
		
		return msj;
		
	}
	
	public String paintCountry(String country) {
		String msj = "";
		Competitor first = firstCompetitor;
		boolean t = false;
		while(first != null && !t) {
			if(first.getCountry().compareToIgnoreCase("China") == 0) {
				msj += first.toString() + "--->";
			}
				first = first.getNext();
				if(first.getNext() == null) {
					t = true;
				
			}
	
		}
		
		
		
		return msj;
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void pintarArbol(Spectator e,int pos,String country) {

		if(e == null) 
			return;
		pintarArbol(e.getRigth(),pos + 1,country);
		if(e.getCountry().compareToIgnoreCase(country) == 0) {
			if(pos != 0) {
				int i = 0;
				while(i < pos-1) {
				System.out.print("|\t");
				i++;
			}	
			System.out.println("|------" + e.getIdPerson());
		    }else {
		    	System.out.println("|-" +e.getIdPerson());;
		    }
		pintarArbol(e.getLeft(), pos + 1,country);	
	}
  }
}
