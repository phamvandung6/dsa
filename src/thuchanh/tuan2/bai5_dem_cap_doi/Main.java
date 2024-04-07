package thuchanh.tuan2.bai5_dem_cap_doi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static int countSimilarPairs(int[] arr, int n, int x) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int count = 0;

        for (int num : arr) {
            int complement = x - num;
            if (frequencyMap.containsKey(complement)) {
                count += frequencyMap.get(complement);
            }
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        return count;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int result = countSimilarPairs(arr, n, x);
        System.out.println(result);
        scanner.close();
    }
}
