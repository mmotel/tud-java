package com.example.jdbcdemo.domain;

public class Person {
	
	private long id;
	
	private String name;
	private int yob;
	private double weight;
	
	public Person() {
	}
	
	public Person(String name, int yob, double weight) {
		super();
		this.name = name;
		this.yob = yob;
		this.weight = weight;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYob() {
		return yob;
	}
	public void setYob(int yob) {
		this.yob = yob;
	}

	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	
}
