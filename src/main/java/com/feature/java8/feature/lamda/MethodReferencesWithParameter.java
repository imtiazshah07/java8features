package com.feature.java8.feature.lamda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MethodReferencesWithParameter {
	public static void main(String[] args) {
		final List<Person> people = Arrays.asList(new Person("Charles", "Dickens", 60,true),
				new Person("Lewis", "Carroll", 42,false), new Person("Thomas", "Carlyle", 30,false),
				new Person("Charlotte", "Bronte", 10,true), new Person("Matthew", "Arnold", 30,true));

		printList(people, p -> true, p -> System.out.println(p));
		
		//Similar as method refence
		printList(people, p -> true, System.out::println);

	}

	private static void printList(final List<Person> peoples, final Predicate<Person> predicate,
			final Consumer<Person> consumer) {
		for (Person p : peoples) {
			if (predicate.test(p)) {
				consumer.accept(p);
			}
		}
		System.out.println("*******************************");
	}
}
