import java.util.List;
import org.reflections.Reflections;

public class GetSubTypesOfSomeInterfaceInMyPackage {
    List<Class<? extends SomeInterface>> subTypes = new Reflections("my.package").getSubTypesOf(SomeInterface.class);
    public static void main(String[] args) {
    }
}