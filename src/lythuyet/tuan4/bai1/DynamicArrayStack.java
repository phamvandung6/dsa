package lythuyet.tuan4.bai1;

public class DynamicArrayStack {
    private int capacity;
    public static final int CAPACITY = 16;
    public static int MINCAPACITY = 1 << 15;
    private int[] stack;
    private int top = -1;

    public DynamicArrayStack() {
        this.capacity = CAPACITY;
        this.stack = new int[capacity];
    }

    public DynamicArrayStack(int capacity) {
        this.capacity = capacity;
        this.stack = new int[capacity];
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public void push(int data) {
        if (size() == capacity) {
            capacity *= 2;
            int[] newStack = new int[capacity];
            for (int i = 0; i < size(); i++) {
                newStack[i] = stack[i];
            }
            stack = newStack;
        }
        stack[++top] = data;
    }

    public int top() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is empty");
        }
        return stack[top];
    }

    public void pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is empty");
        }
        stack[top--] = Integer.MIN_VALUE;
        if (size() < capacity / 2) {
            capacity /= 2;
        }
        int[] newStack = new int[capacity];
        for (int i = 0; i < size(); i++) {
            newStack[i] = stack[i];
        }
    }

    public String toString() {
        String s = "[";
        if (size() > 0)
            s += stack[0];
        if (size() > 1)
            for (int i = 1; i <= size() - 1; i++) {
                s += ", " + stack[i];
            }
        return s + "]";
    }
}
