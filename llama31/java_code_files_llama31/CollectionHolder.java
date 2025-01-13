/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Collection;

public class CollectionHolder {
    private volatile Collection<?> myCollection;

    public void init() {
        this.myCollection = new ArrayList();
    }

    public Collection<?> getMyCollection() {
        return this.myCollection;
    }

    public static void main(String[] stringArray) {
        CollectionHolder collectionHolder = new CollectionHolder();
        collectionHolder.init();
        System.out.println(collectionHolder.getMyCollection());
    }
}
