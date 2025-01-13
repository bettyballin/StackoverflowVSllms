/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.stream.Collectors;

public class ObjectTypeMapper {
    public static void main(String[] stringArray) {
        List<ObjectType> list = List.of(new ObjectType(), new ObjectType());
        List list2 = list.stream().map(ObjectType.class::cast).collect(Collectors.toList());
    }
}
