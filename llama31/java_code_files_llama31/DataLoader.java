/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataLoader {
    public static void main(String[] stringArray) {
        List<MyDomainClass> list = MyDomainClass.findAllByMyCriteria();
        HashMap<Long, MyDomainClass> hashMap = new HashMap<Long, MyDomainClass>();
        for (MyDomainClass object : list) {
            MyDomainClass myDomainClass = DataLoader.sanitizeItem(object);
            hashMap.put(myDomainClass.getId(), myDomainClass);
        }
        HashMap hashMap2 = new HashMap();
        for (Map.Entry entry : hashMap.entrySet()) {
            hashMap2.put(((MyDomainClass)entry.getValue()).getMyProperty(), (MyDomainClass)entry.getValue());
        }
    }

    private static MyDomainClass sanitizeItem(MyDomainClass myDomainClass) {
        return myDomainClass;
    }
}
