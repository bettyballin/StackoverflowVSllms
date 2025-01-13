/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;

public class Main_736 {
    public static void main(String[] stringArray) {
        ArrayList<MyObject> arrayList = new ArrayList<MyObject>();
        arrayList.add(new MyObject("field1-1", "field2-1"));
        arrayList.add(new MyObject("field1-2", "field2-2"));
        MyObject myObject = new MyObject("field1-1", "field2-1");
        boolean bl = arrayList.stream().anyMatch(myObject2 -> myObject2.getField1().equals(myObject.getField1()) && myObject2.getField2().equals(myObject.getField2()));
        System.out.println(bl);
    }
}
