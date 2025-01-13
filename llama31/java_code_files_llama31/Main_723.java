/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Date;

public class Main_723 {
    public static void main(String[] stringArray) {
        ArrayList<MyObject> arrayList = new ArrayList<MyObject>();
        MyObject myObject = new MyObject();
        myObject.setDate(new Date(10000L));
        arrayList.add(myObject);
        MyObject myObject2 = new MyObject();
        myObject2.setDate(new Date(20000L));
        arrayList.add(myObject2);
        MyObject myObject3 = (MyObject)arrayList.get(0);
        MyObject myObject4 = (MyObject)arrayList.get(arrayList.size() - 1);
        if (myObject3.getDate().after(myObject4.getDate())) {
            System.out.println("Incorrect ordering");
        }
    }
}
