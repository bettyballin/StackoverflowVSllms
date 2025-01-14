import java.lang.String;
import java.lang.reflect.Field;

public class Outer {
    public static void foo(Inner inner) throws NoSuchFieldException, IllegalAccessException {
        // Use reflection to get the outer class instance
        Field outerThisField = Inner.class.getDeclaredField("this$0");
        outerThisField.setAccessible(true);
        Outer outerInstance = (Outer) outerThisField.get(inner);
        System.out.println("The outer class is: " + outerInstance);
    }

    public class Inner {
        // No additional methods needed
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        Inner inner = outer.new Inner();
        try {
            foo(inner);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}