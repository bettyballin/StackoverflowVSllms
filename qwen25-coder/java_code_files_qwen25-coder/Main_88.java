import java.lang.String;
class DoublePair {
    public final double firstVar;
    public final double secondVar;

    public DoublePair(double first, double second) {
        this.firstVar = first;
        this.secondVar = second;
    }
}

public class Main_88 {

    public static DoublePair calculateSomeDoubles() {
        // Example calculation logic
        return new DoublePair(3.14, 2.71);
    }

    public static void main(String[] args) {
        DoublePair result = calculateSomeDoubles();
        double firstVar = result.firstVar;
        double secondVar = result.secondVar;

        System.out.println("First Variable: " + firstVar);
        System.out.println("Second Variable: " + secondVar);
    }
}