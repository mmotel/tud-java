package com.example.shdemo.service.ro;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.example.shdemo.domain.ro.Ryba;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class RybyOsciManagersTest {
	
	private final String RYBA_NAZWA_1 = "Ryba1";
	private final String RYBA_GATUNEK_1 = "Gatunek1";
	
	@Autowired
	IRybyManager rm;
	
	@Test
	public void checkAddRyba(){
		
		Ryba r1 = new Ryba(RYBA_NAZWA_1, RYBA_GATUNEK_1);
		rm.rmAllRyby();
		rm.addRyba(r1);
		
		Ryba rybaRetrived = rm.getRybaById(r1);
		assertEquals(r1.getId(), rybaRetrived.getId());
		assertEquals(RYBA_NAZWA_1, rybaRetrived.getNazwa());
		assertEquals(RYBA_GATUNEK_1, rybaRetrived.getGatunek());
	}
	
	@Test
	public void checkRmRyba(){
		
		Ryba r1 = new Ryba(RYBA_NAZWA_1, RYBA_GATUNEK_1);
		rm.rmAllRyby();
		rm.addRyba(r1);
		
		Ryba rybaRetrived = rm.getRybaById(r1);
		assertEquals(r1.getId(), rybaRetrived.getId());
		assertEquals(RYBA_NAZWA_1, rybaRetrived.getNazwa());
		assertEquals(RYBA_GATUNEK_1, rybaRetrived.getGatunek());
		
		Ryba r2 = new Ryba(RYBA_NAZWA_1+'2', RYBA_GATUNEK_1+'2');
		rm.addRyba(r2);
		
		Ryba rybaRetrived2 = rm.getRybaById(r2);
		assertEquals(r2.getId(), rybaRetrived2.getId());
		assertEquals(RYBA_NAZWA_1+'2', rybaRetrived2.getNazwa());
		assertEquals(RYBA_GATUNEK_1+'2', rybaRetrived2.getGatunek());
		
		rm.rmRyba(r1);
		
		assertNull(rm.getRybaById(rybaRetrived));
		
		Ryba rybaRetrived3 = rm.getRybaById(r2);
		assertEquals(rybaRetrived2.getId(), rybaRetrived3.getId());
		assertEquals(RYBA_NAZWA_1+'2', rybaRetrived3.getNazwa());
		assertEquals(RYBA_GATUNEK_1+'2', rybaRetrived3.getGatunek());
	}
	
	@Test
	public void checkEditRyba(){
		
		Ryba r1 = new Ryba(RYBA_NAZWA_1, RYBA_GATUNEK_1);
		rm.rmAllRyby();
		rm.addRyba(r1);
		
		Ryba rybaRetrived = rm.getRybaById(r1);
		assertEquals(r1.getId(), rybaRetrived.getId());
		assertEquals(RYBA_NAZWA_1, rybaRetrived.getNazwa());
		assertEquals(RYBA_GATUNEK_1, rybaRetrived.getGatunek());
		
		Ryba r2 = new Ryba(RYBA_NAZWA_1+'2', RYBA_GATUNEK_1+'2');
		rm.addRyba(r2);
		
		Ryba rybaRetrived2 = rm.getRybaById(r2);
		assertEquals(r2.getId(), rybaRetrived2.getId());
		assertEquals(RYBA_NAZWA_1+'2', rybaRetrived2.getNazwa());
		assertEquals(RYBA_GATUNEK_1+'2', rybaRetrived2.getGatunek());
		
		rybaRetrived.setNazwa(RYBA_NAZWA_1+"edycja");
		rybaRetrived.setGatunek(RYBA_GATUNEK_1+"edycja");
		
		rm.editRyba(rybaRetrived);
		
		Ryba rybaRetrived3 = rm.getRybaById(rybaRetrived);
		
		assertEquals(rybaRetrived.getId(), rybaRetrived3.getId());
		assertEquals(RYBA_NAZWA_1+"edycja", rybaRetrived3.getNazwa());
		assertEquals(RYBA_GATUNEK_1+"edycja", rybaRetrived3.getGatunek());
		
		Ryba rybaRetrived4 = rm.getRybaById(rybaRetrived2);
		assertEquals(rybaRetrived2.getId(), rybaRetrived4.getId());
		assertEquals(RYBA_NAZWA_1+'2', rybaRetrived4.getNazwa());
		assertEquals(RYBA_GATUNEK_1+'2', rybaRetrived4.getGatunek());
		
	}

	@Test
	public void checkGetAllRyby(){
		
		Ryba r1 = new Ryba(RYBA_NAZWA_1, RYBA_GATUNEK_1);
		rm.rmAllRyby();
		rm.addRyba(r1);
		
		Ryba rybaRetrived = rm.getRybaById(r1);
		assertEquals(r1.getId(), rybaRetrived.getId());
		assertEquals(RYBA_NAZWA_1, rybaRetrived.getNazwa());
		assertEquals(RYBA_GATUNEK_1, rybaRetrived.getGatunek());
		
		Ryba r2 = new Ryba(RYBA_NAZWA_1+'2', RYBA_GATUNEK_1+'2');
		rm.addRyba(r2);
		
		Ryba rybaRetrived2 = rm.getRybaById(r2);
		assertEquals(r2.getId(), rybaRetrived2.getId());
		assertEquals(RYBA_NAZWA_1+'2', rybaRetrived2.getNazwa());
		assertEquals(RYBA_GATUNEK_1+'2', rybaRetrived2.getGatunek());
		
		List<Ryba> ryby = rm.getAllRyby();
		
		assertEquals(2, ryby.size());
		
		for(Ryba r : ryby){
			Ryba r3 = rm.getRybaById(r);
			assertEquals(r.getId(), r3.getId());
			assertEquals(r.getNazwa(), r3.getNazwa());
			assertEquals(r.getGatunek(), r3.getGatunek());
		}
		
	}
}
