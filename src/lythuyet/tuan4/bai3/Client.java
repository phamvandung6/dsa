package lythuyet.tuan4.bai3;

import java.util.Stack;

public class Client {

    public static void main(String[] args) {
        String expression = "4.5 1.2 * 5.0 + 6.0 1.5 * +";

        double result = calculatePostfixExpression(expression);

        System.out.println("Kết quả: " + result);
        // output: Kết quả: 19.4
    }

    public static double calculatePostfixExpression(String expression) {
        Stack<Double> stack = new Stack<>();
        String[] tokens = expression.split("\\s+");
        for (String token : tokens) {
            if (token.isEmpty()) {
                continue;
            } else if (Character.isDigit(token.charAt(0))) {
                stack.push(Double.parseDouble(token));
            } else {
                double operand2 = stack.pop();
                double operand1 = stack.pop();
                double result = 0;

                switch (token) {
                    case "+":
                        result = operand1 + operand2;
                        break;
                    case "-":
                        result = operand1 - operand2;
                        break;
                    case "*":
                        result = operand1 * operand2;
                        break;
                    case "/":
                        result = operand1 / operand2;
                        break;
                    case "^":
                        result = Math.pow(operand1, operand2);
                        break;
                    case "sqrt":
                        result = Math.sqrt(operand2);
                        break;
                }
                stack.push(result); // Push the result onto the stack
            }
        }
        return stack.pop();
    }
}
