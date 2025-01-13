import org.joda.time.DateTimeZone;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TimeZoneTest {

    private DateTimeZone originalTimeZone;

    @Before
    public void setUp() {
        originalTimeZone = DateTimeZone.getDefault();
    }

    @After
    public void tearDown() {
        DateTimeZone.setDefault(originalTimeZone);
    }

    @Test
    public void testTimeZone() {
        DateTimeZone.setDefault(DateTimeZone.forID("America/New_York"));
        // run your test code here
    }

    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("TimeZoneTest");
    }
}