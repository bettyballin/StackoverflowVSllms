// Assume A is the class to be tested and it has a method interactWithB that calls B's doQuery() method.
public class ATest {
    public static void main(String[] args) {
        // Create mock instance of B
        B bMock = new BMock();

        // Create an instance of A and pass our mock B to it
        A a = new A(bMock);

        // Call the method on A that operates on B
        a.interactWithB();

        // Since we're not using a testing framework, we'll just print out whether methods were called
        // For the purpose of this example, BMock will track method calls itself

        BMock bMockInstance = (BMock) bMock;
        if (bMockInstance.connectCalled && bMockInstance.doQueryCalled) {
            System.out.println("Test passed: methods called as expected.");
        } else {
            System.out.println("Test failed: methods not called as expected.");
        }
    }
}

// Dummy classes for demonstration purpose
class A {
    private final B b;

    public A(B b) {
        this.b = b;
    }

    void interactWithB() {
        b.connect();  // Mock will do nothing by default without stubbing behavior
        b.doQuery("SELECT * FROM records");
    }
}

interface B {
    void connect();
    Record[] doQuery(String query);
}

class BMock implements B {
    public boolean connectCalled = false;
    public boolean doQueryCalled = false;

    @Override
    public void connect() {
        connectCalled = true;
    }

    @Override
    public Record[] doQuery(String query) {
        if ("SELECT * FROM records".equals(query)) {
            doQueryCalled = true;
            return new Record[] {};
        }
        return null;
    }
}

class Record {}