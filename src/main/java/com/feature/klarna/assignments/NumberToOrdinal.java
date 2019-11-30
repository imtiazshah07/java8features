package com.feature.klarna.assignments;

/**
 * 
 * 
 * 
 * Task Finish the function numberToOrdinal, which should take a number and
 * return it as a string with the correct ordinal indicator suffix (in English).
 * For example, 1 turns into "1st".
 * 
 * For the purposes of this challenge, you may assume that the function will
 * always be passed a non-negative integer. If the function is given 0 as an
 * argument, it should return '0' (as a string).
 * 
 * To help you get started, here is an excerpt from Wikipedia's page on Ordinal
 * Indicators:
 * 
 * st is used with numbers ending in 1 (e.g. 1st, pronounced first) nd is used
 * with numbers ending in 2 (e.g. 92nd, pronounced ninety-second) rd is used
 * with numbers ending in 3 (e.g. 33rd, pronounced thirty-third) As an exception
 * to the above rules, all the "teen" numbers ending with 11, 12 or 13 use -th
 * (e.g. 11th, pronounced eleventh, 112th, pronounced one hundred [and] twelfth)
 * th is used for all other numbers (e.g. 9th, pronounced ninth). Specification
 * Challenge.numberToOrdinal(number) take a number and return it as a string
 * with the correct ordinal indicator suffix (in English)
 * 
 * Parameters number: Integer - The number to be converted to a string ordinal
 * 
 * Return Value String - Returns a string ordinal based off of the number.
 * 
 * Constraints 0 ≤ number ≤ 10000
 * 
 * Examples number Return Value 1 "1st" 2 "2nd" 3 "3rd" 4 "4th" 21 "21st"
 *
 */
public class NumberToOrdinal {
	public static void main(String[] args) {
		System.out.println(NumberToOrdinal.numberToOrdinal(1));
	}

	public static String numberToOrdinal(Integer number) {

		return null;
	}

	public static String numberToOrdinalSwitch(Integer number) {

		// Added constraints
		if (number <= 0 || number >= 10000) {
			return number.toString();
		} else if (number % 100 == 11 || number % 100 == 12 || number % 100 == 13) {
			return String.format("%dth", number);
		}

		switch (number % 10) {
		case 1:
			return String.format("%dst", number);
		case 2:
			return String.format("%dnd", number);
		case 3:
			return String.format("%drd", number);
		default:
			return String.format("%dth", number);
		}

	}

	public static String numberToOrdinalIf(Integer number) {

		// Added constraints
		if (number <= 0 || number >= 10000) {
			return number.toString();
		}
		// Added Exception
		if (number % 100 == 11 || number % 100 == 12 || number % 100 == 13) {
			return String.format("%dth", number);
		}

		if (number % 10 == 1)
			return String.format("%dst", number);
		else if (number % 10 == 2)
			return String.format("%dnd", number);
		else if (number % 10 == 3)
			return String.format("%drd", number);
		else
			return String.format("%dth", number);

	}

}
