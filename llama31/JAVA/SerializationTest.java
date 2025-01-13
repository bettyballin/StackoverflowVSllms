import java.io.*;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class SerializationTest {

    public static void main(String[] args) throws Exception {

        final String yyyyMMdd = "20090220";
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        final Instant instant = Instant.from(formatter.parse(yyyyMMdd, ZoneId.systemDefault()));

        final String filename = "instant.ser";
        final boolean serialise = true; // change to false to deserialize

        if (serialise) {
            // write the object to file
            try (ObjectOutputStream outputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filename)))) {
                outputStream.writeObject(instant);
            }

            System.out.println("Serialised: " + instant);
        } else {
            // read the object from file
            try (ObjectInputStream inputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filename)))) {
                Instant outInstant = (Instant) inputStream.readObject();
                System.out.println(outInstant);
            }
        }
    }
}