import javax.ejb.Stateless;
import javax.ejb.Schedule;

@Stateless
public class MyTimer {
    @Schedule(hour = "23", minute = "30", dayOfWeek = "*")
    public void runTimer() {
        // Code to run at 11:30 PM every day
    }

    public static void main(String[] args) {
    }
}