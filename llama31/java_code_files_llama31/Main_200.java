/*
 * Decompiled with CFR 0.152.
 */
public class Main_200 {
    public static void main(String[] stringArray) {
        String string = "<root><fieldName>value</fieldName><otherField>otherValue</otherField></root>";
        String string2 = "otherField";
        int n = string.indexOf("<" + string2 + ">") + string2.length() + 2;
        int n2 = string.indexOf("</" + string2 + ">");
        String string3 = string.substring(n, n2);
        assert (string3.equals("otherValue"));
    }
}
