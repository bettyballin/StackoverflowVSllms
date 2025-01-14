import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateRangeQueryParamSetter {

    LocalDate date = LocalDate.of(2009, 6, 11);

    Query query = new Query();

    {
        query.setParameter("startDate", Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        query.setParameter("endDate", Date.from(date.plusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant()));
    }

    public static void main(String[] args) {
    }
}

class Query {
    public void setParameter(String name, Object value) {
        // Method implementation
    }
}