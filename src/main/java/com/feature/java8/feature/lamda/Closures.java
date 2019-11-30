package com.feature.java8.feature.lamda;

public class Closures {

	public static void main(String[] args) {
		int a = 10;
		int b = 20;

		// Closures without lamda
		doProcess(a, new Process() {

			// Syntax error on token "b", VariableDeclaratorId expected after this token
			// b = 20;
			@Override
			public void process(int i) {
				System.out.println(i + b);
			}
		});

		// Closures with Lamda
		doProcess(a, i -> System.out.println(i + b));
	}

	public static void doProcess(int i, Process p) {
		p.process(i);
	}
}

interface Process {
	void process(int i);
}