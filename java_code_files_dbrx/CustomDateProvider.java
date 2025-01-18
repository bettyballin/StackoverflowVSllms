import java.lang.String;
import java.time.LocalDateTime;

// Define a dummy @Service annotation
@interface Service {
}

// Define the DateProvider interface
interface DateProvider {
    LocalDateTime getCurrentDate();
}

@Service
public class CustomDateProvider implements DateProvider {
    private LocalDateTime fixedTime;

    @Override
    public LocalDateTime getCurrentDate() {
        if (fixedTime != null) {
            return fixedTime;
        } else {
            // Return real current date and time when no fixed time is set
            return LocalDateTime.now();
        }
    }

    public void setFixedTime(LocalDateTime fixedTime) {
        this.fixedTime = fixedTime;
    }

    public static void main(String[] args) {
        // You can test the class here
    }
}