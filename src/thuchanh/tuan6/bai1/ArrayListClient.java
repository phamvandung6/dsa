package thuchanh.tuan6.bai1;

import data_structure_template.array_list.SimpleArrayList;

public class ArrayListClient {
    public static void main(String[] args) {
        SimpleArrayList<Integer> arrList = new SimpleArrayList<>();
        arrList.addFirst(3);
        arrList.addFirst(2);
        arrList.addFirst(1);

        System.out.println(arrList.toString());
        System.out.println(arrList.search(2));
    }

    // Output:
    // [1, 2, 3]
    // true
}
