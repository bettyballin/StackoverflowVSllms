import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class EntityWithDate {
    @Temporal(TemporalType.DATE)
    private Date myDate;

    public static void main(String[] args) {
    }
}