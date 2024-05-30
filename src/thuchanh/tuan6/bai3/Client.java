package thuchanh.tuan6.bai3;

public class Client {
    // Output:

    // 2
    // 6
    // 8
    // 10
    // 15
    // 18
    // 22
    // 25
    // 35
    // 42
    // Max is: 42
    // Min is: 2
    // Deleting 42 from Tree
    // New Max is: 35
    // 2
    // 6
    // 8
    // 10
    // 15
    // 18
    // 22
    // 25
    // 35
    public static void main(String[] args) {

        AvlBinarySearchTree<Integer> avlTree = new AvlBinarySearchTree<>();
        avlTree.insert(10).insert(2)
                .insert(6).insert(8)
                .insert(25).insert(18)
                .insert(35).insert(15)
                .insert(22).insert(42);

        avlTree.traverse();

        System.out.println("Max is: " + avlTree.getMax());
        System.out.println("Min is: " + avlTree.getMin());

        System.out.println("Deleting 42 from Tree");
        avlTree.delete(42);

        System.out.println("New Max is: " + avlTree.getMax());

        avlTree.traverse();

    }
}
