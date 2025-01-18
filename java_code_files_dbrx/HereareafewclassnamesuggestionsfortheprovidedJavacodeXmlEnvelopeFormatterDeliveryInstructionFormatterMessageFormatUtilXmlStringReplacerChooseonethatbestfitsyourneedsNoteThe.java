import java.lang.String;
import java.text.MessageFormat;

public class MessageFormatUtil {
    public static void main(String[] args) {
        try {
            String input = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n"
                         + "<envelope version=\"2.3\">\n"
                         + "<delivery_instrunction>\n"
                         + "    <channel>@CHANNEL_TYPE@</channel>\n"
                         + "</delivery_instruction>\n"
                         + "</envelope>";

            String[] keys = new String[1]; // Fill this with your runtime values
            MessageFormat formatter = new MessageFormat("{0}");
            for (int i = keys.length - 1; i >= 0; i--) { // Backward because of possible conflicts between the replaceAll results
                formatter.setFormatByArgumentIndex(i, new MessageFormat("@{0}@"));
            }
            String output = formatter.format(keys);
        } catch (Exception e) { // Handle exception if keys are missing or invalid format etc.
            e.printStackTrace();
        }
    }
}