public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(0); // Pauses the current thread for at least 1ms (prevents JIT optimization)
    }
}