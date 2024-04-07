package thuchanh.tuan5.bai1;

import java.util.Arrays;

public class ArrayBinaryTree<T> implements BinaryTreeInterface<T> {
    private T[] tree;
    private int n;
    private int default_size = 100;

    ArrayBinaryTree() {
        tree = (T[]) new Object[default_size];
        n = 0;
    }

    public ArrayBinaryTree(T element) {
        n = 1;
        tree = (T[]) new Object[default_size];
        tree[0] = element;
    }

    @Override
    public T left(T p) {
        int index = indexOf(p);
        if (index == -1 || index * 2 + 1 >= n) {
            return null;
        }
        return (T) tree[index * 2 + 1];
    }

    @Override
    public T right(T p) {
        int index = indexOf(p);
        if (index == -1 || index * 2 + 2 >= n) {
            return null;
        }
        return (T) tree[index * 2 + 2];
    }

    @Override
    public T parent(T p) {
        int index = indexOf(p);
        if (index == -1 || index % 2 == 0) {
            return null;
        }
        return (T) tree[(index - 1) / 2];
    }

    @Override
    public T sibling(T p) {
        int index = indexOf(p);
        if (index == -1 || index % 2 == 0) {
            return null;
        }
        int siblingIndex = (index - 1) / 2 * 2 + 1;
        if (siblingIndex >= n) {
            return null;
        }
        return (T) tree[siblingIndex];
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public int numChildren(T p) {
        int index = indexOf(p);
        if (index == -1) {
            return 0;
        }
        T left = left(p);
        T right = right(p);
        if (left == null && right == null) {
            return 0;
        } else if (left == null) {
            return 1;
        } else if (right == null) {
            return 1;
        } else {
            return 2;
        }
    }

    private int indexOf(T node) {
        for (int i = 0; i < n; i++) {
            if (tree[i].equals(node)) {
                return i;
            }
        }
        return -1;
    }

    public void setRoot(T element) {
        if (n != 0) {
            throw new IllegalArgumentException("The tree is not empty");
        }
        tree[0] = element;
        n++;
    }

    public void setLeft(int p, T element) {
        if (p < 0 || p >= n)
            throw new IllegalArgumentException("Invalid index: " + p);
        int i = 2 * p + 1;
        if (i >= tree.length)
            resizeArray(2 * tree.length);
        tree[i] = element;
        n++;
    }

    public void setRight(int p, T element) {
        if (p < 0 || p >= n)
            throw new IllegalArgumentException("Invalid index: " + p);
        int i = 2 * p + 2;
        if (i >= tree.length)
            resizeArray(2 * tree.length);
        tree[i] = element;
        n++;
    }

    private void resizeArray(int newSize) {
        T[] newArray = (T[]) new Object[newSize];
        System.arraycopy(tree, 0, newArray, 0, n);
        tree = newArray;
    }

    @Override
    public T root() {
        if (n == 0) {
            return null;
        }
        return (T) tree[0];
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public String toString() {
        return Arrays.toString(tree);
    }
}
