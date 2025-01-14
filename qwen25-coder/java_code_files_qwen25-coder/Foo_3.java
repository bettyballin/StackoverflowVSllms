import java.lang.String;
public class Foo_3 {
    class Foo {
        private final Object bar;

        public Foo(Object pBar) {
            if (pBar == null) {
                throw new IllegalArgumentException("bar cannot be null");
            }
            this.bar = pBar;
        }

        // Getter for bar, but no setter to prevent modification
        public Object getBar() {
            return bar;
        }
    }

    public static void main(String[] args) {
    }
}