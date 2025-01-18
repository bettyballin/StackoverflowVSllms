import java.lang.String;
import java.util.Date;
import java.util.Calendar;
import java.util.TimeZone;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;

public class UtcDateTestassistantPleasenotethatthisisjustasuggestionTheclassnameshouldbedescriptiveandfollowthenamingconventionsofyourprojectororganization {

    // Using JMock to create a mock Date object
    Mockery context = new Mockery() {{
        setImposteriser(ClassImposteriser.INSTANCE);
    }};

    Date mockedDate;

    Calendar calendar;

    {
        mockedDate = context.mock(Date.class);

        calendar = Calendar.getInstance();

        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));

        context.checking(new Expectations() {{
            allowing(mockedDate).getTime();
            will(returnValue((long)1234567890L)); // UTC time stamp
        }});
    }

    public static void main(String[] args) {
    }

}