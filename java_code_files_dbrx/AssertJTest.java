import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AssertJTest {

    @Test
    public void assertWithAssertJ() {
        String[] actual = new String[]{"value1", "value2"};
        assertThat(actual)
                .containsExactly("value1", "value2")
                .doesNotContain("otherValue");
    }
}