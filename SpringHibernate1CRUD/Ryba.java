package com.example.shdemo.domain.ro;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
		@NamedQuery(name = "Ryba.getAll", query ="SELECT r FROM Ryba r"),
		@NamedQuery(name = "Ryba.rmAll", query = "DELETE FROM Ryba r")
})
public class Ryba {
	
	private Long id;
	
	private String nazwa;
	private String gatunek;
	
	public Ryba() {}
	
	public Ryba(String Nazwa, String Gatunek) {
		this.nazwa = Nazwa;
		this.gatunek = Gatunek;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	
	

}
