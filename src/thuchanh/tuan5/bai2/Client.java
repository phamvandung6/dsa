package thuchanh.tuan5.bai2;

public class Client {
    public static void main(String[] args) {
        ExpressionTree<Character> tree = new ExpressionTree<>();
        tree.addRoot('+');
        tree.addLeft(tree.getNodeByValue('+'), '3');
        tree.addRight(tree.getNodeByValue('+'), '*');
        tree.addLeft(tree.getNodeByValue('*'), '2');
        tree.addRight(tree.getNodeByValue('*'), '5');
        // In thử ra các giá trị biểu thức
        System.out.println("Biểu thức tiền tố: ");
        tree.preorderPrint(tree.getNodeByValue(tree.root()));
        System.out.println();
        System.out.println("Biểu thức hậu tố: ");
        tree.postorderPrint(tree.getNodeByValue(tree.root()));
        System.out.println();
        System.out.println("Biểu thức trung tố: ");
        tree.inorderPrint(tree.getNodeByValue(tree.root()));
        System.out.println();

        System.out.println("Tính giá trị biểu thức tiền tố: " + tree.evaluate());
    }
}
