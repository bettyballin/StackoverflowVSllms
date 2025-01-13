/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;

public class ListProcessor {
    public <T extends MyType> void processList(List<T> list, T t) {
        list.add(t);
    }

    public static void main(String[] stringArray) {
        ListProcessor listProcessor = new ListProcessor();
        ArrayList arrayList = new ArrayList();
        MyType myType = new MyType();
        listProcessor.processList(arrayList, myType);
    }
}
