/*
 * Decompiled with CFR 0.152.
 */
public class Main_261 {
    public static void main(String[] stringArray) {
        String string = "-this--is---a-test--";
        String string2 = string.replaceAll("^-+|-+$", "").replaceAll("-+", "-");
        System.out.println(string2);
    }
}
