/*
 * Decompiled with CFR 0.152.
 */
public class Main_244 {
    public static void main(String[] stringArray) {
        String string = "a aa[bb b]c cc[d dd]e ee[f ff]";
        String string2 = string.replaceAll("\\s+(?![^\\[\\]]*\\])", "");
        System.out.println(string2);
    }
}
