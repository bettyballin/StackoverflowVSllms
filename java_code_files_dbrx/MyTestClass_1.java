import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import java.util.Arrays;

public class MyTestClass {

    @Test
    public void assertWithHamcrest() {
        String[] actual = new String[]{"value1", "value2"};
        assertThat(Arrays.asList(actual), hasItems("value1", "value2")); // expecting the array to contain both `value1` and `value2`, order doesn't matter.
    }

}