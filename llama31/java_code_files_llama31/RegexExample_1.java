/*
 * Decompiled with CFR 0.152.
 */
public class RegexExample_1 {
    public static void main(String[] stringArray) {
        String string = "<select>hello</select><script>alert('XSS')</script>";
        String string2 = "<(?!select|\\/select).*?>";
        String string3 = string.replaceAll(string2, "");
        System.out.println(string3);
    }
}
