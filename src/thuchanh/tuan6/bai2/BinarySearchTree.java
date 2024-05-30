package thuchanh.tuan6.bai2;

import thuchanh.tuan5.bai1.LinkedListBinaryTree;

// Sử dụng kiểu dữ liệu Binary Tree cài đặt bằng cấu trúc liên kết đã thực hiện trong Homework 5.

public class BinarySearchTree<T extends Comparable<T>> {
    private LinkedListBinaryTree<T> root;

    public BinarySearchTree() {
        root = new LinkedListBinaryTree<>();
    }

    public T findMin() {
        return root.findMin();
    }

    public boolean search(T data) {
        return root.findNode(data) != null;
    }

    public void insert(T data) {
        root.insertBinaryTree(data);
    }

    public void delete(T data) {
        root.delete(data);
    }

    public void inorderTraversal() {
        root.inorderTraversal();
    }

    public int size() {
        return root.size();
    }
}