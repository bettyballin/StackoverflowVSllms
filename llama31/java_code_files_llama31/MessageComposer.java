/*
 * Decompiled with CFR 0.152.
 */
public class MessageComposer {
    String message = "Hello\u001eWorld\u0003";

    public static void main(String[] stringArray) {
        MessageComposer messageComposer = new MessageComposer();
        System.out.println(messageComposer.message);
    }
}
