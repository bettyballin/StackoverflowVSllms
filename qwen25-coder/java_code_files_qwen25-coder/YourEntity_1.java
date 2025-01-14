import java.lang.String;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "TABLE_NAME", schema = "SCHEMA")
public class YourEntity_1 {
    @Column(name = "date_time")
    private LocalDate dateTime;

    public LocalDate getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDate date_time) {
        this.dateTime = date_time;
    }

	public static void main(String[] args) {
	}
}