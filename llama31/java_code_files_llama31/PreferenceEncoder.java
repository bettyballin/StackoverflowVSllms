/*
 * Decompiled with CFR 0.152.
 */
public class PreferenceEncoder {
    public static void main(String[] stringArray) {
        CharSequence[] charSequenceArray = new String[]{"value1", "value2", "value3"};
        String string = String.join((CharSequence)",", charSequenceArray);
        System.out.println("Encoded string: " + string);
        String string2 = string;
        String[] stringArray2 = string2.split(",");
        System.out.println("Decoded values:");
        for (String string3 : stringArray2) {
            System.out.println(string3);
        }
    }
}
