/*
 * Decompiled with CFR 0.152.
 */
import java.net.URL;

public class XsdSchemaLoader {
    public static void main(String[] stringArray) {
        ClassLoader classLoader = XsdSchemaLoader.class.getClassLoader();
        URL uRL = classLoader.getResource("schemas/your_schema.xsd");
    }
}
