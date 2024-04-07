package thuchanh.tuan4.luyentap3;

import java.util.Stack;

// Xóa phần tử giữa Stack
public class Client {
    public static void deleteMiddleElement(Stack<Integer> stack) {
        int size = stack.size();
        int middleIndex = (size + 1) / 2;

        if (size % 2 == 0) {
            Stack<Integer> tempStack = new Stack<>();
            for (int i = 1; i <= middleIndex; i++) {
                tempStack.push(stack.pop());
            }
            stack.pop();
            while (!tempStack.isEmpty()) {
                stack.push(tempStack.pop());
            }
        } else {
            Stack<Integer> tempStack = new Stack<>();
            for (int i = 1; i < middleIndex; i++) {
                tempStack.push(stack.pop());
            }
            stack.pop();
            while (!tempStack.isEmpty()) {
                stack.push(tempStack.pop());
            }
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        deleteMiddleElement(stack);

        System.out.println(stack); // Output: [10, 20, 40, 50]
    }
}