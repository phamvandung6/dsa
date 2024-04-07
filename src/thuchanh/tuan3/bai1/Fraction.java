package thuchanh.tuan3.bai1;

public class Fraction {
    private float numerator;
    private float denominator;

    public Fraction(float numerator, float denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction add(Fraction c) {
        if (this.denominator == c.denominator) {
            float newNumerator = this.numerator + c.numerator;
            return new Fraction(newNumerator, this.denominator);
        }
        
        float newNumerator = this.numerator * c.denominator + c.numerator * this.denominator;
        float newDenominator = this.denominator * c.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction minus(Fraction c) {
        if (this.denominator == c.denominator) {
            float newNumerator = this.numerator - c.numerator;
            return new Fraction(newNumerator, this.denominator);
        }
        float newNumerator = this.numerator * c.denominator - c.numerator * this.denominator;
        float newDenominator = this.denominator * c.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction multi(Fraction c) {
        float newNumerator = this.numerator * c.numerator;
        float newDenominator = this.denominator * c.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction divi(Fraction c) {
        float newNumerator = this.numerator * c.denominator;
        float newDenominator = this.denominator * c.numerator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction normalize(Fraction c) {
        float gcd = calculateGCD(c.getNumerator(), c.getDenominator());
        float newNumerator = c.getNumerator() / gcd;
        float newDenominator = c.getDenominator() / gcd;
        return new Fraction(newNumerator, newDenominator);
    }

    private float calculateGCD(float a, float b) {
        while (b != 0) {
            float temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public float getNumerator() {
        return numerator;
    }

    public float getDenominator() {
        return denominator;
    }

    @Override
    public String toString() {
        return this.numerator + "/" + this.denominator;
    }
}