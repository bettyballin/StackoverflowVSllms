import java.util.ArrayList;
import java.util.List;

public class MyTypeCollectionorMyTypeListdependingonthecontextinwhichthiscodeisbeingused {
    List<MyType> listOfMyType = new ArrayList<>();

    MyType myTypeInstance = new MyType();

    {
        listOfMyType.add(myTypeInstance);
    }

    public static void main(String[] args) {
    }
}

class MyType {
    // Definition of MyType class
}