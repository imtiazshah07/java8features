package com.feature.java8.feature.lamda;

public class ThisReference {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Cannot use this in a static context
		// System.out.println(this);

		ThisReference thisRef = new ThisReference();
		thisRef.doProcess(10, new Process() {

			@Override
			public void process(int i) {
				System.out.println(" Value :" + i);
				System.out.println(this);
			}

			public String toString() {
				return "This is the anonymous inner class.";
			}
		});

		thisRef.doProcess(10, i -> {
			System.out.println(" Value :" + i);
			// Cannot use this in a static context
			// System.out.println(this);
		});

		thisRef.exectue();
	}

	public void exectue() {
		doProcess(10, i -> {
			System.out.println(" Value :" + i);
			System.out.println(this);
		});
	}

	public void doProcess(int i, final Process p) {
		p.process(i);
	}

	public String toString() {
		return "This is the main ThisReference class instance.";
	}
}
