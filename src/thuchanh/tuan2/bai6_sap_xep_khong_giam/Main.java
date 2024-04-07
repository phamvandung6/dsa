package thuchanh.tuan2.bai6_sap_xep_khong_giam;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        SelectionSort.selectionSort(arr);
        System.out.println(Arrays.toString(arr));
        scanner.close();
    }
}
