import java.lang.String;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class SerializationTest {

    public static void main(String[] args) throws Exception {
        final String yyyyMMdd = "20090220";
        Date date = new SimpleDateFormat("yyyyMMdd").parse(yyyyMMdd);
        Instant dateInstant = date.toInstant();
        LocalDate localDate = dateInstant.atZone(ZoneId.of("CET")).toLocalDate();
        Instant instant = localDate.atStartOfDay(ZoneId.UTC).toInstant();

        if (args.length != 1) {
            System.out.println("Usage SerializationTest S|D");
            return;
        }

        boolean serialize = args[0].equals("S");

        String filename = "date.ser";
        if (serialize) {
            // write the instant to file
            Files.write(Paths.get(filename), instant.toString().getBytes());
            System.out.println("Serialized: " + instant);
        } else {
            byte[] bytes = Files.readAllBytes(Paths.get(filename));
            Instant outInstant = Instant.parse(new String(bytes));
            System.out.println(outInstant.atZone(ZoneId.of("GMT")).toLocalDate());
        }
    }
}