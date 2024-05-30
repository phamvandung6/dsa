package data_structure_template.stack;

import java.util.EmptyStackException;

public class StackArrayList<T> {
    private T[] stack;
    private int top;
    private int capacity;

    public StackArrayList(int capacity) {
        this.capacity = capacity;
        stack = (T[]) new Object[capacity];
        top = -1;
    }

    public StackArrayList() {
        stack = (T[]) new Object[DEFAULT_CAPACITY];
        top = -1;
        capacity = DEFAULT_CAPACITY;
    }

    private static final int DEFAULT_CAPACITY = 10;

    public void push(T value) {
        if (top == capacity - 1) {
            resize(capacity * 2);
        }
        stack[++top] = value;
    }

    public T pop() {
        if (top == -1) {
            throw new EmptyStackException();
        }
        T value = stack[top];
        stack[top--] = null; // Phải gán null để gỡ bỏ được đối tượng
        if (top > 0 && top == capacity / 4) {
            resize(capacity / 2);
        }
        return value;
    }

    private void resize(int newCapacity) {
        T[] newStack = (T[]) new Object[newCapacity];
        for (int i = 0; i <= top; i++) {
            newStack[i] = stack[i];
        }
        stack = newStack;
        capacity = newCapacity;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[top];
    }

    public int size() {
        return top + 1;
    }
}
