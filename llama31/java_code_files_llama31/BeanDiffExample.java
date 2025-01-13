/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;

public class BeanDiffExample {
    public static void main(String[] stringArray) {
        MyBean myBean = new MyBean("name1", 1);
        MyBean myBean2 = new MyBean("name2", 2);
        List list = BeanDiff.diff((MyBean)myBean, (MyBean)myBean2);
        for (FieldDiff fieldDiff : list) {
            System.out.println(fieldDiff.getFieldName() + ": " + String.valueOf(fieldDiff.getOldValue()) + " -> " + String.valueOf(fieldDiff.getNewValue()));
        }
    }
}
