package com.feature.java8.assignments;

/**
 * 
 * Task Usually when you buy something, you're asked whether your credit card
 * number, phone number or answer to your most secret question is still correct.
 * However, since someone could look over your shoulder, you don't want that
 * shown on your screen. Instead, we mask it.
 * 
 * Your task is to write a function maskify, which will:
 * 
 * Mask all digits (0-9) with #, unless they are first or last four characters.
 * Never mask credit cards with less than 6 characters.
 * 
 * Never mask non-digit characters. Examples Input Output Comments
 * "4556364607935616" "4###########5616" "4556-3646-0793-5616"
 * "4###-####-####-5616" "64607935616" "6######5616" ABCD-EFGH-IJKLM-NOPQ
 * ABCD-EFGH-IJKLM-NOPQ A1234567BCDEFG89HI A#######BCDEFG89HI "12345" "12345" No
 * #s if less than 6 characters "" "" Make sure to handle empty strings "Skippy"
 * "Skippy" Documentation maskify(cc) Parameters: cc: String A string of any
 * characters.
 * 
 * Guaranteed Constraints: The input string will never be null or undefined.
 * Returns: String The input string with all but the first and last four
 * characters replaced with '#'.
 */
public class MaskCreditCard {

	public static void main(String[] args) {
		System.out.println(String.format("Parameter: %s , Result: %s", "4556364607935616",
				MaskCreditCard.maskify("4556364607935616")));
		System.out.println(String.format("Parameter: %s , Result: %s", "4556-3646-0793-5616",
				MaskCreditCard.maskify("4556-3646-0793-5616")));
		System.out.println(String.format("Parameter: %s , Result: %s", "ABCD-EFGH-IJKLM-NOPQ",
				MaskCreditCard.maskify("ABCD-EFGH-IJKLM-NOPQ")));

		System.out.println(String.format("Parameter: %s , Result: %s", "A1234567BCDEFG89HI",
				MaskCreditCard.maskify("A1234567BCDEFG89HI")));
		System.out.println(
				String.format("Parameter: %s , Result: %s", "54321", MaskCreditCard.maskify("54321")));

		System.out.println(String.format("Parameter: %s , Result: %s", "", MaskCreditCard.maskify("")));
	}

	/**
	 * 
	 * @param creditCardNumber
	 * @return
	 */
	public static String maskify(final String creditCardNumber) {
		if (creditCardNumber == null || creditCardNumber.isEmpty() || creditCardNumber.length() < 6) {
			return creditCardNumber;
		}

		StringBuilder result = new StringBuilder();
		int length = creditCardNumber.length() - 4;
		String subString = creditCardNumber.substring(1, length);
		result.append(creditCardNumber.charAt(0) + subString.replaceAll("[0-9]", "#") + creditCardNumber.substring(length));
		return result.toString();
	}

	/**
	 * 
	 * @param creditCardNumber
	 * @return
	 */
	public static String maskWithLoop(final String creditCardNumber) {
		if (creditCardNumber == null || creditCardNumber.isEmpty() || creditCardNumber.length() < 6) {
			return creditCardNumber;
		}

		final StringBuilder maskedCreditCard = new StringBuilder();
		maskedCreditCard.append(creditCardNumber.charAt(0));

		// Iterate and validate each String character through for loop (the stream can
		// be utilized with filters to perform this operation.)
		for (int i = 1; i < creditCardNumber.length(); i++) {
			char character = creditCardNumber.charAt(i);
			if (Character.isDigit(character) && i < creditCardNumber.length() - 4) {
				maskedCreditCard.append("#");
			} else {
				maskedCreditCard.append(character);
			}
		}
		return maskedCreditCard.toString();
	}
	

}
