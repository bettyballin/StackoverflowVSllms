import java.lang.String;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.LocalTime;

// Annotation definitions
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface RestController {}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
@interface Autowired {}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface GetMapping {
    String[] value() default "";
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@interface RequestParam {
    String value() default "";
    boolean required() default true;
}

// Class definitions
class CustomDateProvider {
    void setFixedTime(LocalDateTime ldt) {
        // implementation not needed for compilation
    }
}

class ResponseEntity<T> {
    static ResponseEntity<Void> badRequest() {
        return new ResponseEntity<Void>();
    }
    static ResponseEntity<Void> ok() {
        return new ResponseEntity<Void>();
    }
    ResponseEntity<T> build() {
        return this;
    }
}

// The original class
@RestController
public class DateProviderController {
    @Autowired private CustomDateProvider customDateProvider;

    @GetMapping("/set-fixed-time")
    public ResponseEntity<Void> setFixedTime(@RequestParam(value = "date", required=false) String dateString,
                                             @RequestParam(value = "hour",  required=false) int hour,
                                             @RequestParam(value = "minute",required=false) int minute) {
        try {
            LocalDateTime.parse(dateString);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(dateString, dtf);
        LocalTime localTime = LocalTime.of(hour, minute).plusMinutes(5L); // Adding 5 minute buffer

        customDateProvider.setFixedTime(LocalDateTime.of(localDate, localTime));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/set-real-time")
    public ResponseEntity<Void> setRealTime() {
        customDateProvider.setFixedTime(null);
        return ResponseEntity.ok().build();
    }

    public static void main(String[] args) {
    }
}