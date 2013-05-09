package com.example.jdbcdemo.domain;

public class Osci {

	private long id;
	
	private String nazwa;
	private Double dlugosc;
	private Double grubosc;
	
	private long ryba_id;
	
	public Osci(){}
	
	public Osci(String nazwa, Double dlugosc, Double grubosc){
		super();
		this.nazwa = nazwa;
		this.dlugosc = dlugosc;
		this.grubosc = grubosc;
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

	public Double getDlugosc() {
		return dlugosc;
	}

	public void setDlugosc(Double dlugosc) {
		this.dlugosc = dlugosc;
	}

	public Double getGrubosc() {
		return grubosc;
	}

	public void setGrubosc(Double grubosc) {
		this.grubosc = grubosc;
	}

	public long getRyba_id() {
		return ryba_id;
	}

	public void setRyba_id(long ryba_id) {
		this.ryba_id = ryba_id;
	}
	
	
}
