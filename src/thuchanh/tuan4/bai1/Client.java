package thuchanh.tuan4.bai1;

import java.util.Stack;

public class Client {
    public static void main(String[] args) {
        Stack<Character> s = new Stack<>();
        String myName = "phamvandung";
        for (int i = 0; i < myName.length(); i++) {
            if (i % 2 == 0) {
                s.push(myName.charAt(i));
            }
            if (i % 3 == 0) {
                s.pop();
            }
        }
        System.out.println(s);
    }
}
