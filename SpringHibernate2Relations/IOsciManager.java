package com.example.shdemo.service.ro;

import java.util.List;

import com.example.shdemo.domain.ro.Osc;
import com.example.shdemo.domain.ro.Ryba;

public interface IOsciManager {
	
	public void addOsc(Osc osc);
	
	public void rmOsc(Osc osc);
	
	public void editOsc(Osc osc);
	
	public Osc getOscById(Osc osc);
	
	public List<Osc> getAllOsci();
	
	public void addOscToRyba(Osc osc, Ryba ryba);
	
	public List<Osc> getOsciByRyba(Ryba ryba);

}
