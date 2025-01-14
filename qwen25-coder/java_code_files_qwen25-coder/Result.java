import java.lang.String;

public class Main {

    public static void main(String[] args) {
        Result result = foo(5);
        int a = result.value1;
        int b = result.value2;
    }

    public static Result foo(int c) {
        return new Result(c + 1, c * 2);
    }

    public static class Result {
        public final int value1;
        public final int value2;

        public Result(int value1, int value2) {
            this.value1 = value1;
            this.value2 = value2;
        }
    }
}