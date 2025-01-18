public class MyTestInitializer {
    class MyTest {
        public void setName(String name) {
            // Do something
        }
    }

    MyTest test = new MyTest() {{
        setName("John Johnson");
    }};

    public static void main(String[] args) {
    }
}