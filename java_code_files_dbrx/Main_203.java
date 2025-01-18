public class Main {
    public static void main(String[] args) {
        Thread.yield(); // Causes current thread to yield execution, prevent optimization
    }
}