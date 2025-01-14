// Define dummy annotations to allow compilation
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface WebService {}

@Retention(RetentionPolicy.RUNTIME)
@interface WebMethod {}

@WebService
class HelloWorld {
    @WebMethod
    public String sayHello(String name) {
        return "Hello, " + name + "!";
    }
}