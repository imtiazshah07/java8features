package com.feature.java8.feature.lamda;

import java.util.Arrays;
import java.util.List;

public class ForEachIteration {

	public static void main(String ary[]) {
		final List<Person> people = Arrays.asList(new Person("Charles", "Dickens", 60,true),
				new Person("Lewis", "Carroll", 42,false), new Person("Thomas", "Carlyle", 30,false),
				new Person("Charlotte", "Bronte", 10,true), new Person("Matthew", "Arnold", 30,true));

		// External Iterator
		for (int i = 0; i < people.size(); i++) {
			System.out.println(people.get(i));
		}
		// External Iterator
		for (Person p : people) {
			System.out.println(p);
		}
		
		// Internal Iterators
		people.forEach(System.out::println);
		
		people.forEach(p -> System.out.println(p));
		
	}

}
