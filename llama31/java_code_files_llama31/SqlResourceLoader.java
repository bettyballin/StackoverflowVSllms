/*
 * Decompiled with CFR 0.152.
 */
import java.io.InputStream;

public class SqlResourceLoader {
    InputStream sqlInputStream = this.getClass().getClassLoader().getResourceAsStream("com/example/myapp/MyClass.sql");

    public static void main(String[] stringArray) {
        new SqlResourceLoader();
    }
}
