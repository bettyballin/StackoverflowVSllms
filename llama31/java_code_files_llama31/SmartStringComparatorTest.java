/*
 * Decompiled with CFR 0.152.
 */
import java.util.Arrays;

public class SmartStringComparatorTest {
    String[] strings = new String[]{"aaa", "bbb 3 ccc", "bbb 12 ccc", "ccc 11", "ddd", "eee 3 ddd jpeg2000 eee", "eee 12 ddd jpeg2000 eee"};

    public static void main(String[] stringArray) {
        SmartStringComparatorTest smartStringComparatorTest = new SmartStringComparatorTest();
        Arrays.sort(smartStringComparatorTest.strings, new SmartStringComparator());
        System.out.println(Arrays.toString(smartStringComparatorTest.strings));
    }
}
