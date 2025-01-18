import java.lang.String;
import java.lang.reflect.Field;

public class is_1 {

    public static void foo(Outer.Inner inner) throws IllegalAccessException, NoSuchFieldException {
        Field outerInstance = Outer.Inner.class.getDeclaredField("this$0");
        outerInstance.setAccessible(true);
        Outer outer = (Outer) outerInstance.get(inner);
        System.out.println("The outer class is: " + outer);
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        try {
            foo(inner);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Outer {
    public class Inner {
    }

    @Override
    public String toString() {
        return "I am an instance of Outer";
    }
}