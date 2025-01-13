/*
 * Decompiled with CFR 0.152.
 */
import java.io.InputStream;
import java.util.Properties;

public class InterfaceLoader {
    public static void main(String[] stringArray) throws Exception {
        Properties properties = new Properties();
        InputStream inputStream = InterfaceLoader.class.getClassLoader().getResourceAsStream("META-INF/services/YourInterface");
        properties.load(inputStream);
        inputStream.close();
        for (String string : properties.stringPropertyNames()) {
            Class<?> clazz = Class.forName(string);
            YourInterface yourInterface = (YourInterface)clazz.newInstance();
        }
    }
}
