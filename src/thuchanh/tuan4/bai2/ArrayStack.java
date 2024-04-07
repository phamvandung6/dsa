package thuchanh.tuan4.bai2;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayStack<E> implements StackInterface<E> {
    private E[] stack;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public ArrayStack() {
        this.stack = (E[]) new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayStackIterator();
    }

    @Override
    public void push(E element) {
        if (size == stack.length) {
            enlarge();
        }
        stack[size - 1] = element;
        size++;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        E element = stack[size - 1];
        stack[size - 1] = null;
        size--;
        return element;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E top() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[size - 1];
    }

    private void enlarge() {
        @SuppressWarnings("unchecked")
        E[] newStack = (E[]) new Object[stack.length * 2];
        System.arraycopy(stack, 0, newStack, 0, stack.length);
        stack = newStack;
    }

    private class ArrayStackIterator implements Iterator<E> {
        private int index;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return stack[index++];
        }
    }
    
}
