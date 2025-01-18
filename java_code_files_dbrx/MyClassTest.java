public class MyClassTest {

    public void myMethodShouldThrowIllegalArgumentException() {
        MyClass objectUnderTest = new MyClass();
        // Create a MockDependency that returns -1 for getAge()
        MockDependency mockDependency = new MockDependency() {
            @Override
            public int getAge() {
                return -1;
            }
        };

        objectUnderTest.setDependency(mockDependency);

        try {
            objectUnderTest.myMethod();
            throw new AssertionError("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            // Expected exception was thrown, test passes
            System.out.println("Test passed: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        MyClassTest test = new MyClassTest();
        test.myMethodShouldThrowIllegalArgumentException();
    }
}

class MyClass {
    private MockDependency dependency;

    public void setDependency(MockDependency dependency) {
        this.dependency = dependency;
    }

    public void myMethod() {
        if (dependency.getAge() < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        // Additional logic can be added here if necessary
    }
}

class MockDependency {
    public int getAge() {
        return 0; // Default implementation
    }
}