package com.feature.java8.feature.lamda;

import java.util.function.BiConsumer;

public class ExceptionHandling {

	public static void main(String[] args) {
		int[] someNumbers = { 1, 2, 3, 4 };
		int key = 2;

		process(someNumbers, key, wrapperLamda((v, k) -> System.out.println(k / v)));
	}

	private static void process(int[] someNumbers, int key, BiConsumer<Integer, Integer> consumer) {
		for (int i : someNumbers) {
			consumer.accept(i, key);
		}
	}

	private static BiConsumer<Integer, Integer> wrapperLamda(BiConsumer<Integer, Integer> consumer) {
		return (v, k) -> {
			try {
				consumer.accept(v, k);
			} catch (final ArithmeticException exception) {
				System.out.println("Exception caught in wrapper lamda.");
			}
		};
	}
}
