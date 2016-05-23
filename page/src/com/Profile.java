package com;

public class Profile {
	private String name, surname, email;
	private int admin;
	public Profile(String name, String surname, String email,int admin){
		this.name=name;
		this.surname=surname;
		this.email=email;
		this.admin=admin;
	}
	public String getName(){
		return name;
	}
	public String getSurname(){
		return surname;
	}
	public String getEmail(){
		return email;
	}
	public int getAdmin(){
		return admin;
	}
}
