import java.util.Date;

public class TimestampGenerator {
    private Date created;

    public Date created() { 
        if (created == null) created = new Date();
        return created; 
    }

    public static void main(String[] args) {
        TimestampGenerator generator = new TimestampGenerator();
        System.out.println(generator.created());
    }
}