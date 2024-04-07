package thuchanh.tuan5.bai1;

public class Client {
    public static void main(String[] args) {
        ArrayBinaryTree<Integer> arrTree = new ArrayBinaryTree<>();
        arrTree.setRoot(1);
        arrTree.setLeft(0, 2);
        arrTree.setRight(0, 3);
        System.out.println("Root: " + arrTree.root());
        System.out.println("Left child of root: " + arrTree.left(arrTree.root()));
        System.out.println("Right child of root: " + arrTree.right(arrTree.root()));
        System.out.println("Size of tree: " + arrTree.size());

        LinkedListBinaryTree<Integer> linkedListTree = new LinkedListBinaryTree<>();
        linkedListTree.addRoot(1);
        linkedListTree.addLeft(linkedListTree.getNodeByValue(1), 2);
        linkedListTree.addRight(linkedListTree.getNodeByValue(1), 3);
        System.out.println("Root: " + linkedListTree.root());
        System.out.println("Left child of root: " + linkedListTree.left(linkedListTree.root()));
        System.out.println("Right child of root: " + linkedListTree.right(linkedListTree.root()));
        System.out.println("Size of tree: " + linkedListTree.size());
    }
}
