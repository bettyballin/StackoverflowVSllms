/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MyObjectRepository {
    public Collection<MyObject> getMyObjects() {
        ArrayList arrayList = new ArrayList();
        return Collections.unmodifiableList(arrayList);
    }

    public static void main(String[] stringArray) {
    }
}
