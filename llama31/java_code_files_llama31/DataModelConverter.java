/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;

public class DataModelConverter {
    public List<Stuff> convertDataModelToList(DataModel dataModel) {
        ArrayList<Stuff> arrayList = new ArrayList<Stuff>();
        for (int i = 0; i < dataModel.getRowCount(); ++i) {
            arrayList.add((Stuff)dataModel.getRowData(i));
        }
        return arrayList;
    }

    public static void main(String[] stringArray) {
    }
}
