import java.lang.String;
class MyClass {
    int value;

    public MyClass(int v) {
        this.value = v;
    }

    public void modifyValue(int newValue) {
        this.value = newValue;
    }
}

public class Main_81 {
    public static void main(String[] args) {
        MyClass obj = new MyClass(5);
        changeObjectReference(obj); // This will modify the object on the heap
        System.out.println("obj.value after changeObjectReference: " + obj.value);

        int value = 10;
        changePrimitive(value); // This will not modify 'value'
        System.out.println("value after changePrimitive: " + value);
    }

    public static void changeObjectReference(MyClass o) {
        o.modifyValue(20); // Modifies the object on the heap
    }

    public static void changePrimitive(int v) {
        v = 30; // Does not affect the original 'value' in main()
    }
}