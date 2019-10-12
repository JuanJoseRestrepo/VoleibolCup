package model;

import java.io.Serializable;

public class Competitor extends Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Competitor previous;
	private Competitor next;

	public Competitor(String idPerson, String nameFirst, String nameLast, String email, String gender, String country,
			String photo, String birthDay) {
		super(idPerson, nameFirst, nameLast, email, gender, country, photo, birthDay);
	}

	public Competitor getPrevious() {
		return previous;
	}

	public void setPrevious(Competitor previous) {
		this.previous = previous;
	}

	public Competitor getNext() {
		return next;
	}

	public void setNext(Competitor next) {
		this.next = next;
	}

	
	
	
}
