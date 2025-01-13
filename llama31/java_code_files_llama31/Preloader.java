/*
 * Decompiled with CFR 0.152.
 */
public class Preloader {
    public static void main(String[] stringArray) {
    }

    static {
        try {
            Class.forName("com.example.MyClass1");
            Class.forName("com.example.MyClass2");
        }
        catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }
    }
}
