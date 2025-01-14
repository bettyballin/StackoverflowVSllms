public class StringFormatter {
    public String format(Object... args) {
        return String.format(this.toString(), args);
    }

    public static void main(String[] args) {
    }
}