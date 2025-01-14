import java.lang.String;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Component {
    String factory();
}

@Component(factory = "MyThirdClass.Factory")
public class MyThirdClass {
    private String arg1;
    private int arg2;

    public void setArg1(String value) { this.arg1 = value; }
    public void setArg2(int value) { this.arg2 = value; }

    public void doSomething() {}

    public static void main(String[] args) {
    }
}