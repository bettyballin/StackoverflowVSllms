public class None_94_94 {
    // Before JIT compilation
    int x = 5 + 3;

    // After JIT compilation (constant folding)
    // int x = 8; // Commented out to avoid duplicate variable declaration

    public static void main(String[] args) {
        None_94 instance = new None_94();
        System.out.println("Before JIT compilation: " + instance.x);
    }
}