/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.stream.Collectors;

public class Main_536 {
    public static void main(String[] stringArray) {
        List<MyObject> list = List.of(new MyObject(), new MyObject());
        List list2 = list.stream().filter(myObject -> myObject.matchesMyCriteria()).collect(Collectors.toList());
        System.out.println(list2);
    }
}
