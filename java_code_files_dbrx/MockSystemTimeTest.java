import java.util.Date;
import mockit.Expectations;
import mockit.Mocked;
import org.junit.Test;

public final class MockSystemTimeTest {
    @Test
    public void testGetCurrentYear(@Mocked final Date currentDate) throws Exception { // 'current' date is faked by mocking library!
        new Expectations() {{ // Configure the 'mocked' Date object to return a constant year
            anyInstanceOf(Date.class).getTime(); result = 1460398080000L; // 2016 in milliseconds since epoch
        }};
    }
}