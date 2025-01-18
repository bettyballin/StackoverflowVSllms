import java.lang.String;
public class B_2 {
    public static void main(String[] args) {
        A a = new A(); // Or assign an instance of B as needed

        if(a instanceof B) {
            // Do something if "a" is an instance of class B.
        } else {
            // Otherwise, simply assume it to be a regular 'A'.
        }
    }
}

class A {
}

class B extends A {
}