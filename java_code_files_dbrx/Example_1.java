import java.lang.String;
public class Example_1 {
    int x;  // This will also be in memory for every instance created as a data field.

    public Example_1() { // This is the default constructor that would initialize 'x'.
        x = 10;
    }

    public static void main(String[] args) {
        Example_1 ex = new Example_1();   // creates an object in the heap which goes into memory, containing initialized data fields and methods.
    }
}