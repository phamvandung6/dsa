// package thuchanh.tuan7.bai4;

// import java.util.Random;

// import thuchanh.tuan7.bai1.ArrEntry;

// public class Client {
//     public static void main(String[] args) {
        
//     }
//     public static <K, E> ArrEntry<K, E>[] generateRandomArrEntry(int n) {
//         Random random = new Random();
//         ArrEntry<K, E>[] arr = new ArrEntry[n];

//         for (int i = 0; i < n; i++) {
//             // Tạo giá trị ngẫu nhiên cho key và element
//             K key = (K) random.nextInt();
//             E element = (E) random.nextDouble();

//             // Tạo đối tượng ArrEntry và thêm vào mảng
//             arr[i] = new ArrEntry<>(key, element);
//         }

//         return arr;
//     }
// }
