import java.io.InputStream;

public class SqlResourceLoader {
    InputStream sqlInputStream = getClass().getClassLoader().getResourceAsStream("com/example/myapp/MyClass.sql");

    public static void main(String[] args) {
        new SqlResourceLoader();
    }
}