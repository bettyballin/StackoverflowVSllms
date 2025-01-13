import java.util.ArrayList;

class Alert {
    public Alert(String s1, String s2, String s3) {}
}

public class AlertGenerator {
    public static ArrayList<Alert> getAlert() {
        ArrayList<Alert> alt = new ArrayList<Alert>();

        alt.add(new Alert("alert1","alert2","alert3"));
        alt.add(new Alert("alert4","alert5","alert6"));
        alt.add(new Alert("alert7","alert8","alert9"));

        return alt;
    }

    public static void main(String[] args) {
        ArrayList<Alert> alerts = getAlert();
        for (Alert alert : alerts) {
            System.out.println(alert);
        }
    }
}