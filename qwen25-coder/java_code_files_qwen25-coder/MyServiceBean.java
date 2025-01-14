import java.lang.String;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface Stateless {
}

public interface MyServiceRemote {
    String sayHello();
    // Other methods
}

@Stateless
public class MyServiceBean implements MyServiceRemote {
    @Override
    public String sayHello() {
        return "Hello, world!";
    }
    // Implement other methods here

    public static void main(String[] args) {
        MyServiceBean bean = new MyServiceBean();
        System.out.println(bean.sayHello());
    }
}