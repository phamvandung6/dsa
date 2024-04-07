package lythuyet.tuan4.bai4;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Client {
    // Bài này em có tham khảo ở trên mạng

    public static String infixToPostfix(String infixExpression) {
        // Lưu mức độ ưu tiên
        Map<String, Integer> precedence = new HashMap<>();
        precedence.put("^", 6);
        precedence.put("!", 6);
        precedence.put("∼", 6);
        precedence.put("abs", 6);
        precedence.put("sin", 6);
        precedence.put("cos", 6);
        precedence.put("tan", 6);
        precedence.put("exp", 6);
        precedence.put("ln", 6);
        precedence.put("lg", 6);
        precedence.put("round", 6);
        precedence.put("trunc", 6);
        precedence.put("sqr", 6);
        precedence.put("sqrt", 6);
        precedence.put("*", 5);
        precedence.put("/", 5);
        precedence.put("%", 5);
        precedence.put("==", 3);
        precedence.put("!=", 3);
        precedence.put("<", 3);
        precedence.put(">", 3);
        precedence.put("≤", 3);
        precedence.put("≥", 3);
        precedence.put("Not", 2);
        precedence.put("&&", 1);
        precedence.put("||", 1);
        precedence.put("=", 0);

        // Stack lưu toán tử
        Stack<String> operatorStack = new Stack<>();
        StringBuilder postfixExpression = new StringBuilder();

        String[] tokens = infixExpression.split(" ");

        for (String token : tokens) {
            // token chỉ bao gồm các chữ số
            if (token.matches("[0-9]+")) {
                postfixExpression.append(token).append(" ");
            } else {
                // Kiểm tra xem ngăn xếp operatorStack có trống không và độ ưu tiên của phần tử
                // đầu ngăn xếp (operatorStack.peek()) lớn hơn hoặc bằng độ ưu tiên của token
                while (!operatorStack.isEmpty()
                        && precedence.getOrDefault(operatorStack.peek(), 0) >= precedence.getOrDefault(token, 0)) {
                    postfixExpression.append(operatorStack.pop()).append(" ");
                }
                operatorStack.push(token);
            }
        }

        while (!operatorStack.isEmpty()) {
            postfixExpression.append(operatorStack.pop()).append(" ");
        }

        return postfixExpression.toString().trim();
    }

    public static void main(String[] args) {
        String infixExpression = "3 + 4 ^ 5 ^ a / 2 - 7";
        String postfixExpression = infixToPostfix(infixExpression);
        System.out.println("Infix Expression: " + infixExpression);
        System.out.println("Postfix Expression: " + postfixExpression);

        // Infix Expression: 3 + 4 ^ 5 ^ a / 2 - 7
        // Postfix Expression: 3 4 5 ^ ^ + 2 / a 7 -
    }
}