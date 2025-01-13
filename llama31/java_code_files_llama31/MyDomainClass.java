/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;

class MyDomainClass {
    private Long id;
    private String myProperty;

    public MyDomainClass(Long l, String string) {
        this.id = l;
        this.myProperty = string;
    }

    public static List<MyDomainClass> findAllByMyCriteria() {
        ArrayList<MyDomainClass> arrayList = new ArrayList<MyDomainClass>();
        arrayList.add(new MyDomainClass(1L, "Property1"));
        arrayList.add(new MyDomainClass(2L, "Property2"));
        return arrayList;
    }

    public Long getId() {
        return this.id;
    }

    public String getMyProperty() {
        return this.myProperty;
    }
}
