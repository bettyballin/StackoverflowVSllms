/*
 * Decompiled with CFR 0.152.
 */
public class JavaEnvironmentDetector {
    String javaVersion = System.getProperty("java.version");

    public static void main(String[] stringArray) {
        JavaEnvironmentDetector javaEnvironmentDetector = new JavaEnvironmentDetector();
        System.out.println(javaEnvironmentDetector.javaVersion);
    }
}
