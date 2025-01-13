/*
 * Decompiled with CFR 0.152.
 */
public class CustomToStringCreator {
    public void style(Object object, StringBuilder stringBuilder) {
        stringBuilder.append(object.getClass().getSimpleName()).append("[");
        stringBuilder.append("]");
    }

    public static void main(String[] stringArray) {
    }
}
