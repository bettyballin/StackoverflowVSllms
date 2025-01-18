import java.lang.String;

// Create interface to abstract ThirdPartyClass functionality
public interface MyInterface {
    void execute(AnotherThirdPartyClass param);
}

// Wrap the third-party library class inside a custom implementation that implements your new interface.
public class MyImplementation implements MyInterface {
    private ThirdPartyClass thirdPartyClass;

    public MyImplementation() {
        this.thirdPartyClass = new ThirdPartyClass(); // Instantiate the third-party library here if they don't support DI/IoC frameworks
    }

    @Override
    public void execute(AnotherThirdPartyClass param) {
       this.thirdPartyClass.execute(param);
    }

    public static void main(String[] args) {
        // You can add code here to test your implementation if needed
    }
}

// Dummy class definitions to make the code executable
class ThirdPartyClass {
    public void execute(AnotherThirdPartyClass param) {
        // Implementation of third-party class method
    }
}

class AnotherThirdPartyClass {
    // Implementation or properties of another third-party class
}