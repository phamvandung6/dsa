package thuchanh.tuan6.bai2;

import java.util.Random;
import java.util.Arrays;

public class Client {

    // Output:

    // Số lượng input:10000
    // Thời gian thực thi tìm kiếm tuần tự: 17218 nanoseconds
    // Thời gian thực thi tìm kiếm nhị phân: 11237 nanoseconds
    // Thời gian thực thi tìm kiếm trên cây: 258308 nanoseconds
    // Số lượng input:100000
    // Thời gian thực thi tìm kiếm tuần tự: 7674 nanoseconds
    // Thời gian thực thi tìm kiếm nhị phân: 1719 nanoseconds
    // Thời gian thực thi tìm kiếm trên cây: 135804 nanoseconds
    // Số lượng input:1000000
    // Thời gian thực thi tìm kiếm tuần tự: 45646 nanoseconds
    // Thời gian thực thi tìm kiếm nhị phân: 8148 nanoseconds
    // Thời gian thực thi tìm kiếm trên cây: 28152 nanoseconds
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        Random random = new Random(123);

        int[] inputSize = { 10000, 100000, 1000000 };
        for (int e : inputSize) {
            int arraySize = e;
            int[] randomArray = new int[arraySize];
            for (int i = 0; i < arraySize; i++) {
                randomArray[i] = random.nextInt(e);
            }
            randomArray[555] = 555;

            for (int i = 0; i < arraySize; i++) {
                tree.insert(randomArray[i]);
            }

            int[] randomArraySorted = Arrays.copyOf(randomArray, randomArray.length);
            Arrays.sort(randomArraySorted);

            long sStartTime = System.nanoTime();
            sequentialSearch(randomArray, 555);
            long sEndTime = System.nanoTime();
            System.out.println("Số lượng input:" + e);
            System.out.println("Thời gian thực thi tìm kiếm tuần tự: " + (sEndTime - sStartTime) + " nanoseconds");

            long bStartTime = System.nanoTime();
            binarySearch(randomArraySorted, 555);
            long bEndTime = System.nanoTime();
            System.out.println("Thời gian thực thi tìm kiếm nhị phân: " + (bEndTime - bStartTime) + " nanoseconds");

            long tStartTime = System.nanoTime();
            tree.search(555);
            long tEndTime = System.nanoTime();
            System.out.println("Thời gian thực thi tìm kiếm trên cây: " + (tEndTime - tStartTime) + " nanoseconds");
        }

    }

    public static int sequentialSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i; // Trả về chỉ số của phần tử được tìm thấy
            }
        }
        return -1; // Trả về -1 nếu không tìm thấy phần tử
    }

    public static int binarySearch(int arr[], int x) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] == x)
                return m;
            if (arr[m] < x)
                l = m + 1;
            else
                r = m - 1;
        }
        return -1;
    }

}
