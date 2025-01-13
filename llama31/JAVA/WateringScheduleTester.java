import java.time.LocalDate;

public class WateringScheduleTester {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        String group = "A";
        String allowedDays = WateringSchedule.getAllowedDays(group, today);
        System.out.println(allowedDays);
    }
}