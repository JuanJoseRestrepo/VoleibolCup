package model;

import java.awt.SecondaryLoop;
import java.io.Serializable;

public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String idPerson;
	protected String nameFirst;
	protected String nameLast;
	protected String email;
	protected String gender;
	protected String country;
	protected String photo;
	protected String birthDay;
	
	public Person(String idPerson, String nameFirst, String nameLast, String email, String gender, String country,
			String photo, String birthDay) {
		super();
		this.idPerson = idPerson;
		this.nameFirst = nameFirst;
		this.nameLast = nameLast;
		this.email = email;
		this.gender = gender;
		this.country = country;
		this.photo = photo;
		this.birthDay = birthDay;
	}

	public String getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(String idPerson) {
		this.idPerson = idPerson;
	}

	public String getNameFirst() {
		return nameFirst;
	}

	public void setNameFirst(String nameFirst) {
		this.nameFirst = nameFirst;
	}

	public String getNameLast() {
		return nameLast;
	}

	public void setNameLast(String nameLast) {
		this.nameLast = nameLast;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	
	public String toString() {
		String msj = " ";
		
		msj += "El id del person es:" + idPerson + "\n";
		msj += "El primer nombre es:" + nameFirst +"\n";
		msj += "El segundo nombre es:" + nameLast +"\n";
		msj += "El email es:" + email +"\n";
		msj += "El genero es:" + gender +"\n";
		msj += "El pais es:" + country +"\n";
		msj += "El cumpleaños es:" + birthDay +"\n";
		
		return msj;
	}
	
	
}
