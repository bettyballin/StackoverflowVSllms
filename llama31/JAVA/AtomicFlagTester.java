import java.lang.String;

public class AtomicFlagTester {
    public static void main(String[] args) {
        AtomicFlagTester tester = new AtomicFlagTester();
        tester.testAndSetFlag();
    }

    public void testAndSetFlag() {
        TestAndSet tas = new TestAndSet();
        if (tas.testAndSet()) {
            System.out.println("Successfully set!");
        } else {
            System.out.println("Already set!");
        }
    }
}

class TestAndSet {
    private boolean flag = false;

    public synchronized boolean testAndSet() {
        if (flag) {
            return false;
        } else {
            flag = true;
            return true;
        }
    }
}