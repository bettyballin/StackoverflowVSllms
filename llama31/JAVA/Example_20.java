import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

@RunWith(JUnitQuickcheck.class)
public class Example_20_20 {
    @Property(trials = 100)
    public void testMethod(@From(int[].class) int x, @From(int[].class) int y) {
        // test code here
    }

    public static void main(String[] args) {
    }
}