import java.lang.String;
public class Test_9 {
    public static void main(String[] args) {
        try {
            Foo foo = new Foo();
            System.out.println("Created foo");
        } catch (Exception e) {
        }
        System.gc();
        System.runFinalization();
    }
}

class Foo {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Foo finalized");
    }
}