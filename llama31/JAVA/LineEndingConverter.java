public class LineEndingConverter {
    public static void main(String[] args) {
        String windowsText = "Hello\r\nWorld!";
        String unixText = windowsText.replace("\r\n", "\n");
        System.out.println("Unix text: " + unixText);

        String windowsTextConverted = unixText.replace("\n", "\r\n");
        System.out.println("Windows text: " + windowsTextConverted);
    }
}