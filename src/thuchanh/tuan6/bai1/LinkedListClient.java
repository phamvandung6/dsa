package thuchanh.tuan6.bai1;

import data_structure_template.single_linked_list.SingleLinkedList;

public class LinkedListClient {
    public static void main(String[] args) {
        SingleLinkedList<Integer> myLinkedList = new SingleLinkedList<>();

        myLinkedList.addFirst(5);
        myLinkedList.addFirst(4);
        myLinkedList.addFirst(3);

        System.out.println(myLinkedList.toString());
        System.out.println(myLinkedList.search(3));
        System.out.println(myLinkedList.search(6));
    }
    // Output:
    // 3 -> 4 -> 5 -> null
    // true
    // false
}
