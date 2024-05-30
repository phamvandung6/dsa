package thuchanh.tuan7.bai2;

import thuchanh.tuan7.bai1.ArrEntry;
import thuchanh.tuan7.bai1.SortedArrayPriorityQueue;

public class MinHeapPriorityQueue<K extends Comparable<K>, E> extends SortedArrayPriorityQueue<K, E> {

    public MinHeapPriorityQueue() {
        super();
    }

    public void upHeap(int index) {
        int parentIndex = (index - 1) / 2;
        while (index > 0 && arr[index].getKey().compareTo(arr[parentIndex].getKey()) < 0) {
            ArrEntry<K, E> temp = arr[index];
            arr[index] = arr[parentIndex];
            arr[parentIndex] = temp;
            index = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }
    }

    public void downHeap(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int smallestIndex = index;

        if (leftChildIndex < size && arr[leftChildIndex].getKey().compareTo(arr[smallestIndex].getKey()) < 0) {
            smallestIndex = leftChildIndex;
        }

        if (rightChildIndex < size && arr[rightChildIndex].getKey().compareTo(arr[smallestIndex].getKey()) < 0) {
            smallestIndex = rightChildIndex;
        }

        if (smallestIndex != index) {
            ArrEntry<K, E> temp = arr[index];
            arr[index] = arr[smallestIndex];
            arr[smallestIndex] = temp;
            downHeap(smallestIndex);
        }
    }
}
