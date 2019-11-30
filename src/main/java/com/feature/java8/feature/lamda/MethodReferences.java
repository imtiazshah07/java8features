package com.feature.java8.feature.lamda;

public class MethodReferences {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Thread threadOne = new Thread(new Runnable() {
			@Override
			public void run() {
				print();

			}
		});
		threadOne.start();

		Thread threadTwo = new Thread(() -> print());
		threadTwo.start();
		
		// Method Reference expression.
		Thread threadThree = new Thread(MethodReferences::print);
		threadThree.start();

		
	}

	public static void print() {
		System.out.println("Hello");
	}
}
