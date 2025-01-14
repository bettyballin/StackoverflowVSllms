public class TagRemover {
    static String regexForAllTags = "<[^>]*>";
    static String input = "<p>This is a <b>test</b>.</p>";
    static String resultWithoutTags = input.replaceAll(regexForAllTags, "");
    static {
        System.out.println(resultWithoutTags);
    }

    public static void main(String[] args) {
    }
}