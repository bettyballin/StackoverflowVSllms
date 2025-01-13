/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;

class Filter {
    private String field;
    private String value;

    public Filter(String string, String string2) {
        this.field = string;
        this.value = string2;
    }

    public List<Record> apply(List<Record> list) {
        ArrayList<Record> arrayList = new ArrayList<Record>();
        for (Record record : list) {
            if (!record.getName().equals(this.value)) continue;
            arrayList.add(record);
        }
        return arrayList;
    }
}
