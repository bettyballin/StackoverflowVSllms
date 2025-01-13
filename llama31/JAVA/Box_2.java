// Define the Box class
class Box {
    private Object value;

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }
}

public class Box_2_2 {
    public static void main(String[] args) {
        Box box = new Box();
        box.setValue("Hello");
        String value = (String) box.getValue();
        System.out.println(value);  // prints "Hello"
    }
}