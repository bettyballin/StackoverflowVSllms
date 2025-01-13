import org.junit.Test;
import java.lang.String;

public class MyLegacyClassTest {

    @Test
    public void testDoSomeLegacyStuff() {
        String testJndiName = "java:comp/env/jdbc/TestDataSource";
        MyLegacyClass myLegacyClass = new MyLegacyClass(testJndiName);
        // test doSomeLegacyStuff method
    }

    public static void main(String[] args) {
    }
}