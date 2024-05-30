package thuchanh.tuan7.bai3;

import thuchanh.tuan7.bai1.ArrEntry;
import thuchanh.tuan7.bai2.MinHeapPriorityQueue;

public class HeapSort {

    public static void heapSort(int[] arr) {
        MinHeapPriorityQueue<Integer, Integer> heap = new MinHeapPriorityQueue<>();

        // Thêm các phần tử vào heap
        for (int i = 0; i < arr.length; i++) {
            heap.insert(arr[i], i);
        }

        // Lấy các phần tử từ heap theo thứ tự tăng dần
        for (int i = 0; i < arr.length; i++) {
            ArrEntry<Integer, Integer> entry = heap.removeMin();
            arr[i] = entry.getKey();
        }
    }
}