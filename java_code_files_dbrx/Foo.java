import java.lang.String;
public class Foo {
    class Foo {
        private final Object bar;

        public Foo(final Object pBar) {
            this.bar = pBar == null ? new Object() : pBar;
        }
    }

    public static void main(String[] args) {
    }
}