import org.quicktheories.QuickTheory;
import org.quicktheories.core.Gen;
import org.quicktheories.core.Theory;
import org.quicktheories.core.ForAll;

public class Example_19_19 {
    @Theory
    public void testMethod(@ForAll int x, @ForAll int y) {
        // test code here
    }

    public static void main(String[] args) {
        QuickTheory qt = new QuickTheory();
        qt.test(Example_19.class);
    }
}