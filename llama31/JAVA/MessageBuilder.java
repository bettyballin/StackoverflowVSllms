import java.lang.String;

public class MessageBuilder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("Hello");
        sb.append("\u001E"); // RECORD_SEPARATOR
        sb.append("World");
        sb.append("\u0003"); // END_OF_TEXT
        String message = sb.toString();
        System.out.println(message);
    }
}