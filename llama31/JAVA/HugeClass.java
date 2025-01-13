import java.lang.String;

// Before refactoring
public class HugeClass {
    public void doEverything() {
        // 1000 lines of code
    }
}

// After refactoring
class ServiceA {
    public void doSomething() {}
}

class ServiceB {
    public void doSomethingElse() {}
}

public class HugeClassRefactored {
    private ServiceA serviceA;
    private ServiceB serviceB;

    public HugeClassRefactored() {
        this.serviceA = new ServiceA();
        this.serviceB = new ServiceB();
    }

    public void doSomethingSpecific() {
        serviceA.doSomething();
        serviceB.doSomethingElse();
    }

    public static void main(String[] args) {
        HugeClassRefactored hugeClassRefactored = new HugeClassRefactored();
        hugeClassRefactored.doSomethingSpecific();
    }
}