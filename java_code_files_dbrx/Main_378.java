public class Main {
    public void yourMethod() {
        long startTime = System.currentTimeMillis();

        // Your function to measure here
        performComputation();

        long millis = System.currentTimeMillis() - startTime;

        System.out.println("Method execution took " + millis + " ms");
    }

    public void performComputation() {
        // Your code here
    }

    public static void main(String[] args) {
        Main obj = new Main();
        obj.yourMethod();
    }
}