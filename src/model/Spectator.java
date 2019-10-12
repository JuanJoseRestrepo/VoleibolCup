package model;

import java.io.Serializable;

import exceptions.notFoundPersonError;

public class Spectator extends Person implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Spectator left;
	private Spectator rigth;
	
	public Spectator(String idPerson, String nameFirst, String nameLast, String email, String gender, String country,
			String photo, String birthDay) {
		super(idPerson, nameFirst, nameLast, email, gender, country, photo, birthDay);
	}

	public Spectator getLeft() {
		return left;
	}

	public void setLeft(Spectator left) {
		this.left = left;
	}

	public Spectator getRigth() {
		return rigth;
	}

	public void setRigth(Spectator rigth) {
		this.rigth = rigth;
	}

	public void insertSpectator(Spectator e) {
		
		if(idPerson.compareToIgnoreCase(e.getIdPerson()) < 0) {
			
			if(rigth == null) {
				setRigth(e);
			}else {
				this.rigth.insertSpectator(e);
			}	
		}else {
			if(left == null) {
				setLeft(e);
			}else {
				this.left.insertSpectator(e);
			}
		}
	}
	
	
	public Spectator searchSpectator1(String idPersonita) {
		Spectator encon = null;
		if(idPerson.compareToIgnoreCase(idPersonita) == 0) {
			return this;
		}else {
			if(idPerson.compareToIgnoreCase(idPersonita) < 0) {
					if(this.rigth != null) {
					encon = this.rigth.searchSpectator1(idPersonita);
					}
			}else {
					if(this.left != null) {
					encon = this.left.searchSpectator1(idPersonita);
					}
			}
		}
		return encon;
	}
	
	public String searchSpectator3(String idPersonita) throws notFoundPersonError {
		String msj = "";
		
		if(idPerson.compareToIgnoreCase(idPersonita) == 0) {
			return this.toString();
		}else  if(idPerson.compareToIgnoreCase(idPersonita) < 0) {
					if(this.rigth != null) {
						msj = this.rigth.searchSpectator3(idPersonita);
					}
			}else if(idPerson.compareToIgnoreCase(idPersonita) > 0) {
					if(this.left != null) {
						msj = this.left.searchSpectator3(idPersonita);
					}
			}
	
		return msj;
	}

}
