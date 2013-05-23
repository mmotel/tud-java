package com.example.shdemo.domain.ro;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "Osc.getAll", query = "Select o from Osc o")
})
public class Osc {
	
	private Long id;
	
	private String nazwa;
	private Integer dlugosc;
	
	public Osc(){}
	
	public Osc(String Nazwa, Integer Dlugosc){
		this.nazwa = Nazwa;
		this.dlugosc = Dlugosc;
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
	public Integer getDlugosc() {
		return dlugosc;
	}
	public void setDlugosc(Integer dlugosc) {
		this.dlugosc = dlugosc;
	}
	
	

}
