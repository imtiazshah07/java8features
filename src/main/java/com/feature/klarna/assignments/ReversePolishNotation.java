package com.feature.klarna.assignments;

import java.util.Stack;
import java.util.regex.Pattern;

/**
 * 
 * Your job is to create a calculator which evaluates expressions in Reverse
 * Polish notation.
 * 
 * For example expression 5 1 2 + 4 * + 3 - (which is equivalent to 5 + ((1 + 2)
 * * 4) - 3 in normal notation) should evaluate to 14.
 * 
 * Note that for simplicity you may assume that there are always spaces between
 * numbers and operations, e.g. 1 3 + expression is valid, but 1 3+ isn't.
 * 
 * Empty expression should evaluate to 0.
 * 
 * Valid operations are +, -, *, /.
 * 
 * You may assume that there won't be exceptional situations (like stack
 * underflow or division by zero).
 * 
 * Specification Challenge.calculate(expression) Calculates an expression in
 * Reverse Polish notation
 * 
 * Parameters expression: String - The expression to be evaluated
 * 
 * Return Value Float - The calculated value from the given expression
 * 
 * Examples expression Return Value "1 2 3.5" 3.5 "10000 123 +" 10123 "5 1 2 + 4
 * * + 3 -" 14
 * 
 *
 */

public class ReversePolishNotation {
	public static void main(String[] args) {
		System.out.println(ReversePolishNotation.evaluate("5 1 2 + 4 * + 3 -"));
	}

	public static double evaluate(String expr) {

		if (expr.length() == 0) {
			return 0;
		} else if (!Pattern.compile("[-*+/]").matcher(expr).find()) {
			return Double.valueOf(expr.substring(expr.lastIndexOf(' ') + 1));
		} else {
			final Stack<Double> stack = new Stack<Double>();
			for (String token : expr.split("\\s+")) {
				switch (token) {
				case "+":
					stack.push(stack.pop() + stack.pop());
					break;
				case "-":
					stack.push(-stack.pop() + stack.pop());
					break;
				case "*":
					stack.push(stack.pop() * stack.pop());
					break;
				case "/":
					double divisor = stack.pop();
					stack.push(stack.pop() / divisor);
					break;
				default:
					stack.push(Double.parseDouble(token));
					break;
				}
			}
			return stack.pop();
		}

	}
}
