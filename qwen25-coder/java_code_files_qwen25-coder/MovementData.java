import java.lang.String;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

@Embeddable
public class MovementData implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "SPEED")
    private double speed;

    @Column(name = "TIME_OF_POSITION")
    private Date timeOfPosition;

    @Column(name = "LONGITUDE")
    private double longitude;

    @Column(name = "LATITUDE")
    private double latitude;

    protected MovementData() {
        // Default constructor
    }

    public double getSpeed() {
        return this.speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public Date getTimeOfPosition() {
        return this.timeOfPosition;
    }

    public void setTimeOfPosition(Date timeOfPosition) {
        this.timeOfPosition = timeOfPosition;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

	public static void main(String[] args) {
	}
}