public class ConsoleFormatter {
    public static void printSpaces(int numberOfSpaces) {
        System.out.print(String.format("%" + numberOfSpaces + "s", ""));
    }

    public static void main(String[] args) {
        printSpaces(5); // example usage
    }
}