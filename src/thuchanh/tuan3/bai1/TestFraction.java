package thuchanh.tuan3.bai1;

import java.util.Arrays;
import java.util.Scanner;

public class TestFraction {
    public static void main(String[] args) {
        // Nhập dãy n phân số
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập độ dài của mảng phân số:");
        int n = scanner.nextInt();
        
        Fraction[] fractions = new Fraction[n]; // Replace n with the number of fractions
        for (int i = 0; i < n; i++) {
            System.out.println("Phân số thứ " + i + ":");
            fractions[i] = new Fraction(scanner.nextFloat(), scanner.nextFloat());
        }
        System.out.println("Mảng phân số là: " + Arrays.toString(fractions));

        // In ra phân số ở vị trí thứ v trong dãy
        System.out.println("Nhập vị trí mà muốn lấy phần tử");
        int v = scanner.nextInt();
        System.out.println("Phân số ở vị trí thứ " + v + ": " + fractions[v]);

        // Tính tổng của n phân số, cho kết quả là một phân số đã tối giản
        Fraction sum = sumFractions(fractions);
        System.out.println("Tổng của n phân số là: " + sum);

        Fraction subtract = subtractFractions(fractions);
        System.out.println("Hiệu của n phân số là: " + subtract);

        Fraction multiply = multiplyFractions(fractions);
        System.out.println("Tích của n phân số là: " + multiply);

        Fraction divide = divideFractions(fractions);
        System.out.println("Thương của n phân số là: " + divide);

        System.out.println("Đề bài tự đề xuất: Tìm phân số lớn nhất trong mảng phân số");
        Fraction max = findMaxFraction(fractions);
        System.out.println("Phân số lớn nhất là: " + max);

        scanner.close();
        
    }

    public static Fraction sumFractions(Fraction[] fractions) {
        float sumNumerator = 0;
        float sumDenominator = 1;
        for (Fraction fraction : fractions) {
            sumNumerator = sumNumerator * fraction.getDenominator() + fraction.getNumerator() * sumDenominator;
            sumDenominator *= fraction.getDenominator();
        }
        Fraction sum = new Fraction(sumNumerator, sumDenominator);
        return sum.normalize(sum);
    }

    public static Fraction subtractFractions(Fraction[] fractions) {
        float resultNumerator = fractions[0].getNumerator() * fractions[1].getDenominator()
                - fractions[1].getNumerator() * fractions[0].getDenominator();
        float resultDenominator = fractions[0].getDenominator() * fractions[1].getDenominator();
        Fraction result = new Fraction(resultNumerator, resultDenominator);
        return result.normalize(result);
    }

    public static Fraction multiplyFractions(Fraction[] fractions) {
        float resultNumerator = fractions[0].getNumerator() * fractions[1].getNumerator();
        float resultDenominator = fractions[0].getDenominator() * fractions[1].getDenominator();
        Fraction result = new Fraction(resultNumerator, resultDenominator);
        return result.normalize(result);
    }

    public static Fraction divideFractions(Fraction[] fractions) {
        float resultNumerator = fractions[0].getNumerator() * fractions[1].getDenominator();
        float resultDenominator = fractions[0].getDenominator() * fractions[1].getNumerator();
        Fraction result = new Fraction(resultNumerator, resultDenominator);
        return result.normalize(result);
    }

    public static Fraction findMaxFraction(Fraction[] fractions) {
        Fraction maxFraction = fractions[0];
        for (int i = 1; i < fractions.length; i++) {
            if (fractions[i].getNumerator() * maxFraction.getDenominator() > maxFraction.getNumerator() * fractions[i].getDenominator()) {
                maxFraction = fractions[i];
            }
        }
        return maxFraction;
    }
}