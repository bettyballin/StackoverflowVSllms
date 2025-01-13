import java.lang.String;

public class Foo_1_1 {
    class Foo {
        private final Object bar;

        public Foo(Object pBar) {
            if (pBar == null) {
                bar = new Object();
            } else {
                bar = pBar;
            }
        }

        // No setter method for bar, ensuring it cannot be modified outside the constructor
    }

    public static void main(String[] args) {
    }
}