package thuchanh.tuan7.bai3;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import thuchanh.tuan2.bai1.SortingAlgorithmsEvaluation;

public class Client {
    public static void main(String[] args) {
        int[] arraySizes = { 1000, 10000, 50000, 100000, 1000000, 10000000 };
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (int size : arraySizes) {
            // Tạo mảng ngẫu nhiên với kích thước size
            int[] array = generateRandomArray(size);

            // long bubbleSortTime = testSortTime("bubbleSort", array);
            // long selectionSortTime = testSortTime("selectionSort", array);
            // long insertionSortTime = testSortTime("insertionSort", array);
            long mergeSortTime = testSortTime("mergeSort", array);
            long quickSortTime = testSortTime("quickSort", array);
            long heapSortTime = testSortTime("heapSort", array);

            // Ghi kết quả vào dataset
            // dataset.addValue(bubbleSortTime, "Bubble Sort", String.valueOf(size));
            // dataset.addValue(selectionSortTime, "Selection Sort", String.valueOf(size));
            // dataset.addValue(insertionSortTime, "Insertion Sort", String.valueOf(size));
            dataset.addValue(mergeSortTime, "Merge Sort", String.valueOf(size));
            dataset.addValue(quickSortTime, "Quick Sort", String.valueOf(size));
            dataset.addValue(heapSortTime, "Heap Sort", String.valueOf(size));
        }

        // Tạo đồ thị từ dataset
        JFreeChart chart = ChartFactory.createLineChart("Sort Time Comparison", "Array Size", "Time (ms)", dataset);

        // Hiển thị đồ thị trong một cửa sổ
        ChartFrame frame = new ChartFrame("Sort Time Comparison", chart);
        frame.pack();
        frame.setVisible(true);
    }

    // Phương thức để tạo mảng ngẫu nhiên
    public static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * 1000);
        }
        return array;
    }

    // Phương thức để thực hiện kiểm tra thời gian của một thuật toán sắp xếp
    public static long testSortTime(String sortName, int[] array) {
        SortingAlgorithmsEvaluation sort = new SortingAlgorithmsEvaluation();
        long startTime = System.currentTimeMillis();

        // Tạo một bản sao của mảng đầu vào
        int[] copyArray = array.clone();

        // Sử dụng thuật toán sắp xếp để sắp xếp bản sao của mảng
        sort.sortMethod(sortName, copyArray);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}