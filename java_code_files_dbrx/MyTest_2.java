import java.lang.String;
public class MyTest_2 {
    MyTest test = new MyTest(){
        {
            setName("John Johnson");
        }
    };
    public static void main(String[] args) {
    }
}

class MyTest {
    public void setName(String name) {
    }
}