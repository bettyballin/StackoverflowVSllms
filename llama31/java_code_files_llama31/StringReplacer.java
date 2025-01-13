/*
 * Decompiled with CFR 0.152.
 */
public class StringReplacer {
    public static void main(String[] stringArray) {
        String string = "VALUES (12654, 'somestuff', 'some description here', 'filename.swf', '5', 0, 1, '', '500', '300', 'filename.png', '3', '1');";
        String string2 = string.replaceAll("'([^']*)\\.(swf|png)'", "'folder/$1.$2'");
        System.out.println(string2);
    }
}
