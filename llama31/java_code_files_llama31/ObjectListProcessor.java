/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.stream.Collectors;

public class ObjectListProcessor {
    public static void main(String[] stringArray) {
        List<YourObject> list = List.of(new YourObject(), new YourObject(), new YourObject());
        List list2 = list.stream().distinct().collect(Collectors.toList());
        System.out.println(list2);
    }
}
