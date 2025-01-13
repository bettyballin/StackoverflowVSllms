/*
 * Decompiled with CFR 0.152.
 */
public class MmsMessageBuilder {
    public static void main(String[] stringArray) {
        MessagePart messagePart = new MessagePart("text/plain", "Hello World!".getBytes(), "UTF-8", "X-Mms-Application-ID: generic");
    }
}
