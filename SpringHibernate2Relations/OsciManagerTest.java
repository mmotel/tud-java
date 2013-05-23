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

import com.example.shdemo.domain.ro.Osc;
import com.example.shdemo.domain.ro.Ryba;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class OsciManagerTest {
	
	private final String RYBA_NAZWA_1 = "Ryba1";
	private final String RYBA_GATUNEK_1 = "Gatunek1";
	
	private final String OSC_NAZWA_1 = "Osc1";
	private final String OSC_NAZWA_1_EDYCJA = "Osc1 edycja";
	private final Integer OSC_DLUGOSC_1 = 10;
	private final Integer OSC_DLUGOSC_1_EDYCJA = 13;
	private final String OSC_NAZWA_2 = "Osc2";
	private final Integer OSC_DLUGOSC_2 = 12;
	
	@Autowired
	IRybyManager rm;
	
	@Autowired
	IOsciManager om;
	
	@Test
	public void checkAddOsc(){
		Osc o1 = new Osc(OSC_NAZWA_1, OSC_DLUGOSC_1);
		om.addOsc(o1);
		
		Osc OscRetrived = om.getOscById(o1);
		assertEquals(o1.getId(), OscRetrived.getId());
		assertEquals(OSC_NAZWA_1, OscRetrived.getNazwa());
		assertEquals(OSC_DLUGOSC_1, OscRetrived.getDlugosc());
	}

	@Test
	public void checkRmOsc(){
		Osc o1 = new Osc(OSC_NAZWA_1, OSC_DLUGOSC_1);
		om.addOsc(o1);
		
		Osc OscRetrived = om.getOscById(o1);
		assertEquals(o1.getId(), OscRetrived.getId());
		assertEquals(OSC_NAZWA_1, OscRetrived.getNazwa());
		assertEquals(OSC_DLUGOSC_1, OscRetrived.getDlugosc());
		
		Osc o2 = new Osc(OSC_NAZWA_2, OSC_DLUGOSC_2);
		om.addOsc(o2);
		
		Osc OscRetrived2 = om.getOscById(o2);
		assertEquals(o2.getId(), OscRetrived2.getId());
		assertEquals(OSC_NAZWA_2, OscRetrived2.getNazwa());
		assertEquals(OSC_DLUGOSC_2, OscRetrived2.getDlugosc());
		
		om.rmOsc(o1);
		
		assertNull(om.getOscById(o1));
		
		Osc OscRetrived3 = om.getOscById(OscRetrived2);
		assertEquals(OscRetrived2.getId(), OscRetrived3.getId());
		assertEquals(OSC_NAZWA_2, OscRetrived3.getNazwa());
		assertEquals(OSC_DLUGOSC_2, OscRetrived3.getDlugosc());
	}

	@Test
	public void checkEditOsc(){
		Osc o1 = new Osc(OSC_NAZWA_1, OSC_DLUGOSC_1);
		om.addOsc(o1);
		
		Osc OscRetrived = om.getOscById(o1);
		assertEquals(o1.getId(), OscRetrived.getId());
		assertEquals(OSC_NAZWA_1, OscRetrived.getNazwa());
		assertEquals(OSC_DLUGOSC_1, OscRetrived.getDlugosc());
		
		Osc o2 = new Osc(OSC_NAZWA_2, OSC_DLUGOSC_2);
		om.addOsc(o2);
		
		Osc OscRetrived2 = om.getOscById(o2);
		assertEquals(o2.getId(), OscRetrived2.getId());
		assertEquals(OSC_NAZWA_2, OscRetrived2.getNazwa());
		assertEquals(OSC_DLUGOSC_2, OscRetrived2.getDlugosc());
		
		OscRetrived.setNazwa(OSC_NAZWA_1_EDYCJA);
		OscRetrived.setDlugosc(OSC_DLUGOSC_1_EDYCJA);
		
		om.editOsc(OscRetrived);
		
		Osc OscRetrived3 = om.getOscById(OscRetrived);
		assertEquals(OscRetrived.getId(), OscRetrived3.getId());
		assertEquals(OSC_NAZWA_1_EDYCJA, OscRetrived3.getNazwa());
		assertEquals(OSC_DLUGOSC_1_EDYCJA, OscRetrived3.getDlugosc());
		
		Osc OscRetrived4 = om.getOscById(OscRetrived2);
		assertEquals(OscRetrived2.getId(), OscRetrived4.getId());
		assertEquals(OSC_NAZWA_2, OscRetrived4.getNazwa());
		assertEquals(OSC_DLUGOSC_2, OscRetrived4.getDlugosc());
	}

	@Test
	public void checkGetAllOsci(){
		Osc o1 = new Osc(OSC_NAZWA_1, OSC_DLUGOSC_1);
		om.addOsc(o1);
		
		Osc OscRetrived = om.getOscById(o1);
		assertEquals(o1.getId(), OscRetrived.getId());
		assertEquals(OSC_NAZWA_1, OscRetrived.getNazwa());
		assertEquals(OSC_DLUGOSC_1, OscRetrived.getDlugosc());
		
		Osc o2 = new Osc(OSC_NAZWA_2, OSC_DLUGOSC_2);
		om.addOsc(o2);
		
		Osc OscRetrived2 = om.getOscById(o2);
		assertEquals(o2.getId(), OscRetrived2.getId());
		assertEquals(OSC_NAZWA_2, OscRetrived2.getNazwa());
		assertEquals(OSC_DLUGOSC_2, OscRetrived2.getDlugosc());
		
		List<Osc> osci = om.getAllOsci();
		
		assertNotSame(0, osci.size());
		assertNotSame(1, osci.size());
		
		for(Osc o : osci){
			Osc osc = om.getOscById(o);
			assertEquals(o.getId(), osc.getId());
			assertEquals(o.getNazwa(), osc.getNazwa());
			assertEquals(o.getDlugosc(), osc.getDlugosc());
		}
	}

	@Test
	public void checkGetOsciByRyba(){
		Osc o1 = new Osc(OSC_NAZWA_1, OSC_DLUGOSC_1);
		om.addOsc(o1);
		
		Osc OscRetrived = om.getOscById(o1);
		assertEquals(o1.getId(), OscRetrived.getId());
		assertEquals(OSC_NAZWA_1, OscRetrived.getNazwa());
		assertEquals(OSC_DLUGOSC_1, OscRetrived.getDlugosc());
		
		Ryba r1 = new Ryba(RYBA_NAZWA_1, RYBA_GATUNEK_1);
		rm.addRyba(r1);
		
		Ryba rybaRetrived = rm.getRybaById(r1);
		assertEquals(r1.getId(), rybaRetrived.getId());
		assertEquals(RYBA_NAZWA_1, rybaRetrived.getNazwa());
		assertEquals(RYBA_GATUNEK_1, rybaRetrived.getGatunek());
		
		om.addOscToRyba(OscRetrived, rybaRetrived);
		
		List<Osc> osciRyby = om.getOsciByRyba(rybaRetrived);
		
		assertNotSame(0, osciRyby.size());
		
		for(Osc o : osciRyby){
			Osc o2 = om.getOscById(o);
			assertEquals(o.getId(), o2.getId());
			assertEquals(o.getNazwa(), o2.getNazwa());
			assertEquals(o.getDlugosc(), o2.getDlugosc());
			
		}
	}

}

