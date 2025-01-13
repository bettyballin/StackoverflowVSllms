import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

// Define the dependencies
interface Dependency1 {
    void doSomething();
}

interface Dependency2 {
    void doSomethingElse();
}

public class MyClass_16 {
    private final Dependency1 dep1;
    private final Dependency2 dep2;

    public MyClass(Dependency1 dep1, Dependency2 dep2) {
        this.dep1 = dep1;
        this.dep2 = dep2;
    }

    public void doSomething() {
        dep1.doSomething();
        dep2.doSomethingElse();
    }
}

@RunWith(MockitoJUnitRunner.class)
public class MyClass_16Test {
    @Test
    public void testDoSomething() {
        // Arrange
        Dependency1 dep1 = mock(Dependency1.class);
        Dependency2 dep2 = mock(Dependency2.class);
        MyClass myClass = new MyClass(dep1, dep2);

        // Act
        myClass.doSomething();

        // Assert
        verify(dep1).doSomething();
        verify(dep2).doSomethingElse();
    }

    public static void main(String[] args) {
    }
}