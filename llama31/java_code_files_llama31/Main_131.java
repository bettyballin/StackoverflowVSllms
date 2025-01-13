/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.stream.Collectors;

public class Main_131 {
    public static void main(String[] stringArray) {
        List<TestB> list = List.of(new TestA(), new TestB(), new TestA(), new TestB());
        List list2 = list.stream().filter(TestB.class::isInstance).map(TestB.class::cast).collect(Collectors.toList());
        System.out.println(list2);
    }
}
