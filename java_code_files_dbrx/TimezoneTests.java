import java.lang.String;
import java.util.Arrays;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TimezoneTests {
    private String zone; // This will be used in your setup method to set up different timezones

    public TimezoneTests(String zone) {
        this.zone = zone;
    }

    @Parameters
    public static Collection<Object[]> data() {
       return Arrays.asList(new Object[][]{ // Different time zones as per your requirements like UTC-5, etc.
               {"America/New_York"},
               // Add more here...
        });
   }

	public static void main(String[] args) {
	}
}