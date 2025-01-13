/*
 * Decompiled with CFR 0.152.
 */
public class Main_727 {
    public static void main(String[] stringArray) {
        Object var1_1 = null;
        String string = var1_1.getHeader("X-Requested-With");
        if ("XMLHttpRequest".equals(string)) {
            System.out.println("Request was likely made via AJAX");
        }
    }
}
