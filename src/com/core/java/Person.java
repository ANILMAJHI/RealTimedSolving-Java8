package com.core.java;

import java.util.List;

public final class Person {

	private final int id;
	private final String name;
	private final int age;
	private final List<String> hubbies;

	
	public Person(int id, String name, int age, List<String> hubbies) {

		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.hubbies = hubbies;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public List<String> getHubbies() {
		return hubbies;
	}

}
