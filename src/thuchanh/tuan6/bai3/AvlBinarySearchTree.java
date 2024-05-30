package thuchanh.tuan6.bai3;

public class AvlBinarySearchTree<T extends Comparable<T>> implements TreeInterface<T> {
    private Node<T> root;

    @Override
    public TreeInterface<T> insert(T data) {
        root = insert(root, data);
        return this;
    }

    @Override
    public void delete(T data) {
        root = delete(data, root);
    }

    @Override
    public void traverse() {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node<T> node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.println(node);
            traverseInOrder(node.right);
        }
    }

    @Override
    public T getMax() {
        if (isEmpty()) {
            return null;
        }
        return getMax(root);
    }

    @Override
    public T getMin() {
        if (isEmpty()) {
            return null;
        }
        return getMin(root);
    }

    private T getMin(Node<T> node) {
        if (node.left != null) {
            return getMin(node.left);
        }
        return node.data;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    private Node<T> insert(Node<T> node, T data) {
        if (node == null) {
            return new Node<>(data);
        }
        if (data.compareTo(node.data) < 0) {
            node.left = insert(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = insert(node.right, data);
        }
        updateHeight(node);
        return applyRotation(node);
    }

    private Node<T> applyRotation(Node<T> node) {
        int balance = balance(node);
        if (balance > 1) {
            if (balance(node.left) < 0) {
                node.left = rotateLeft(node.left);
            }
            return rotateRight(node);
        }
        if (balance < -1) {
            if (balance(node.right) > 0) {
                node.right = rotateRight(node.right);
            }
            return rotateLeft(node);
        }
        return node;
    }

    private Node<T> rotateRight(Node<T> node) {
        Node<T> leftNode = node.left;
        Node<T> centerNode = leftNode.right;
        leftNode.right = node;
        node.left = centerNode;
        updateHeight(node);
        updateHeight(leftNode);
        return leftNode;
    }

    private Node<T> rotateLeft(Node<T> node) {
        Node<T> rightNode = node.right;
        Node<T> centerNode = rightNode.left;
        rightNode.left = node;
        node.right = centerNode;
        updateHeight(node);
        updateHeight(rightNode);
        return rightNode;
    }

    private void updateHeight(Node<T> node) {
        int maxHeight = Math.max(
                height(node.left),
                height(node.right));
        node.height = maxHeight + 1;
    }

    private int balance(Node<T> node) {
        return node != null ? height(node.left) - height(node.right) : 0;
    }

    private int height(Node<T> node) {
        return node != null ? node.height : 0;
    }

    private Node<T> delete(T data, Node<T> node) {
        if (node == null) {
            return null;
        }
        if (data.compareTo(node.data) < 0) {
            node.left = delete(data, node.left);
        } else if (data.compareTo(node.data) > 0) {
            node.right = delete(data, node.right);
        } else {
            // One Child or Leaf Node (no children)
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            // Two Children
            node.data = getMax(node.left);
            node.left = delete(node.data, node.left);
        }
        updateHeight(node);
        return applyRotation(node);
    }

    private T getMax(Node<T> node) {
        if (node.right != null) {
            return getMax(node.right);
        }
        return node.data;
    }

}