import java.util.List;

public class Main {
    public static class Result {
        private List<String> list;
        private String string;

        public Result(List<String> list, String string) {
            this.list = list;
            this.string = string;
        }

        public List<String> getList() {
            return list;
        }

        public String getString() {
            return string;
        }
    }

    public static Result myFunction() {
        // You need to initialize the list and string variables before using them
        List<String> list = List.of("Item1", "Item2"); // Example initialization
        String string = "Hello, World!"; // Example initialization

        return new Result(list, string);
    }

    public static void main(String[] args) {
        Result result = myFunction();
        System.out.println(result.getList());
        System.out.println(result.getString());
    }
}