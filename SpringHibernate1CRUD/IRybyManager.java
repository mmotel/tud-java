package com.example.shdemo.service.ro;

import java.util.List;

import com.example.shdemo.domain.ro.Ryba;

public interface IRybyManager {
	
	public void addRyba(Ryba ryba);
	
	public void rmRyba(Ryba ryba);
	
	public void editRyba(Ryba ryba);
	
	public Ryba getRybaById(Ryba rybaRetrived);
	
	public List<Ryba> getAllRyby();
	
	public void rmAllRyby();

}
