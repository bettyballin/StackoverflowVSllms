import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class LicenseorSubscription {
    @Column(name = "activationDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar activationDate;

    public static void main(String[] args) {
    }
}