package on_tap_cuoi_ki.tree;

public class BinaryTree<T extends Comparable<T>> {
    private Node<T> root;

    public BinaryTree() {
        root = null;
    }

    public Node<T> getRoot() {
        return root;
    }

    private void insert(T data, Node<T> node) {
        if (root == null) {
            root = new Node<>(data);
        } else {
            if (data.compareTo(node.data) < 0) {
                if (node.left == null) {
                    node.left = new Node<>(data);
                } else {
                    insert(data, node.left);
                }
            } else {
                if (node.right == null) {
                    node.right = new Node<>(data);
                } else {
                    insert(data, node.right);
                }
            }
        }
    }

    public void insert(T data) {
        insert(data, root);
        return;
    }

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

    public T search(T data) {
        return search(data, root);
    }

    private T search(T data, Node<T> node) {
        if (node == null) {
            return null;
        }
        if (data.compareTo(node.data) < 0) {
            return search(data, node.left);
        } else if (data.compareTo(node.data) > 0) {
            return search(data, node.right);
        } else {
            return node.data;
        }
    }
}
