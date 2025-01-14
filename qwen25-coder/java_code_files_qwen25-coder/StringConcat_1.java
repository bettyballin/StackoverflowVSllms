public class StringConcat {
    public StringConcat() {
        super();
    }

    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "World";
        str1 = new StringBuilder().append(str1).append(str2).toString();
        System.out.println(str1);
    }
}