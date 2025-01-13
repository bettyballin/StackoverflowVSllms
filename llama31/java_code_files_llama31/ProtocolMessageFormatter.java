/*
 * Decompiled with CFR 0.152.
 */
public class ProtocolMessageFormatter {
    String message = String.format("Hello%cWorld%c", Character.valueOf('\u001e'), Character.valueOf('\u0003'));

    public static void main(String[] stringArray) {
        ProtocolMessageFormatter protocolMessageFormatter = new ProtocolMessageFormatter();
    }

    public static class ProtocolConstants {
        public static final char RECORD_SEPARATOR = '\u001e';
        public static final char END_OF_TEXT = '\u0003';
    }
}
