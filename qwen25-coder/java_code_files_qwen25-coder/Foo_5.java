import org.apache.commons.lang3.builder.EqualsBuilder;

public class Foo_5 {
    public class Bar {
        private final Foo_5 foo;
        private int myInt = 0;

        // Constructor that takes an instance of the outer class
        private Bar(Foo_5 foo) {
            this.foo = foo;
        }

        public boolean equals(Object o) {
            if (o == null || o.getClass() != getClass()) return false;

            Bar other = (Bar) o;
            return new EqualsBuilder()
                .append(foo, other.foo)
                .append(myInt, other.myInt)
                .isEquals();
        }
    }

    // Modified createBar method to pass 'this' to the Bar constructor
    public Bar createBar() {
        return new Bar(this);
    }

    public boolean equals(Object o) {
        // Sensible equals implementation for Foo_5 class
        return super.equals(o);  // Or appropriate logic here
    }

    public static void main(String[] args) {
    }
}