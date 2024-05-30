package thuchanh.tuan8.bai3.problem1;

import java.util.HashMap;

public class Solution {
    // Given an array of N integers, and an integer K, find the number of pairs of
    // elements in the array whose sum is equal to K.

    // Example 1:

    // Input:
    // N = 4, K = 6
    // arr[] = {1, 5, 7, 1}
    // Output: 2
    // Explanation:
    // arr[0] + arr[1] = 1 + 5 = 6
    // and arr[1] + arr[3] = 5 + 1 = 6.
    public static int getPairsCount(int[] arr, int n, int k) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(k - arr[i])) {
                count += map.get(k - arr[i]);
            }
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 5, 7, 1 };
        int n = arr.length;
        int k = 6;
        // Output: 2
        System.out.println(getPairsCount(arr, n, k));
    }
}
