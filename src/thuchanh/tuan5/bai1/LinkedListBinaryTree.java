package thuchanh.tuan5.bai1;

public class LinkedListBinaryTree<T extends Comparable<T>> implements BinaryTreeInterface<T> {
    private Node<T> root;
    private int size;

    public LinkedListBinaryTree() {
        root = null;
        size = 0;
    }

    public LinkedListBinaryTree(T rootValue) {
        root = new Node<T>(rootValue);
        size = 1;
    }

    public void setRoot(Node<T> newRoot) {
        root = newRoot;
    }

    public Node<T> getRoot() {
        return root;
    }

    @Override
    public T root() {
        return root.value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int numChildren(T p) {
        Node<T> node = findNode(root, p);
        if (node == null) {
            throw new IllegalArgumentException("Node not found in the tree.");
        }
        int childrenCount = 0;
        if (node.left != null) {
            childrenCount++;
        }
        if (node.right != null) {
            childrenCount++;
        }
        return childrenCount;
    }

    @Override
    public T parent(T p) {
        Node<T> parentNode = findParentNode(root, p);
        if (parentNode == null) {
            return null;
        }
        return parentNode.value;
    }

    @Override
    public T left(T p) {
        Node<T> node = findNode(root, p);
        if (node == null || node.left == null) {
            return null;
        }
        return node.left.value;
    }

    @Override
    public T right(T p) {
        Node<T> node = findNode(root, p);
        if (node == null || node.right == null) {
            return null;
        }
        return node.right.value;
    }

    @Override
    public T sibling(T p) {
        Node<T> parentNode = findParentNode(root, p);
        if (parentNode == null) {
            return null;
        }
        if (parentNode.left != null && parentNode.left.value.equals(p)) {
            return parentNode.right != null ? parentNode.right.value : null;
        }
        if (parentNode.right != null && parentNode.right.value.equals(p)) {
            return parentNode.left != null ? parentNode.left.value : null;
        }
        return null;
    }

    public Node<T> findNode(T value) {
        return findNode(root, value);
    }

    private Node<T> findNode(Node<T> currentNode, T value) {
        if (currentNode == null) {
            return null;
        }
        if (currentNode.value.equals(value)) {
            return currentNode;
        }
        Node<T> leftResult = findNode(currentNode.left, value);
        if (leftResult != null) {
            return leftResult;
        }
        return findNode(currentNode.right, value);
    }

    private Node<T> findParentNode(Node<T> currentNode, T value) {
        if (currentNode == null) {
            return null;
        }
        if (currentNode.left != null && currentNode.left.value.equals(value)) {
            return currentNode;
        }
        if (currentNode.right != null && currentNode.right.value.equals(value)) {
            return currentNode;
        }
        Node<T> leftResult = findParentNode(currentNode.left, value);
        if (leftResult != null) {
            return leftResult;
        }
        return findParentNode(currentNode.right, value);
    }

    public Node<T> addRoot(T value) {
        if (root != null) {
            throw new IllegalArgumentException("Tree already has a root");
        }
        root = new Node<>(value);
        size++;
        return root;
    }

    public Node<T> addLeft(Node<T> parent, T value) {
        if (parent == null) {
            throw new IllegalArgumentException("Parent node cannot be null");
        }
        if (parent.left != null) {
            throw new IllegalArgumentException("Parent already has a left child");
        }
        parent.left = new Node<T>(value);
        size++;
        return parent.left;
    }

    public Node<T> addRight(Node<T> parent, T value) {
        if (parent == null) {
            throw new IllegalArgumentException("Parent node cannot be null");
        }
        if (parent.right != null) {
            throw new IllegalArgumentException("Parent already has a right child");
        }
        parent.right = new Node<>(value);
        size++;
        return parent.right;
    }

    public void insertBinaryTree(T value) {
        root = insert(root, value);
        size++;
    }

    public void delete(T value) {
        root = delete(root, value);
        size--;
    }

    public void inorderTraversal() {
        inorderTraversal(root);
    }

    private void inorderTraversal(Node<T> node) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left);
        System.out.print(node.value + " ");
        inorderTraversal(node.right);
    }

    private Node<T> delete(Node<T> node, T value) {
        if (node == null) {
            return null;
        }
        if (value.compareTo(node.value) < 0) {
            node.left = delete(node.left, value);
        } else if (value.compareTo(node.value) > 0) {
            node.right = delete(node.right, value);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            node.value = findMin(node.right);
            node.right = delete(node.right, node.value);
        }
        return node;
    }

    private Node<T> insert(Node<T> node, T value) {
        if (node == null) {
            return new Node<>(value);
        }
        if (value.compareTo(node.value) < 0) {
            node.left = insert(node.left, value);
        } else if (value.compareTo(node.value) > 0) {
            node.right = insert(node.right, value);
        }

        return node;
    }

    public void setNode(Node<T> p, T element) {
        if (p == null) {
            throw new IllegalArgumentException("Node cannot be null");
        }
        p.value = element;
    }

    public Node<T> getNodeByValue(T value) {
        return findNode(root, value);
    }

    public T findMin() {
        if (root == null) {
            throw new IllegalArgumentException("Tree is empty");
        }
        return findMin(root);
    }

    private T findMin(Node<T> node) {
        if (node.left == null) {
            return node.value;
        }
        return findMin(node.left);
    }

    
}
