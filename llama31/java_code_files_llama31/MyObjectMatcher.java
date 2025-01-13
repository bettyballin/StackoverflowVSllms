/*
 * Decompiled with CFR 0.152.
 */
import java.util.function.Predicate;
import java.util.stream.Stream;

public class MyObjectMatcher {
    private MyObject target = new MyObject();
    private MyObject[] list = new MyObject[]{new MyObject(), new MyObject()};

    public void match() {
        Predicate<MyObject> predicate = myObject -> myObject.getField1().equals(this.target.getField1()) && myObject.getField2().equals(this.target.getField2());
        boolean bl = Stream.of(this.list).anyMatch(predicate);
        System.out.println(bl);
    }

    public static void main(String[] stringArray) {
        MyObjectMatcher myObjectMatcher = new MyObjectMatcher();
        myObjectMatcher.match();
    }
}
