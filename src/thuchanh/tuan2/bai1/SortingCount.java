package thuchanh.tuan2.bai1;

import java.util.Arrays;

public class SortingCount {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        int comparisons = 0;
        int swaps = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                comparisons++;
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swaps++;
                }
            }
            System.out.println("Dãy số sau vòng lặp thứ " + (i + 1) + ": " + Arrays.toString(arr));
        }
        System.out.println("Số lần so sánh: " + comparisons);
        System.out.println("Số lần đổi chỗ: " + swaps);
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        int comparisons = 0;
        int swaps = 0;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                comparisons++;
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
            swaps++;
            System.out.println("Dãy số sau vòng lặp thứ " + (i + 1) + ": " + Arrays.toString(arr));
        }
        System.out.println("Số lần so sánh: " + comparisons);
        System.out.println("Số lần đổi chỗ: " + swaps);
    }
}
