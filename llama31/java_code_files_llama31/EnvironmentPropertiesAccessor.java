/*
 * Decompiled with CFR 0.152.
 */
public class EnvironmentPropertiesAccessor {
    String tmpDir = System.getProperty("java.io.tmpdir");

    public static void main(String[] stringArray) {
        EnvironmentPropertiesAccessor environmentPropertiesAccessor = new EnvironmentPropertiesAccessor();
        System.out.println(environmentPropertiesAccessor.tmpDir);
    }
}
