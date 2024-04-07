package thuchanh.tuan4.bai3;

import java.util.Stack;

public class Client {
    public static int evaluateExpression(String expression) {
        if (!isValidExpression(expression)) {
            throw new IllegalArgumentException("Invalid expression");
        }

        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();
        // (1+1)
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '(') {
                operators.push(ch);
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                operators.push(ch);
            } else if (Character.isDigit(ch)) {
                StringBuilder operandStr = new StringBuilder();
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    operandStr.append(expression.charAt(i));
                    i++;
                }
                i--;
                operands.push(Integer.parseInt(operandStr.toString()));
            } else if (ch == ')') {
                int result = operands.pop();
                while (!operators.isEmpty() && operators.peek() != '(') {
                    char operator = operators.pop();
                    int nextOperand = operands.pop();
                    if (operator == '+') {
                        result += nextOperand;
                    } else if (operator == '-') {
                        result -= nextOperand;
                    } else if (operator == '*') {
                        result *= nextOperand;
                    } else if (operator == '/') {
                        result /= nextOperand;
                    }
                }
                operators.pop(); // Remove '('
                operands.push(result);
            }
        }

        return operands.pop();
    }

    public static boolean isValidExpression(String expression) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        // String validExpression1 = "(a - b) * (c + d)";
        // String validExpression2 = "(10 + 8)/((5 - 2) * 17)";
        // String invalidExpression1 = "(a + b) * c - d)";
        // String invalidExpression2 = "(10 - 8/((2 + 5) * 17)";
        // String invalidExpression3 = ")u - v) * (m + n)";

        // System.out.println(isValidExpression(validExpression1)); // true
        // System.out.println(isValidExpression(validExpression2)); // true
        // System.out.println(isValidExpression(invalidExpression1)); // false
        // System.out.println(isValidExpression(invalidExpression2)); // false
        // System.out.println(isValidExpression(invalidExpression3)); // false

        String expression1 = "(1+(2+3)*(8*5))";
        String expression2 = "(5-(8-4)*(2+3))+(8/4)";

        System.out.println(evaluateExpression(expression1));
        System.out.println(evaluateExpression(expression2)); // -13

    }
}