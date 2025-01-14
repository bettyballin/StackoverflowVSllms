import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface Stateless {
}

@Retention(RetentionPolicy.RUNTIME)
@interface RolesAllowed {
    String value();
}

interface MyBeanLocal {
    void doSomethingSecure();
}

interface MyBeanRemote {
    void doSomethingSecure();
}

@Stateless
public class MyEJB implements MyBeanLocal, MyBeanRemote {
    
    @RolesAllowed("Internal")
    public void doSomethingSecure() {
        // secure operation here.
    }

    public static void main(String[] args) {
    }
}