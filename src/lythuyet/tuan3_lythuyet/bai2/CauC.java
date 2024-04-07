package lythuyet.tuan3_lythuyet.bai2;

import lythuyet.tuan3_lythuyet.bai1.LinkedListNode;

public class CauC {
    //Output:
//    Linked List ban đầu: 1, 4, 3, 2
//    Giá trị lớn nhất: 4
//    Giá trị nhỏ nhất: 1
    public static void main(String[] args) {
        LinkedListNode list = new LinkedListNode();
        list.insert(1);
        list.insert(4);
        list.insert(3);
        list.insert(2);

        System.out.println("Linked List ban đầu: " + list);
        System.out.println("Giá trị lớn nhất: " + list.findMax());
        System.out.println("Giá trị nhỏ nhất: " + list.findMin());
    }
}
