package thuchanh.tuan5.bai2;

import thuchanh.tuan4.bai2.LinkedListStack;
import thuchanh.tuan5.bai1.LinkedListBinaryTree;
import thuchanh.tuan5.bai1.Node;

public class ExpressionTree<E extends Comparable<E>> extends LinkedListBinaryTree<E> {
    public ExpressionTree() {
        super();
    }

    public void preorderPrint(Node<E> value) {
        if (value == null) {
            return;
        }
        System.out.print(value.value + " ");
        preorderPrint(value.left);
        preorderPrint(value.right);
    }

    public void postorderPrint(Node<E> value) {
        if (value == null) {
            return;
        }
        postorderPrint(value.left);
        postorderPrint(value.right);
        System.out.print(value.value + " ");
    }

    public void inorderPrint(Node<E> value) {
        if (value == null) {
            return;
        }
        inorderPrint(value.left);
        System.out.print(value.value + " ");
        inorderPrint(value.right);
    }

    public String preorder(Node<E> value) {
        if (value == null) {
            return "";
        }
        return value.value + " " + preorder(value.left) + preorder(value.right);
    }

    public String postorder(Node<E> value) {
        if (value == null) {
            return "";
        }
        return postorder(value.left) + postorder(value.right) + value.value + " ";
    }

    public String inorder(Node<E> value) {
        if (value == null) {
            return "";
        }
        return inorder(value.left) + value.value + " " + inorder(value.right);
    }

    public double evaluate() {
        LinkedListStack<Double> stack = new LinkedListStack<>();
        String[] tokens = postorder(getNodeByValue(root())).split(" ");

        for (String token : tokens) {
            if (isOperator(token.charAt(0))) {
                double a = stack.pop();
                double b = stack.pop();
                switch (token.charAt(0)) {
                    case '+':
                        stack.push(b + a);
                        break;
                    case '-':
                        stack.push(b - a);
                        break;
                    case '*':
                        stack.push(b * a);
                        break;
                    case '/':
                        stack.push(b / a);
                        break;
                }
            } else {
                stack.push(Double.parseDouble(token));
            }
        }
        return stack.peek();
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
}
