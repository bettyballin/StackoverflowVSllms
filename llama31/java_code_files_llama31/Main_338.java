/*
 * Decompiled with CFR 0.152.
 */
import java.util.LinkedList;
import java.util.ListIterator;

public class Main_338 {
    public static void main(String[] stringArray) {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        ListIterator<String> listIterator = linkedList.listIterator();
        while (listIterator.hasNext()) {
            String string = (String)listIterator.next();
            if (!string.equals("B")) continue;
            listIterator.set("X");
        }
        System.out.println(linkedList);
    }
}
