package lythuyet.tuan3_lythuyet.bai2;

import lythuyet.tuan3_lythuyet.bai1.LinkedListNode;

public class CauB {
    //Output:
//    Linked Listed ban đầu: 1, 2, 3
//    Sau khi đảo ngược:3, 2, 1

    public static void main(String[] args) {
        LinkedListNode list = new LinkedListNode();
        list.insert(1);
        list.insert(2);
        list.insert(3);

        System.out.println("Linked Listed ban đầu: " + list);

        LinkedListNode reversedList = list.reverseLinkedList();

        System.out.println("Sau khi đảo ngược:" + reversedList);
    }
}