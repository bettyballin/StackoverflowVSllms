import java.lang.String;

public class MyClass_26 {
    private int x;

    public MyClass(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public static void main(String[] args) {
        MyClass obj = new MyClass(10); // obj is a reference to an object on the heap
        System.out.println(obj.getX()); // accessing the object's data through the reference
    }
}