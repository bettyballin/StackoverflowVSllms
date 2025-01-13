/*
 * Decompiled with CFR 0.152.
 */
public class JNodeBootConfig {
    public static void main(String[] stringArray) {
        String string = "/jnode/kernel";
        System.out.println("Loading JNode kernel from: " + string);
        String string2 = "my.JavaApp";
        System.out.println("Loading Java application: " + string2);
        try {
            Class<?> clazz = Class.forName(string2);
            clazz.getMethod("main", String[].class).invoke(null, new Object[]{new String[0]});
        }
        catch (Exception exception) {
            System.err.println("Error loading Java application: " + exception.getMessage());
        }
    }
}
