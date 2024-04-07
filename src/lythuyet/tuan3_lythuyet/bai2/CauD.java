package lythuyet.tuan3_lythuyet.bai2;

import lythuyet.tuan3_lythuyet.bai1.LinkedListNode;

public class CauD {
    //Output:
//    LinkedList 1: 1, 2, 3
//    LinkedList 2: 4, 5, 6
//    Merged LinkedList: 1, 2, 3, 4, 5, 6

    public static void main(String[] args) {
        LinkedListNode list1 = new LinkedListNode();
        list1.insert(1);
        list1.insert(2);
        list1.insert(3);

        LinkedListNode list2 = new LinkedListNode();
        list2.insert(4);
        list2.insert(5);
        list2.insert(6);

        System.out.println("LinkedList 1: " + list1);
        System.out.println("LinkedList 2: " + list2);

        LinkedListNode mergedList = LinkedListNode.mergeSortedLists(list1, list2);
        System.out.println("Merged LinkedList: " + mergedList);
    }
}
