package com.example.jdbcdemo.domain;

public class Ryby {
	
	private long id;
	
	private String nazwa;
	private String gatunek;
	private Integer rok_urodzenia;
	
	public Ryby(){}
	
	public Ryby(String nazwa, String gatunek, Integer rok_urodzenia){
		super();
		this.nazwa = nazwa;
		this.gatunek = gatunek;
		this.rok_urodzenia = rok_urodzenia;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getGatunek() {
		return gatunek;
	}

	public void setGatunek(String gatunek) {
		this.gatunek = gatunek;
	}

	public Integer getRok_urodzenia() {
		return rok_urodzenia;
	}
	public void setRok_urodzenia(Integer rok_urodzenia) {
		this.rok_urodzenia = rok_urodzenia;
	}
	
	

}
