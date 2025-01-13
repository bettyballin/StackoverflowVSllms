import java.lang.String;
// Example Java code to demonstrate JVM stack operations
public class StackExample {
    public static void main(String[] args) {
        int x = 5; // push 5 onto the stack
        int y = 3; // push 3 onto the stack
        int result = add(x, y); // invoke add method, popping x and y from the stack
        System.out.println(result); // print the result
    }

    public static int add(int a, int b) {
        return a + b; // perform addition, pushing the result onto the stack
    }
}