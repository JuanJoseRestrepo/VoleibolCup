package model;

import java.io.Serializable;

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
	
	public boolean searchSpectator1(String idPersonita) {
		boolean t = false;
		if(idPerson.compareToIgnoreCase(idPersonita) == 0) {
			return t = true;
		}else {
			if(idPerson.compareToIgnoreCase(idPersonita) < 0) {
				if(this.rigth != null) {
					this.rigth.searchSpectator1(idPersonita);
				}
			}else {
				if(this.left != null) {
					this.left.searchSpectator1(idPersonita);
				}
			}
		}
		return t;
	}
	

}
