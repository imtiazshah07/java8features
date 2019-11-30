package com.feature.java8.feature.lamda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class StandardFunctionalInterfacesExample {

	public static void main(String[] args) {
		final List<Person> people = Arrays.asList(new Person("Charles", "Dickens", 60),
				new Person("Lewis", "Carroll", 42), new Person("Thomas", "Carlyle", 30),
				new Person("Charlotte", "Bronte", 10), new Person("Matthew", "Arnold", 30));

		printList(people, p -> true, p -> System.out.println(p.hashCode()));

		printList(people, p -> true, p -> System.out.println(p.getName()));
		
		printList(people, p -> p.getName().startsWith("C"), p -> System.out.println(p));

		printList(people, p -> p.getLastName().startsWith("C"), p -> System.out.println(p));

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
