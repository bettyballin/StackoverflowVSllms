/*
 * Decompiled with CFR 0.152.
 */
public class ResourceAccessor {
    ExternalResourceBundle bundle = new ExternalResourceBundle("application", "../properties");
    String pluginName = this.bundle.getString("%plugin.name");

    public static void main(String[] stringArray) {
        ResourceAccessor resourceAccessor = new ResourceAccessor();
        System.out.println(resourceAccessor.pluginName);
    }
}
