import java.lang.String;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

public class MyExampleMXBeanInterfaceorsimplyMyExampleMXBeanBothareacceptablebutthesecondoneismorecommoninJava {
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    public @interface MBean {
        String description();
    }

    @MBean(description = "An Example Bean")
    public interface MyExampleMXBean {
        int getAttribute();
    }

    public static void main(String[] args) {
    }
}