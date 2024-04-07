package thuchanh.tuan5.bai3;

import thuchanh.tuan4.bai2.LinkedListStack;

public class Client {
    public static void main(String[] args) {
        String input = "(6/2+3)*(7-4)";
        System.out.println("Postfix: " + infixToPostfix(input));
        System.out.println("Prefix: " + infixToPrefix(input));
        printTree(buildBinaryTree(input));
    }

    public static String infixToPostfix(String infix) {
        LinkedListStack<Character> stack = new LinkedListStack<>();
        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            if (Character.isDigit(c)) {
                postfix.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop(); // pop '('
            } else { // operator
                while (!stack.isEmpty() && precedence(stack.peek(), c)) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    private static boolean precedence(char op1, char op2) {
        if (op1 == '*' || op1 == '/') {
            return op2 == '+' || op2 == '-' || op2 == '(';
        } else {
            return false;
        }
    }

    public static String infixToPrefix(String infix) {
        LinkedListStack<Character> stack = new LinkedListStack<>();
        StringBuilder prefix = new StringBuilder();

        for (int i = infix.length() - 1; i >= 0; i--) {
            char c = infix.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                prefix.append(c);
            } else if (c == ')') {
                stack.push(c);
            } else if (c == '(') {
                while (!stack.isEmpty() && stack.peek() != ')') {
                    prefix.append(stack.pop());
                }
                stack.pop(); // pop '('
            } else { // operator
                while (!stack.isEmpty() && precedence(stack.peek(), c)) {
                    prefix.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            prefix.append(stack.pop());
        }

        return prefix.reverse().toString();
    }

    public static BinaryTreeNode buildBinaryTree(String infix) {
        String postfix = infixToPostfix(infix);
        LinkedListStack<BinaryTreeNode> stack = new LinkedListStack<>();

        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);
            BinaryTreeNode node = new BinaryTreeNode(c);
            if (Character.isLetterOrDigit(c)) {
                stack.push(node);
            } else { // operator
                BinaryTreeNode rightChild = stack.pop();
                BinaryTreeNode leftChild = stack.pop();
                node.setLeftChild(leftChild);
                node.setRightChild(rightChild);
                stack.push(node);
            }
        }

        return stack.pop();
    }

    public static void printTree(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        String spaces = "";
        printTree(root.getLeftChild(), spaces + "  ", "L");
        System.out.println(spaces + root.getData());
        printTree(root.getRightChild(), spaces + "  ", "R");
    }

    private static void printTree(BinaryTreeNode root, String spaces, String side) {
        if (root == null) {
            return;
        }

        printTree(root.getLeftChild(), spaces + (side.equals("L") ? "  " : "| "), "L");
        System.out.println(spaces + (side.equals("L") ? "/ " : "  ") + side + "-- " + root.getData());
        printTree(root.getRightChild(), spaces + (side.equals("L") ? "| " : "  "), "R");
    }
}
