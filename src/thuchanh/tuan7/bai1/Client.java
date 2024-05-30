package thuchanh.tuan7.bai1;

public class Client {
    // Output:
    // Sorted Array Priority Queue:
    // [1:Charlie]
    // [2:Bob]
    // [3:Dave]
    // [4:Alice]
    // Unsorted Array Priority Queue:
    // [4:Alice]
    // [2:Bob]
    // [1:Charlie]
    // [3:Dave]
    // Sorted Linked Priority Queue:
    // [1:Charlie]
    // [2:Bob]
    // [3:Dave]
    // [4:Alice]
    // Unsorted Linked Priority Queue:
    // [4:Alice]
    // [2:Bob]
    // [1:Charlie]
    // [3:Dave]
    public static void main(String[] args) {
        SortedArrayPriorityQueue<Integer, String> sortedQueue = new SortedArrayPriorityQueue<>();
        sortedQueue.insert(4, "Alice");
        sortedQueue.insert(2, "Bob");
        sortedQueue.insert(1, "Charlie");
        sortedQueue.insert(3, "Dave");

        // In danh sách phần tử trong SortedLinkedPriorityQueue
        System.out.println("Sorted Array Priority Queue:");
        sortedQueue.print();

        // System.out.println("In ra các phần tử nhỏ nhất");
        // System.out.println("Key\tValue");
        // while (!sortedQueue.isEmpty()) {
        // Entry<Integer, String> entry = sortedQueue.removeMin();
        // System.out.println(entry.getKey() + "\t" + entry.getValue());
        // }

        UnsortedArrayPriorityQueue<Integer, String> unsortedQueue = new UnsortedArrayPriorityQueue<>();
        unsortedQueue.insert(4, "Alice");
        unsortedQueue.insert(2, "Bob");
        unsortedQueue.insert(1, "Charlie");
        unsortedQueue.insert(3, "Dave");

        System.out.println("Unsorted Array Priority Queue:");
        unsortedQueue.print();
        // In danh sách phần tử trong UnsortedLinkedPriorityQueue
        // System.out.println("In ra các phần tử nhỏ nhất trong
        // UnsortedArrayPriorityQueue:");
        // System.out.println("Key\tValue");
        // while (!unsortedQueue.isEmpty()) {
        // Entry<Integer, String> entry = unsortedQueue.removeMin();
        // System.out.println(entry.getKey() + "\t" + entry.getValue());
        // }

        SortedLinkedPriorityQueue<Integer, String> sortedLinkedQueue = new SortedLinkedPriorityQueue<>();
        sortedLinkedQueue.insert(4, "Alice");
        sortedLinkedQueue.insert(2, "Bob");
        sortedLinkedQueue.insert(1, "Charlie");
        sortedLinkedQueue.insert(3, "Dave");

        System.out.println("Sorted Linked Priority Queue:");
        sortedLinkedQueue.print();

        UnsortedLinkedPriorityQueue<Integer, String> unsortedLinkedQueue = new UnsortedLinkedPriorityQueue<>();
        unsortedLinkedQueue.insert(4, "Alice");
        unsortedLinkedQueue.insert(2, "Bob");
        unsortedLinkedQueue.insert(1, "Charlie");
        unsortedLinkedQueue.insert(3, "Dave");

        System.out.println("Unsorted Linked Priority Queue:");
        unsortedLinkedQueue.print();
    }
}
