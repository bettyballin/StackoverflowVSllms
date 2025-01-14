import java.lang.String;
import java.lang.Integer;
import java.util.Calendar;
import java.util.TimeZone;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "T_Order")
public class TOrder implements Serializable {
    private static final long serialVersionUID = 2235742302377173533L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "activationDate")
    private Calendar activationDate;

    // Method to convert calendar to UTC before save
    public Calendar getActivationDate() {
        return convertToTargetTimeZone(this.activationDate, TimeZone.getTimeZone("UTC"));
    }

    public void setActivationDate(Calendar activationDate) {
        this.activationDate = convertToTargetTimeZone(activationDate, TimeZone.getDefault());
    }

    private Calendar convertToTargetTimeZone(Calendar calendar, TimeZone targetTimeZone) {
        if (calendar != null) {
            Calendar result = Calendar.getInstance(targetTimeZone);
            result.setTimeInMillis(calendar.getTimeInMillis());
            return result;
        }
        return null;
    }

    // getters and setters

    public static void main(String[] args) {
    }
}