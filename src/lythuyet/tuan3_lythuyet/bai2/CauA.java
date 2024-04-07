package lythuyet.tuan3_lythuyet.bai2;

import lythuyet.tuan3_lythuyet.bai1.LinkedListNode;

public class CauA {
    //Output:
//    Linked List ban đầu: 5, 10
//    Thêm 2 vào vị trí đầu
//    Linked List sau khi chèn: 2, 5, 10
//    Thêm 7 vào vị trí 2
//    Linked List sau khi chèn: 2, 5, 7, 10
//    Độ dài Linked List: 4

    public static void main(String[] args) {
        LinkedListNode list = new LinkedListNode();
        list.insert(5);
        list.insert(10);
        System.out.println("Linked List ban đầu: " + list);
        // Insert 2 at the beginning of the list
        System.out.println("Thêm 2 vào vị trí đầu");
        list.insertAtBeginning(2);
        System.out.println("Linked List sau khi chèn: " + list);
        // Insert 7 at position 2
        System.out.println("Thêm 7 vào vị trí 2");
        list.insertAt(7, 2);
        // Print the length of the list
        System.out.println("Linked List sau khi chèn: " + list);
        System.out.println("Độ dài Linked List: " + list.getLength());
    }
}
