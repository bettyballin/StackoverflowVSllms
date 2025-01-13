import java.util.concurrent.CopyOnWriteArrayList;

public class MyClass_14_14 {
    private CopyOnWriteArrayList<Integer> vec = new CopyOnWriteArrayList<>();
    private int value; // declare the variable 'value'

    public void someMethod() {
        for (int i = 0; i < vec.size(); i++) {
            vec.set(i, vec.get(i) + value);
        }
    }

    public static void main(String[] args) {
        MyClass_14 obj = new MyClass_14();
        obj.value = 10; // initialize the variable 'value'
        obj.vec.add(5); // add some value to the list
        obj.someMethod();
        System.out.println(obj.vec); // print the updated list
    }
}