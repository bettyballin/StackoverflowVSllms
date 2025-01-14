import java.lang.String;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class TemporalDate {
    @Column(name = "LastTouched", updatable = false, insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastTouched;

    public static void main(String[] args) {
    }
}