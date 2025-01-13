import java.lang.String;
import com.timeanddate.TimeAndDate;
import com.timeanddate.TimeZone;
import org.junit.Test;

public class TimeZoneTest_1_1 {

    @Test
    public void testTimeZone() {
        TimeAndDate timeAndDate = new TimeAndDate();
        timeAndDate.setTimeZone(TimeZone.forID("America/New_York"));
        // run your test code here
    }

    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("TimeZoneTest_1");
    }
}