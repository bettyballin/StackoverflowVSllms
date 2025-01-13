// Define the MyClass with a getX method to make the code compile
class MyClass {
    public int getX() {
        return 0; // A default return value for demonstration purposes
    }
}

public class Main_551_551 {
    public static void main(String[] args) {
        MyClass obj = null;
        try {
            System.out.println(obj.getX()); // This will throw NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException");
        }
    }
}