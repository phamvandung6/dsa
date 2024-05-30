package data_structure_template.tree.binary_search_tree;

public class BinarySearchTree<T extends Comparable<T>> implements TreeInterface<T> {
    private Node<T> root;
    private int nodeCount;

    public BinarySearchTree() {
        root = null;
        nodeCount = 0;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        return nodeCount;
    }

    @Override
    public void insert(T data) {
        if (isContains(data)) {
            return;
        }
        root = insert(root, data);
        nodeCount++;
    }

    @Override
    public void delete(T data) {
        if (!isContains(data)) {
            return;
        }
        root = delete(root, data);
        nodeCount--;
    }

    @Override
    public int height() {
        return height(root);
    }

    @Override
    public boolean isContains(T element) {
        return isContains(root, element);
    }

    /**
     * In-order traversal of binary search tree.
     */
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node<T> node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    private int height(Node<T> node) {
        if (node == null) {
            return 0;
        }

        return 1 + Math.max(height(node.left), height(node.right));
    }

    private boolean isContains(Node<T> node, T element) {
        if (node == null) {
            return false;
        }

        if (element.compareTo(node.data) < 0) {
            return isContains(node.left, element);
        } else if (element.compareTo(node.data) > 0) {
            return isContains(node.right, element);
        } else {
            return true;
        }
    }

    private Node<T> insert(Node<T> node, T data) {
        if (node == null) {
            node = new Node<>(data);
        } else if (data.compareTo(node.data) < 0) {
            node.left = insert(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = insert(node.right, data);
        }

        return node;
    }

    private Node<T> delete(Node<T> node, T data) {
        if (node == null) {
            return null;
        }
        if (data.compareTo(node.data) < 0) {
            node.left = delete(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = delete(node.right, data);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                node.data = findMin(node.right);
                node.right = delete(node.right, node.data);
            }
        }
        return node;
    }

    private T findMin(Node<T> node) {
        while (node.left != null) {
            node = node.left;
        }

        return node.data;
    }

}
