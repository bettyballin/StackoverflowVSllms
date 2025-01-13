/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class DaoTemplate {
    DaoTemplate() {
    }

    public List<MyObject> query() {
        ArrayList<MyObject> arrayList = new ArrayList<MyObject>();
        arrayList.add(new MyObject(new Date(1643723400000L)));
        arrayList.add(new MyObject(new Date(1646315200000L)));
        arrayList.add(new MyObject(new Date(1648907000000L)));
        return arrayList;
    }
}
