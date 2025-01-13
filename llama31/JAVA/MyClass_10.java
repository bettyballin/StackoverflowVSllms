import java.lang.String;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyClass_10_10 {
    public void myMethod() {
        log.info("Hello from {}", "myMethod");
    }

    public static void main(String[] args) {
        MyClass_10 myClass = new MyClass_10();
        myClass.myMethod();
    }
}