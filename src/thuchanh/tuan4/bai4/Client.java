package thuchanh.tuan4.bai4;

public class Client {
    public static void main(String[] args) {
        // ArrayQueue<Integer> queue = new ArrayQueue<>();

        // queue.enqueue(10);
        // queue.enqueue(20);
        // queue.enqueue(30);

        // System.out.println("Queue: " + queue);

        // System.out.println("Dequeued element: " + queue.dequeue());

        // System.out.println("Queue: " + queue);

        // System.out.println("Is queue empty? " + queue.isEmpty());

        // queue.enqueue(40);

        // System.out.println("Queue: " + queue);

        LinkedListQueue<Integer> queue = new LinkedListQueue<>();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Queue: " + queue);

        System.out.println("Dequeued element: " + queue.dequeue());

        System.out.println("Queue: " + queue);

        System.out.println("Is queue empty? " + queue.isEmpty());

        queue.enqueue(40);

        System.out.println("Queue: " + queue);
    }
}