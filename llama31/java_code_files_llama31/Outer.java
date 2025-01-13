/*
 * Decompiled with CFR 0.152.
 */
import java.lang.reflect.Field;

public class Outer {
    public static void foo(Inner inner) throws Exception {
        Field field = inner.getClass().getDeclaredField("this$0");
        field.setAccessible(true);
        Outer outer = (Outer)field.get(inner);
        System.out.println("The outer class is: " + String.valueOf(outer));
    }

    public static void main(String[] stringArray) throws Exception {
        Outer outer = new Outer();
        Inner inner = new Inner(outer);
        Outer.foo(inner);
    }

    public class Inner {
        public Inner(Outer outer) {
        }
    }
}
