import java.lang.String;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "TABLE_NAME", schema = "SCHEMA")
public class YourEntity_2 {
    @Column(name = "date_time")
    private Date dateTime;

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date date_time) {
        this.dateTime = date_time;
    }

	public static void main(String[] args) {
	}
}