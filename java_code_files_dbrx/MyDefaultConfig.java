import java.lang.String;
interface MyConfig {
    String getJndiName();
}

public class MyDefaultConfig implements MyConfig {
    @Override
    public String getJndiName() {
        return "java:comp/env/jdbs/LegacyDataSource";
    }

    public static void main(String[] args) {
    }
}