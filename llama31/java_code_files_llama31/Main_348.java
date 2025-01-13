/*
 * Decompiled with CFR 0.152.
 */
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main_348 {
    public static void main(String[] stringArray) {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        List list = linkedList.stream().map(string -> string.equals("B") ? "X" : string).collect(Collectors.toList());
        System.out.println(list);
    }
}
