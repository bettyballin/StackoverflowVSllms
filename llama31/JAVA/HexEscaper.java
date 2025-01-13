public class HexEscaper {
    public static void main(String[] args) {
        String input = "79827349837493827498";
        String output = "";
        for (int i = 0; i < input.length(); i += 2) {
            output += "\\" + input.substring(i, i + 2);
        }
        System.out.println(output);
    }
}