import java.util.List;

public class MyTypePrinter {

    void printElements(List<? extends MyType> listOfMyType) {
        for (MyType myType : listOfMyType) {
            System.out.println(myType);
        }
    }

    public static void main(String[] args) {
    }

    class MyType {
        // You can define fields and methods for MyType here
    }
}