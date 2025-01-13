import java.util.List;
import java.util.ArrayList;

class MyType {}

public class JavaMyTypeContainer {
    List<MyType> listOfMyType;

    public JavaMyTypeContainer() {
        listOfMyType = new ArrayList<>();
        MyType myTypeInstance = new MyType();
        listOfMyType.add(myTypeInstance);
    }

    public static void main(String[] args) {
        new JavaMyTypeContainer();
    }
}