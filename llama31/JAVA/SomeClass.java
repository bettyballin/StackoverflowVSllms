// Importing java.lang package is unnecessary as it's imported by default
public class SomeClass {
    public SomeClass() {
        System.out.println("Constructor started");
        try {
            Thread.sleep(1000); // simulate some work
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Constructor finished");
    }
}

public class Main {
    public static void main(String[] args) {
        SomeClass someObject = new SomeClass();
        System.out.println(someObject == null ? "null" : "non-null");
    }
}