import java.lang.String;

public class LambdaExample {
    // Function type
    interface StringToInt {
        int apply(String s);
    }

    public static void main(String[] args) {
        // Lambda expression
        StringToInt length = s -> s.length();

        // Using the lambda expression
        int lengthOfHello = length.apply("Hello");
        System.out.println(lengthOfHello);
    }
}