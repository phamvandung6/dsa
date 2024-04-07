package thuchanh.tuan5.luyentap1;

public class Client {
    public static int countLeaf(int[] a) {
        int count = 0;
        Node root = new Node(a[0]);
        for (int i = 1; i < a.length; i++) {
            Node node = new Node(a[i]);
            Node parent = root;
            while (true) {
                if (node.data < parent.data) {
                    if (parent.left == null) {
                        parent.left = node;
                        break;
                    } else {
                        parent = parent.left;
                    }
                } else {
                    if (parent.right == null) {
                        parent.right = node;
                        break;
                    } else {
                        parent = parent.right;
                    }
                }
            }
        }
        countLeaf(root, count);
        return count;
    }

    private static int countLeaf(Node root, int count) {
        if (root == null) {
            return count;
        }
        if (root.left == null && root.right == null) {
            count++;
        }
        count = countLeaf(root.left, count);
        count = countLeaf(root.right, count);
        return count;
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }
}
