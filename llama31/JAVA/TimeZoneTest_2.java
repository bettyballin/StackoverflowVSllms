import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.TimeZone;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TimeZoneTest_2_2 {

    @Mock
    private TimeZone timeZone;

    @Test
    public void testTimeZone() {
        when(timeZone.getDefault()).thenReturn(TimeZone.getTimeZone("America/New_York"));
        // run your test code here
    }

    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("TimeZoneTest_2");
    }
}