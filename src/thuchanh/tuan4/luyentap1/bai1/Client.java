package thuchanh.tuan4.luyentap1.bai1;

import java.util.Stack;

public class Client {
    // Bài 1
    // Cho một string, nhiệm vụ của bạn là in chuỗi đảo ngược của string đó ra màn
    // hình bằng cách dùng stack.

    public static void main(String[] args) {
        String str = "Hello";
        String result = reverseString(str);
        System.out.println(result);
    }

    public static String reverseString(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
