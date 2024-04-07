package thuchanh.tuan4.luyentap1.bai2;

import java.util.Stack;

public class Client {
    // Hàm encodeString để mã hóa một chuỗi theo quy tắc đã nêu
    public static String encodeString(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        // Duyệt qua từng ký tự trong chuỗi
        for (char ch : s.toCharArray()) {
            // Kiểm tra xem ngăn xếp có trống không hoặc ký tự đầu ngăn xếp
            // có giống với ký tự hiện tại không
            if (stack.isEmpty() || stack.peek() == ch) {
                // Nếu có, thêm ký tự vào ngăn xếp
                stack.push(ch);
            } else {
                // Lấy số lượng ký tự hiện tại trong ngăn xếp
                int count = stack.size();
                result.append(stack.peek()).append(count);
                stack.clear();
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) {
            int count = stack.size();
            result.append(stack.peek()).append(count);
            stack.clear();
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String inputString = "aaabbbc";
        String encodedString = encodeString(inputString); // Mã hóa chuỗi và lưu vào biến encodedString
        System.out.println(encodedString); // In ra chuỗi đã mã hóa
    }
}