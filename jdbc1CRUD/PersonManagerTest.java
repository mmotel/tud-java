package com.example.jdbcdemo.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.example.jdbcdemo.domain.Person;

public class PersonManagerTest {

	PersonManager personManager = new PersonManager();

	private final static String NAME_1 = "Zenek";
	private final static String NEW_NAME_1 = "Janek";
	private final static int YOB_1 = 1945;
	private final static int NEW_YOB_1 = 1978;
	private final static double WEIGHT_1 = 85;
	private final static double NEW_WEIGHT_1 = 95;
	
	
	private static final double DELTA = 1e-15;

	@Test
	public void checkConnection() {
		assertNotNull(personManager.getConnection());
	}

	@Test
	public void checkAdding() {

		Person person = new Person(NAME_1, YOB_1, WEIGHT_1);

		personManager.clearPersons();
		assertEquals(1, personManager.addPerson(person));

		List<Person> persons = personManager.getAllPersons();
		Person personRetrieved = persons.get(0);

		assertEquals(NAME_1, personRetrieved.getName());
		assertEquals(YOB_1, personRetrieved.getYob());
		assertEquals(WEIGHT_1, personRetrieved.getWeight(), DELTA);

	}

	@Test
	public void checkDelete() {

		Person person = new Person(NAME_1, YOB_1, WEIGHT_1);

		personManager.clearPersons();
		assertEquals(1, personManager.addPerson(person));

		List<Person> persons = personManager.getAllPersons();
		Person personRetrieved = persons.get(0);

		assertEquals(1, personManager.deletePerson(personRetrieved));

	}
	
	@Test
	public void checkUpdate(){
		Person person = new Person(NAME_1, YOB_1, WEIGHT_1);

		personManager.clearPersons();
		assertEquals(1, personManager.addPerson(person));

		List<Person> persons = personManager.getAllPersons();
		Person personRetrieved = persons.get(0);
		
		personRetrieved.setName(NEW_NAME_1);
		personRetrieved.setYob(NEW_YOB_1);
		personRetrieved.setWeight(NEW_WEIGHT_1);
		
		assertEquals(1,personManager.updatePerson(personRetrieved));
		
		List<Person> persons2 = personManager.getAllPersons();
		Person personRetrieved2 = persons2.get(0);
		
		assertEquals(NEW_NAME_1, personRetrieved2.getName());
		assertEquals(NEW_YOB_1, personRetrieved2.getYob());
		assertEquals(NEW_WEIGHT_1, personRetrieved2.getWeight(), DELTA);
		assertEquals(personRetrieved.getId(), personRetrieved2.getId());
	}

}
