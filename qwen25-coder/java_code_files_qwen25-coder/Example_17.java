import java.lang.String;
public class Example_17 {
    public static void main(String[] args) {
        while (true) {
            try {
                Foo foo = new Foo();
                // ... do something with foo
            } catch (Exception e) {
                e.printStackTrace();
            }
            // No need to set foo to null explicitly.
        }
    }
}

class Foo {
    // Some class implementation
}