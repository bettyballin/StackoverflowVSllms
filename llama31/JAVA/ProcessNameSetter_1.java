import java.lang.String;
import org.jproc.Proc;

public class ProcessNameSetter_1_1 {
    public static void main(String[] args) {
        Proc proc = Proc.current();
        proc.name("MyProgram");
    }
}