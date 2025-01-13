public class StringEscaper {
    public static void main(String[] args) {
        String input = "79827349837493827498";
        String output = input.replaceAll("..", "\\\\\\$0");
        System.out.println(output);
    }
}