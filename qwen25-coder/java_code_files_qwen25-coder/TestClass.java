import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

public class TestClass {

    @Test
    public void testArrays() {
        String[] actual = {"a", "b", "c"};
        String[] expected = {"a", "b", "c"};

        assertThat(actual).isEqualTo(expected);
    }
}