package on_tap_cuoi_ki.stack;

public class ArrayStack<E> implements StackInterface<E> {
    private E[] stack;
    private int top;

    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) {
        stack = (E[]) new Object[capacity];
        top = -1;
    }

    @Override
    public void push(E element) {
        if (top == stack.length - 1) {
            // resize
            E[] newStack = (E[]) new Object[stack.length * 2];
            System.arraycopy(stack, 0, newStack, 0, stack.length);
            stack = newStack;
        }
        stack[++top] = element;
    }

    @Override
    public E pop() {
        return stack[top--];
    }

    @Override
    public E top() {
        return stack[top];
    }

    @Override
    public int size() {
        return top + 1;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

}
