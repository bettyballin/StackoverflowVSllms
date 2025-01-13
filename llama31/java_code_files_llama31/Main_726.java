/*
 * Decompiled with CFR 0.152.
 */
public class Main_726 {
    public static void main(String[] stringArray) {
        String string = "MESSAGE\nheader:value\n\nbody\u0000";
        string = string.replace("\u0000", "\\x00");
        System.out.println(string);
    }
}
