/*
 * Decompiled with CFR 0.152.
 */
public class JettyServletResponseConfigurator {
    public static void main(String[] stringArray) {
    }

    static {
        System.setProperty("org.eclipse.jetty.servlet.ServletResponseWrapper", "org.apache.jasper.runtime.HttpServletResponseWrapper");
    }
}
