import java.util.Map;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KeySubstitution {
    public static String substituteKeys(String template, Map<String, String> replacements) {
        // Define the pattern to match keys in the format @key@
        Pattern pattern = Pattern.compile("@([^@]+?)@");
        Matcher matcher = pattern.matcher(template);

        // Use a StringBuilder for efficient string manipulation
        StringBuilder result = new StringBuilder();

        int lastEnd = 0;
        while (matcher.find()) {
            // Append the text before the current match
            result.append(template, lastEnd, matcher.start());

            // Get the key and fetch the replacement value from map
            String key = matcher.group(1);
            String replacement = replacements.getOrDefault(key, "");

            // Append the replacement value to the StringBuilder
            result.append(replacement);

            // Move the index forward after the current match
            lastEnd = matcher.end();
        }

        // Append any remaining text after the last match
        result.append(template.substring(lastEnd));

        return result.toString();
    }

    public static void main(String[] args) {
        String template = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n"
                + "<envelope version=\"2.3\">\n"
                + "  <delivery_instructions>\n"
                + "    <delivery_channel>\n"
                + "      <channel_type>@CHANNEL_TYPE@</channel_type>\n"
                + "    </delivery_channel>\n"
                + "    <delivery_envelope>\n"
                + "      <chan_delivery_envelope>\n"
                + "        <queue_name>@ADDRESS@</queue_name>\n"
                + "      </chan_delivery_envelope>\n"
                + "    </delivery_envelope>\n"
                + "  </delivery_instructions>\n"
                + "  <composition_instructions>\n"
                + "    <mime_part content_type=\"application/xml\">\n"
                + "      <content><external_uri>@URI@</external_uri></content>\n"
                + "    </mime_part>\n"
                + "  </composition_instructions>\n"
                + "</envelope>";

        Map<String, String> replacements = new HashMap<>();
        replacements.put("CHANNEL_TYPE", "Email");
        replacements.put("ADDRESS", "example@example.com");
        replacements.put("URI", "http://example.com/uri");

        String result = substituteKeys(template, replacements);
        System.out.println(result);
    }
}