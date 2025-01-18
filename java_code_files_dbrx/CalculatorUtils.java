import java.lang.String;

public class CalculatorUtils {
    public int calculateSumAndMultiply(int a, int b){
        return (sum(a,b) * multiply(a,b)); // Here sum() and multiply() can be separate functions that do atomic tasks
    }

    public int sum(int a, int b){
        return a + b;
    }

    public int multiply(int a, int b){
        return a * b;
    }

    public static void main(String[] args) {
    }
}