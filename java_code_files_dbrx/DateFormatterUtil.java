import java.util.Calendar;
import java.util.Locale;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatterUtil {
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MMM yyyy hh:mm zzz", Locale.US);
    Calendar calDate1 = Calendar.getInstance(); // Use the local time zone (default)
    Entity entity = new Entity(new Date());
    String dateInLocalTZAsString;

    {
        sdf.setCalendar(calDate1); // Set Calendar in Format - used for parsing string into calendar instance with right TZ
        dateInLocalTZAsString = sdf.format(entity.getActivationDate().getTime());
    }

    public static void main(String[] args) {
    }
}

class Entity {
    private Date activationDate;

    public Entity(Date activationDate) {
        this.activationDate = activationDate;
    }

    public Date getActivationDate() {
        return activationDate;
    }
}