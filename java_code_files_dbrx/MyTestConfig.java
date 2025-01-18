interface MyConfig {
    String getJndiName();
}

public class MyTestConfig implements MyConfig {
    @Override
    public String getJndiName() {
        return "java:comp/env/jdbs/TestingDataSource"; // Your testing data source name.
    }

    public static void main(String[] args) {
    }
}