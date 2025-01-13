/*
 * Decompiled with CFR 0.152.
 */
public class BoxExample {
    Box<String> stringBox = new Box<String>("hello");

    public static void main(String[] stringArray) {
        BoxExample boxExample = new BoxExample();
        System.out.println(boxExample.stringBox.getValue());
    }
}
