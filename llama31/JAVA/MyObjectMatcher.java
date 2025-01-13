import java.util.function.Predicate;
import java.util.stream.Stream;

class MyObject {
    private String field1;
    private String field2;

    public String getField1() {
        return field1;
    }

    public String getField2() {
        return field2;
    }
}

public class MyObjectMatcher {
    private MyObject target;
    private MyObject[] list;

    public MyObjectMatcher() {
        // Initialize target and list for demonstration purposes
        target = new MyObject();
        list = new MyObject[]{new MyObject(), new MyObject()};
    }

    public void match() {
        Predicate<MyObject> predicate = obj -> obj.getField1().equals(target.getField1()) 
                && obj.getField2().equals(target.getField2());

        boolean contains = Stream.of(list).anyMatch(predicate);
        System.out.println(contains);
    }

    public static void main(String[] args) {
        MyObjectMatcher matcher = new MyObjectMatcher();
        matcher.match();
    }
}