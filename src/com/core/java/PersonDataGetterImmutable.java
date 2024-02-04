package com.core.java;

import java.util.ArrayList;
import java.util.List;

public class PersonDataGetterImmutable {

	public static void main(String[] args) {
		
		List<String> hubbies=new ArrayList<String>();
		hubbies.add("Watching TV");
		hubbies.add("Playing Games");
		
		Person person=new Person(1, "Honi", 12, hubbies);
		System.out.println("Id :"+person.getId());
		System.out.println("Name :"+person.getName());
		System.out.println("Age :"+person.getAge());
		System.out.println("Hubbies :"+person.getHubbies());
		
				
	}
}
