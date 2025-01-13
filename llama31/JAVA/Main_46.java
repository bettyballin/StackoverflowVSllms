import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Main_46 {
    public static void main(String[] args) {
        Date start = new Date();
        // do something
        Date end = new Date();
        long duration = end.getTime() - start.getTime();
        long convert = TimeUnit.MINUTES.convert(duration, TimeUnit.MILLISECONDS);
        System.out.println("duration = " + convert);
    }
}