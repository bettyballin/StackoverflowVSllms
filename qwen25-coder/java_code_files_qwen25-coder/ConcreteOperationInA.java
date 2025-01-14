import java.lang.String;
// Specific implementation in Application A that is not available in B

interface Operation {
    void perform();
}

public class ConcreteOperationInA implements Operation {
    @Override
    public void perform() {
        System.out.println("Performing operation from Application A");
    }

    public static void main(String[] args) {
    }
}