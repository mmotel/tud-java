package com.example.jdbcdemo.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.example.jdbcdemo.domain.Osci;
import com.example.jdbcdemo.domain.Ryby;

public class OsciRybyManagerTest {

	// ość
	private final static String NAZWA_1 = "Bekarty Wojny";
	private final static Double DLUGOSC_1 = 10.9;
	private final static Double GRUBOSC_1 = 1.2;

	// ryba
	private final static String RNAZWA_1 = "Karp";
	private final static String GATUNEK_1 = "Karpiowata";
	private final static Integer ROK_URODZ_1 = 2011;

	private static final double DELTA = 1e-15;

	OsciManager om = new OsciManager();
	RybyManager rm = new RybyManager();

	@Test
	public void checkConnection() {
		assertNotNull(om.getConnection());
	}

	@Test
	public void checkAddOsci() {

		Osci o = new Osci(NAZWA_1, DLUGOSC_1, GRUBOSC_1);

		om.clearOsci();
		assertEquals(1, om.addOsci(o));

		List<Osci> oscis = om.getAllOsci();
		Osci osciRetrived = oscis.get(0);

		assertEquals(NAZWA_1, osciRetrived.getNazwa());
		assertEquals(DLUGOSC_1, osciRetrived.getDlugosc(), DELTA);
		assertEquals(GRUBOSC_1, osciRetrived.getGrubosc(), DELTA);

	}

	@Test
	public void checkAddRyba() {

		Ryby r = new Ryby(RNAZWA_1, GATUNEK_1, ROK_URODZ_1);

		rm.clearRyby();
		assertEquals(1, rm.addRyby(r));

		List<Ryby> rybys = rm.getAllRyby();

		Ryby rybyRetrived = rybys.get(0);

		assertEquals(RNAZWA_1, rybyRetrived.getNazwa());
		assertEquals(GATUNEK_1, rybyRetrived.getGatunek());
		assertEquals(ROK_URODZ_1, rybyRetrived.getRok_urodzenia());

	}

	@Test
	public void checkOsciToRyba() {
		// add ryba
		Ryby r = new Ryby(RNAZWA_1, GATUNEK_1, ROK_URODZ_1);
		rm.clearRyby();
		assertEquals(1, rm.addRyby(r));
		List<Ryby> rybys = rm.getAllRyby();
		Ryby rybyRetrived = rybys.get(0);
		// add osci
		Osci o = new Osci(NAZWA_1, DLUGOSC_1, GRUBOSC_1);
		om.clearOsci();
		assertEquals(1, om.addOsci(o));
		List<Osci> oscis = om.getAllOsci();
		Osci osciRetrived = oscis.get(0);
		// do test
		assertEquals(1, om.addOsciToRyba(osciRetrived, rybyRetrived));
		Osci OsciRetrived2 = om.getOsciById(osciRetrived);
		assertEquals(rybyRetrived.getId(), OsciRetrived2.getRyba_id());
	}

	@Test
	public void checkRemoveRybaFromOsci() {
		// add ryba
		Ryby r = new Ryby(RNAZWA_1, GATUNEK_1, ROK_URODZ_1);
		rm.clearRyby();
		assertEquals(1, rm.addRyby(r));
		List<Ryby> rybys = rm.getAllRyby();
		Ryby rybyRetrived = rybys.get(0);
		// add osci
		Osci o = new Osci(NAZWA_1, DLUGOSC_1, GRUBOSC_1);
		om.clearOsci();
		assertEquals(1, om.addOsci(o));
		List<Osci> oscis = om.getAllOsci();
		Osci osciRetrived = oscis.get(0);
		// do test
		assertEquals(1, om.addOsciToRyba(osciRetrived, rybyRetrived));
		Osci OsciRetrived2 = om.getOsciById(osciRetrived);
		assertEquals(rybyRetrived.getId(), OsciRetrived2.getRyba_id());

		assertEquals(1, om.removeRybaFromOsci(OsciRetrived2));

		Osci osciRetrived2 = om.getOsciById(OsciRetrived2);

		assertEquals(0, osciRetrived2.getRyba_id());
	}

	@Test
	public void checkGetOsciByRyba() {
		// add ryba
		Ryby r = new Ryby(RNAZWA_1, GATUNEK_1, ROK_URODZ_1);
		rm.clearRyby();
		assertEquals(1, rm.addRyby(r));
		List<Ryby> rybys = rm.getAllRyby();
		Ryby rybyRetrived = rybys.get(0);
		// add osci
		Osci o = new Osci(NAZWA_1, DLUGOSC_1, GRUBOSC_1);
		om.clearOsci();
		assertEquals(1, om.addOsci(o));
		List<Osci> oscis = om.getAllOsci();
		Osci osciRetrived = oscis.get(0);
		// add osci to ryba
		assertEquals(1, om.addOsciToRyba(osciRetrived, rybyRetrived));
		// get ryba's osci
		List<Osci> rybaOsci = om.getOsciByRyba(rybyRetrived);
		Osci rybaOsciRetrived = rybaOsci.get(0);
		// do tests
		assertEquals(osciRetrived.getId(), rybaOsciRetrived.getId());
		assertEquals(NAZWA_1, rybaOsciRetrived.getNazwa());
		assertEquals(DLUGOSC_1, osciRetrived.getDlugosc(), DELTA);
		assertEquals(GRUBOSC_1, osciRetrived.getGrubosc(), DELTA);
	}
}
