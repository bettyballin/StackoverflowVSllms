/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;

public class MyTypeCollection {
    List<MyType> listOfMyType = new ArrayList<MyType>();

    public MyTypeCollection() {
        this.listOfMyType.add(new MyType());
    }

    public static void main(String[] stringArray) {
        new MyTypeCollection();
    }
}
