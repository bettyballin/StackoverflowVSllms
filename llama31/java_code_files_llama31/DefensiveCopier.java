/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;

public class DefensiveCopier {
    public void someFunction(List list) {
        ArrayList arrayList = new ArrayList(list);
    }

    public static void main(String[] stringArray) {
        DefensiveCopier defensiveCopier = new DefensiveCopier();
        ArrayList arrayList = new ArrayList();
        defensiveCopier.someFunction(arrayList);
    }
}
