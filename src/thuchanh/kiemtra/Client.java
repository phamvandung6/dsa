package thuchanh.kiemtra;

public class Client {
    public static void main(String[] args) {
        String input = "( ( 50 - ( ( 8 - 4 ) * ( 2 + 3 ) ) ) + ( 3 * 4 ) )";
        FormulaEval fe = new FormulaEval();
        double result = fe.eval(input);
        System.out.println(result);
    }
}
