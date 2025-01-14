import java.lang.String;
import org.junit.Test;
import static org.junit.Assert.*;

public class RefactoredTest {

    private Object expectedResult = "expected result";
    private Code code = new Code();
    private Object oldParam = "old parameter";
    private Object newParam = "new parameter";

    // Before: LegacyMethod(oldParam)
    @Test
    public void testLegacyMethodWithOldParam() {
        assertEquals(expectedResult, code.legacyMethod(oldParam));
    }

    // After Refactor: LegacyMethod(newParam)
    @Test
    public void testLegacyMethodWithNewParam() {
        assertEquals(expectedResult, code.refactoredLegacyMethod(newParam));
    }

    public static void main(String[] args) {
    }
}

class Code {
    public Object legacyMethod(Object param) {
        return null; // stub implementation
    }

    public Object refactoredLegacyMethod(Object param) {
        return null; // stub implementation
    }
}