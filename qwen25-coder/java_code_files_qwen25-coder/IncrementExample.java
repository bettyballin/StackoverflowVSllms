import java.lang.String;
public class IncrementExample {
    int x = 5;
    int y = x++; // y is assigned 5, then x becomes 6
    int z = ++x; // x is incremented to 7, then z is assigned 7

    public IncrementExample() {
        System.out.println("After x++: x=" + x + ", y=" + y);
        System.out.println("After ++x: x=" + x + ", z=" + z);
    }

    public static void main(String[] args) {
        new IncrementExample();
    }
}