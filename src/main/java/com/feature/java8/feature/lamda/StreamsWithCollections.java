package com.feature.java8.feature.lamda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.IntSupplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.sun.org.apache.xalan.internal.utils.XMLSecurityManager.Limit;

public class StreamsWithCollections {

	public static void main(String ary[]) {

		final List<Person> people = Arrays.asList(new Person("Charles", "Dickens", 60, true),
				new Person("Lewis", "Carroll", 42, false), new Person("Thomas", "Carlyle", 30, false),
				new Person("Charlotte", "Bronte", 10, true), new Person("Matthew", "Arnold", 30, true));

		people.stream().forEach(System.out::println);

		people.stream().forEach(p -> System.out.println(p.getName()));

		people.stream().filter(p -> p.getAge() > 9 && p.getAge() < 35).forEach(p -> System.out.println(p));

		people.stream().filter(p -> p.getName().startsWith("D")).collect(Collectors.toList());

	}

	/**
	 * Create, Process and Consume (CPC)
	 * 
	 * 
	 * @param people
	 * @throws IOException
	 */
	private static void testStreamsAsIntegerOrString(final List<Person> people) throws IOException {

		// Creating a stream
		IntStream.of(new int[] { 1, 2, 3, 4, 5 });
		IntStream.of(1, 101);
		IntStream.rangeClosed(1, 100);
		IntStream.generate(new IntSupplier() {
			@Override
			public int getAsInt() {
				return 0;
			}
		});

		System.out.println(IntStream.generate(() -> Integer.MAX_VALUE).findFirst());

		// Integer Stream
		IntStream.range(0, 10).forEach(System.out::println);

		// Integer stream with skip
		IntStream.range(1, 10).skip(5).forEach(p -> System.out.println(p));

		IntStream.range(1, 10).skip(5).forEach(System.out::println);

		IntStream.range(1, 100).toArray();

		// Convert into list
		List<Integer> list = IntStream.range(1, 100).boxed().collect(Collectors.toList());

		// is any number odd
		boolean isOdd = IntStream.range(1, 100).anyMatch(p -> p % 2 == 1);
		// are all number odd
		boolean isAllOdd = IntStream.range(1, 100).allMatch(p -> p % 2 == 1);

		// Integer stream with sum
		System.out.println(IntStream.range(1, 5).sum());

		// Integer stream get the min / max / average/ count/ sum validate with
		// ifPresent
		System.out.println(IntStream.of(10, 20, 1, 5, 99, 4).min().getAsInt());
		IntStream.of(10, 20, 1, 5, 99, 4).min().ifPresent(p -> System.out.println(p));
		IntStream.of(10, 20, 1, 5, 99, 4).min().ifPresent(System.out::println);
		IntStream.of(10, 20, 1, 5, 99, 4).max().ifPresent(System.out::println);
		IntStream.of(10, 20, 1, 5, 99, 4).average().ifPresent(System.out::println);
		System.out.println(IntStream.of(10, 20, 1, 5, 99, 4).count());
		System.out.println(IntStream.of(10, 20, 1, 5, 99, 4).sum());

		// Or
		IntSummaryStatistics statistics = IntStream.of(10, 20, 1, 5, 99, 4).summaryStatistics();
		System.out.println(statistics.getCount());
		System.out.println(statistics.getMin());
		System.out.println(statistics.getMax());
		System.out.println(statistics.getAverage());
		System.out.println(statistics.getSum());

		// find 3 distinct smallest numbers from an array of int
		IntStream.of(4, 1, 13, 90, 16, 2, 0, 6).distinct().sorted().limit(3).forEach(System.out::println);

		System.out.println(IntStream.of(4, 1, 13, 90, 16, 2, 0, 6).sorted().limit(3).sum());

		// Stream.of, sorted and findFirst
		Stream.of("Ava", "Aneri", "Akberto").sorted().findFirst().ifPresent(System.out::println);

		// Stream from Array, sort, filter and print
		String[] array = { "AI", "BI", "CI", "DI", "ID", "IA", "IB", "IC" };

		Stream.of(array).filter(p -> p.startsWith("I")).sorted().forEach(System.out::println);

		Arrays.stream(array).filter(p -> p.startsWith("I")).sorted().forEach(System.out::println);

		// Average of squares of an int array
		Arrays.stream(new int[] { 2, 4, 6, 8, 1 }).map(p -> p * p).average().ifPresent(System.out::println);

		// Stream from list, filter and print
		Stream.of("Ava", "Aneri", "Akberto").map(String::toLowerCase).filter(p -> p.startsWith("a"))
				.forEach(System.out::println);

		// Stream rows form text file, sort, filter and print

		Stream<String> bandOne = Files.lines(Paths.get("bands.txt"));

		bandOne.sorted().filter(p -> p.length() > 13).forEach(System.out::println);
		bandOne.close();

		// Stream rows from text file and save to list

		Stream<String> bandTwo = Files.lines(Paths.get("bands.txt"));

		List<String> returnedList = bandTwo.filter(p -> p.contains("Ava")).collect(Collectors.toList());

		returnedList.forEach(System.out::println);
		bandTwo.close();

		// Stream rows from CVS and count
		Stream<String> bandThree = Files.lines(Paths.get("bands.txt"));

		int rowCount = (int) bandThree.map(p -> p.split(",")).filter(p -> p.length == 3).count();

		System.out.println(rowCount + " Rows ");
		bandThree.close();

		// Stream rows form CSV file, parse data from rows
		Stream<String> bandFour = Files.lines(Paths.get("bands.txt"));

		bandFour.map(p -> p.split(",")).filter(p -> p.length == 3).filter(p -> Integer.parseInt(p[1]) > 15)
				.forEach(x -> System.out.println(x[0] + " - " + x[1] + " " + x[2]));
		bandFour.close();

		/// Stream rows from CSV file, store fields in HashMap

		Stream<String> bandFive = Files.lines(Paths.get("bands.txt"));

		Map<String, Integer> map = bandFive.map(p -> p.split(",")).filter(p -> p.length == 3)
				.filter(p -> Integer.parseInt(p[1]) > 15)
				.collect(Collectors.toMap(p -> p[0], p -> Integer.parseInt(p[1])));

		bandFive.close();

		for (String key : map.keySet()) {
			System.out.println(key + ":" + map.get(key));
		}

		// Reduction - Sum
		double total = Stream.of(7.1, 2.5, 4.6).reduce(0.0, (Double a, Double b) -> a + b);
		System.out.println("Total : " + total);

		// Reduction - Summary Statistics
		IntSummaryStatistics summary = IntStream.of(7, 10, 12, 3, 6, 22, 88, 22, 11).summaryStatistics();
		System.out.println(summary);

	}

