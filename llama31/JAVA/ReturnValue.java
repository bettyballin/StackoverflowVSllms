public class ReturnValue {
    public double firstVar;
    public double secondVar;
}

public class Main {
    public static ReturnValue calculateSomeDoubles() {
        ReturnValue result = new ReturnValue();
        result.firstVar = 10.0;
        result.secondVar = 20.0;
        return result;
    }

    public static void main(String[] args) {
        ReturnValue result = calculateSomeDoubles();
        double firstVar = result.firstVar;
        double secondVar = result.secondVar;
        System.out.println("First var: " + firstVar);
        System.out.println("Second var: " + secondVar);
    }
}