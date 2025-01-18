public class Main {
    public static void main(String[] args) {
        int x = 5;
        int y = ++x;   // x is incremented to 6 first and then assigned to y; so y becomes 6.
        System.out.println("After y = ++x:");
        System.out.println("x = " + x);
        System.out.println("y = " + y);

        x = 5;
        y = x++;  // Here, y gets the original value of x which is 5 (and after this statement x will be 6, though).
        System.out.println("After y = x++:");
        System.out.println("x = " + x);
        System.out.println("y = " + y);
    }
}