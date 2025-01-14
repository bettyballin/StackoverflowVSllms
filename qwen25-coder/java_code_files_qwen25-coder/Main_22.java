public class Main {
    public static void main(String[] args) {
        int x = 0;
        x = x + 1; // This compiles to loading x, adding 1, storing result back to x
        x += 1;    // This also generally compiles similarly, potentially using a more direct increment operation
    }
}