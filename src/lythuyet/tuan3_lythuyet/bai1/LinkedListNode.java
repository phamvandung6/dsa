package lythuyet.tuan3_lythuyet.bai1;

public class LinkedListNode {
    private Node head;

    public int getLength() {
        int length = 0;
        Node current = head;
        while (current != null) {
            length++;
            current = current.getNext();
        }
        return length;
    }

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.setNext(head);
        head = newNode;
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    public void insertAt(int data, int position) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
    }

    public void deleteFirst() {
        if (head == null) {
            System.out.println("Linked List is null");
            return;
        }

        head = head.getNext();
    }

    public void deleteLast() {
        if (head == null) {
            System.out.println("Linked List is null");
            return;
        }
        if (head.getNext() == null) {
            head = null;
        }
        Node current = head;
        while (current.getNext().getNext() != null) {
            current = current.getNext();
        }
        current.setNext(null);
    }

    public void deleteAt(int position) {
        if (head == null) {
            System.out.println("Linked List is null");
            return;
        }

        if (position == 0) {
            head = head.getNext();
        }

        Node current = head;
        for (int i = 0; i < position - 1; i++) {
            current = current.getNext();
        }

        current.setNext(current.getNext().getNext());
    }

    public String toString() {
        if (head == null) {
            return "Linked List is null";
        }

        Node current = head;
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(current.getData());
            current = current.getNext();
            if (current != null) {
                sb.append(", ");
            }

        }

        return sb.toString();
    }

    public LinkedListNode reverseLinkedList() {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }

        head = prev;

        return this;
    }

    public int findMax() {
        if (head == null) {
            System.out.println("Linked List is null");
            return -1; // Assuming -1 represents an empty list
        }

        int max = head.getData();
        Node current = head.getNext();
        while (current != null) {
            if (current.getData() > max) {
                max = current.getData();
            }
            current = current.getNext();
        }
        return max;
    }

    public int findMin() {
        if (head == null) {
            System.out.println("Linked List is null");
            return -1; // Assuming -1 represents an empty list
        }

        int min = head.getData();
        Node current = head.getNext();
        while (current != null) {
            if (current.getData() < min) {
                min = current.getData();
            }
            current = current.getNext();
        }
        return min;
    }

    public static LinkedListNode mergeSortedLists(LinkedListNode list1, LinkedListNode list2) {
        LinkedListNode mergedList = new LinkedListNode();
        Node current1 = list1.head;
        Node current2 = list2.head;

        while (current1 != null && current2 != null) {
            if (current1.getData() < current2.getData()) {
                mergedList.insert(current1.getData());
                current1 = current1.getNext();
            } else {
                mergedList.insert(current2.getData());
                current2 = current2.getNext();
            }
        }

        while (current1 != null) {
            mergedList.insert(current1.getData());
            current1 = current1.getNext();
        }

        while (current2 != null) {
            mergedList.insert(current2.getData());
            current2 = current2.getNext();
        }

        return mergedList;
    }
}
