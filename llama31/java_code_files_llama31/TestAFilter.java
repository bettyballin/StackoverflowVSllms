/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;

public class TestAFilter {
    public static void main(String[] stringArray) {
        ArrayList arrayList = new ArrayList();
        ArrayList<TestB> arrayList2 = new ArrayList<TestB>();
        for (TestA testA : arrayList) {
            if (!(testA instanceof TestB)) continue;
            arrayList2.add((TestB)testA);
        }
    }
}
