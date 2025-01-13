import java.util.ArrayList;
import java.util.List;

class MyObject {
    private String field1;
    private String field2;

    public MyObject(String field1, String field2) {
        this.field1 = field1;
        this.field2 = field2;
    }

    public String getField1() {
        return field1;
    }

    public String getField2() {
        return field2;
    }
}

public class Main_736 {
    public static void main(String[] args) {
        List<MyObject> list = new ArrayList<>();
        list.add(new MyObject("field1-1", "field2-1"));
        list.add(new MyObject("field1-2", "field2-2"));

        MyObject target = new MyObject("field1-1", "field2-1");

        boolean contains = list.stream()
                .anyMatch(obj -> obj.getField1().equals(target.getField1()) 
                        && obj.getField2().equals(target.getField2()));

        System.out.println(contains);
    }
}