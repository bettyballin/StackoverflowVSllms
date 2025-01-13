/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;

public class Main_722 {
    public static void main(String[] stringArray) {
        DaoTemplate daoTemplate = new DaoTemplate();
        List<MyObject> list = daoTemplate.query();
        if (!list.isEmpty()) {
            MyObject myObject = list.get(0);
            System.out.println("Earliest date: " + String.valueOf(myObject.getDate()));
        } else {
            System.out.println("The list is empty.");
        }
    }
}
