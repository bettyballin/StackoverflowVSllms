import java.lang.String;
import javax.annotation.PostConstruct;

public class PrototypeInitializer {

    private MyPrototypeBean myPrototypeBean;

    @PostConstruct
    public void init() {
        // Instantiate or access your prototype bean here to force early initialization
        myPrototypeBean.doSomething();
    }

    public static void main(String[] args) {
    }
}