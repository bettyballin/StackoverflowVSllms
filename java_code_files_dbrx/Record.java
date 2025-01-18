import java.lang.String;
import java.time.LocalDateTime;
public class Record {
    private String name;
    private int age;
    private String city;
    private LocalDateTime date; // use java.time for modern Date/Time handling

    public Record(String name, int age, String city, LocalDateTime date) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.date = date;
    }

    // ... getters and setters here ...

    public static void main(String[] args) {
    }
}