	private static void testStreamsAsObjects(final List<Person> people) throws IOException {

		// Sort descending by age
		final List<Person> clonePerson = new ArrayList<Person>(people);
		clonePerson.sort((objectOne, objectTwo) -> objectOne.getAge() - objectTwo.getAge());
		for (Person person : clonePerson) {
			System.out.println(person);
		}

		// Sort descending by age (pure in streams)
		clonePerson.stream().sorted(Comparator.comparingInt(Person::getAge).reversed()).limit(3).map(Person::getName)
				.forEach(System.out::println);

		// Sort descending only people who are active
		clonePerson.stream().sorted(Comparator.comparingInt(Person::getAge).reversed()).filter(p -> p.isActive())
				.limit(3).map(Person::getName).forEach(System.out::println);

		final List<String> personNames = clonePerson.stream().sorted(Comparator.comparingInt(Person::getAge).reversed())
				.filter(p -> p.isActive()).limit(3).map(Person::getName).collect(Collectors.toList());

		final Set<String> personNamesSet = clonePerson.stream()
				.sorted(Comparator.comparingInt(Person::getAge).reversed()).filter(p -> p.isActive()).limit(3)
				.map(Person::getName).collect(Collectors.toSet());

		// Need to verify --
		// Map<String, Person> personMap =
		// clonePerson.stream().sorted(Comparator.comparingInt(Person::getAge).reversed())
		// .filter(p -> p.isActive()).limit(3)
		// .collect(Collectors.toMap(p -> p.name, p -> p));

		// Map<String, Person> personMap =
		// clonePerson.stream().limit(3).collect(Collectors.toMap(e -> e.name, e -> e));

		// name with comas
		System.out.println(clonePerson.stream().limit(3).map(Person::getName).collect(Collectors.joining(",")));

		final Map<Object, List<Person>> personMapList = clonePerson.stream()
				.collect(Collectors.groupingBy(e -> e.getAge()));

		final Map<Object, Long> ageCounts = clonePerson.stream()
				.collect(Collectors.groupingBy(Person::getAge, Collectors.counting()));
		
		// Parallel streams
		final Map<Object, Long> ageCountsParallel = clonePerson.stream().parallel()
				.collect(Collectors.groupingBy(Person::getAge, Collectors.counting()));

	}
}
