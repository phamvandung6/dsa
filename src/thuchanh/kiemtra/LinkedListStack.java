package thuchanh.kiemtra;

import java.util.Iterator;

public class LinkedListStack<T> implements StackInterface<T> {

  class Node {
	T element;
	Node next;
  }

  Node stack = null;

  @Override
  public void push(T element) {
	Node newNode = new Node();
	newNode.element = element;
	newNode.next = stack;
	stack = newNode;
  }

  @Override
  public T pop() {
	if (stack != null) {
	  T data = stack.element;
	  stack = stack.next;
	  return data;
	}
	return null;
  }

  @Override
  public boolean isEmpty() {
	return stack == null;
  }

  @Override
  public Iterator<T> iterator() {
	return new StackIterator();
  }

  class StackIterator implements Iterator<T> {
	private Node currentNode = stack;

	@Override
	public boolean hasNext() {
	  return currentNode != null;
	}

	@Override
	public T next() {
	  T data = currentNode.element;
	  currentNode = currentNode.next;
	  return data;
	}
  }
}