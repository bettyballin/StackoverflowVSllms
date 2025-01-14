import java.util.List;

class Parent_5<T> {
    public void print(List<T> list) {
        System.out.println("Parent");
    }
}

public class Child extends Parent_5<String> {
    @Override
    public void print(List<String> list) {
        System.out.println("Child");
    }

    public static void main(String[] args) {
    }
}