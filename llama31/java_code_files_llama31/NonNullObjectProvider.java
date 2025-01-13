/*
 * Decompiled with CFR 0.152.
 */
public class NonNullObjectProvider {
    public Object methodWhichCannotReturnNull(int n) {
        return new Object();
    }

    public static void main(String[] stringArray) {
        NonNullObjectProvider nonNullObjectProvider = new NonNullObjectProvider();
        System.out.println(nonNullObjectProvider.methodWhichCannotReturnNull(1));
    }
}
