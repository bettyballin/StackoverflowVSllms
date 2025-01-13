import java.lang.String;

public interface IFoo {
    void doSomething();
}

public interface IBar {
    // Add methods for IBar interface
}

public class Foo_4 implements IFoo {
    private final IBar bar;

    public Foo(IBar bar) {
        this.bar = bar;
    }

    @Override
    public void doSomething() {
        // Use bar here
    }

    public static void main(String[] args) {
    }
}