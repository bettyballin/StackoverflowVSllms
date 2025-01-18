import java.util.Date;
import java.sql.Timestamp;

public interface DateTimeInterface {
    public Date getDateTime();
    public void setDateTime(Date date_time);
    // For Timestamps:
    public Timestamp getDateTimeTS();
    public void setDateTimeTS(Timestamp timestamp);
}