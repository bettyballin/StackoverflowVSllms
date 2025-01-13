// Function type
interface StringToInt {
    int apply(String s);
}

public class Main_517 {
    public static void main(String[] args) {
        // Closure
        StringToInt length = (String s) -> s.length();

        // Using the closure
        int lengthOfHello = length.apply("Hello");
        System.out.println(lengthOfHello);
    }
}