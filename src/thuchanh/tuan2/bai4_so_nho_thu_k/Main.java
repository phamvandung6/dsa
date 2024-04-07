package thuchanh.tuan2.bai4_so_nho_thu_k;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        BubbleSort.bubbleSort(arr);
        System.out.println(arr[k - 1]);
        scanner.close();
    }
}
