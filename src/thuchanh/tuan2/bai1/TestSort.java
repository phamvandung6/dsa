package thuchanh.tuan2.bai1;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class TestSort {
    public static void main(String[] args) {
        // a. Với dãy số nguyên có kích thước nhỏ được nhập từ bàn phím.
        System.out.println("Câu a: ");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập độ dài của mảng: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
        arr[i] = scanner.nextInt();
        }
        SortingAlgorithmsEvaluation.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
        scanner.close();

        // b. Sinh N số ngẫu nhiên có giá trị trong [1, 10^6].
        System.out.println("Câu b: ");
        int N = 10;
        int[] randomNumbers = generateRandomNumbers(N);
        System.out.println("Random numbers: " + Arrays.toString(randomNumbers));

        // c. Triển khai các thuật toán sắp xếp nổi bọt, sắp xếp chọn, sắp xếp chèn, sắp
        // xếp trộn và sắp xếp nhanh với
        // dãy số ở các ý trên.
        System.out.println("Câu c: ");
        // bubleSort
        int[] bubleArr = randomNumbers.clone();
        SortingAlgorithmsEvaluation.bubbleSort(bubleArr);
        System.out.println("Thuật toán sắp xếp nội bọt: "
                + Arrays.toString(bubleArr));

        // selectionSort
        int[] selectionArr = randomNumbers.clone();
        SortingAlgorithmsEvaluation.selectionSort(selectionArr);
        System.out.println("Thuật toán sắp xếp chọn: "
                + Arrays.toString(selectionArr));

        // insertionSort
        int[] insertionArr = randomNumbers.clone();
        SortingAlgorithmsEvaluation.insertionSort(insertionArr);
        System.out.println("Thuật toán sắp xếp chèn: "
                + Arrays.toString(insertionArr));

        // quickSort
        int[] quickArr = randomNumbers.clone();
        SortingAlgorithmsEvaluation.quickSort(quickArr);
        System.out.println("Thuật toán sắp xếp trộn: "
                + Arrays.toString(quickArr));

        // mergeSort
        int[] mergeArr = randomNumbers.clone();
        SortingAlgorithmsEvaluation.mergeSort(mergeArr);
        System.out.println("Thuật toán sắp xếp nhanh: "
                + Arrays.toString(mergeArr));

        // d) In ra trạng thái của dãy số sau mỗi vòng lặp để thấy được sự thay đổi. Đếm
        // số lần so sánh và số lần đổi chỗ.
        System.out.println("Câu d: ");
        int[] arr_d = { 4, 5, 2, 3, 7, 1, 6 };
        SortingCount.bubbleSort(arr_d);

        // e) Đo thời gian thực thi của mỗi thuật toán với N nhận các giá trị N = 100,
        // 1000, 10000 và 100000. Từ đó, rút ra nhận xét và nêu kết luận về việc lựa
        // chọn các thuật toán thích hợp với từng giá trị N cụ thể và giá
        // trị của miền dữ liệu.
        System.out.println("Câu e: Đo thời gian thực thi của thuật toán sắp xếp với 100, 1000, 10000, 100000 phần tử ");
        int[] arr_100 = generateRandomNumbers(100);
        int[] arr_1000 = generateRandomNumbers(1000);
        int[] arr_10000 = generateRandomNumbers(10000);
        int[] arr_100000 = generateRandomNumbers(100000);

        SortingTime.bubbleSort(arr_100.clone());
        SortingTime.bubbleSort(arr_1000.clone());
        SortingTime.bubbleSort(arr_10000.clone());
        SortingTime.bubbleSort(arr_100000.clone());

        SortingTime.quickSort(arr_100);
        SortingTime.quickSort(arr_1000);
        SortingTime.quickSort(arr_10000);
        SortingTime.quickSort(arr_100000);

        // SortingTime.selectionSort(arr_1000.clone());
        // SortingTime.insertionSort(arr_10000.clone());
        // SortingTime.quickSort(arr_100000.clone());

    }

    public static int[] generateRandomNumbers(int N) {
        int[] randomNumbers = new int[N];
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            randomNumbers[i] = random.nextInt(1000000) + 1; // Sinh số ngẫu nhiên từ 1 đến 10^6
        }
        return randomNumbers;
    }
}
