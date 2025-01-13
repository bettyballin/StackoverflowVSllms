/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.stream.Collectors;

public class ViewValueMapper {
    List<Long> toIdsList(List<ViewValue> list) {
        return list.stream().map(ViewValue::getId).collect(Collectors.toList());
    }

    public static void main(String[] stringArray) {
    }
}
