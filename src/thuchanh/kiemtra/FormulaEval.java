package thuchanh.kiemtra;

import java.util.Stack;

public class FormulaEval {

	public double eval(String formula) {
		Stack<Double> operands = new Stack<>();

		Stack<Character> operators = new Stack<>();

		String[] tokens = formula.split(" ");

		for (String token : tokens) {
			if (token.equals("(")) {
			} else if (token.equals("+") || token.equals("-") ||
					token.equals("*") || token.equals("/")) {
				operators.push(token.charAt(0));
			} else if (token.equals(")")) {
				char operator = operators.pop();
				double operand2 = operands.pop();
				double operand1 = operands.pop();
				double result = calculate(operand1, operand2, operator);
				operands.push(result);
			} else {
				operands.push(Double.parseDouble(token));
			}
		}

		return operands.pop();
	}

	private double calculate(double operand1, double operand2, char operator) {
		switch (operator) {
			case '-':
				return operand1 - operand2;
			case '+':
				return operand1 + operand2;
			case '*':
				return operand1 * operand2;
			case '/':
				if (operand2 == 0) {
					System.out.println("khong the chia duoc cho 0");
				}
				return operand1 / operand2;
			default:
				throw new IllegalArgumentException("Toan tu khong phu hop: " + operator);
		}
	}
}
