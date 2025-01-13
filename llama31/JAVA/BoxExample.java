// Define the Box class
class Box<T> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}

public class BoxExample {
    Box<String> stringBox = new Box<>("hello");

    public static void main(String[] args) {
        BoxExample be = new BoxExample();
        System.out.println(be.stringBox.getValue()); // prints "hello"
    }
}