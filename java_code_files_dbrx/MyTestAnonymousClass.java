import java.lang.String;
public class MyTestAnonymousClass {
    MyTest test = new MyTest() {
        String name;

        public void setName(String name) {
            this.name = name;
        }

        { // instance initialization block
            setName("John Johnson");
        }
    };

    public static void main(String[] args) {
    }
}

class MyTest {
}