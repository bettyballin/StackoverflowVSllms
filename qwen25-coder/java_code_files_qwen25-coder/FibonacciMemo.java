import java.util.HashMap;

public class FibonacciMemo {

    public int fibonacciMemo(int n, HashMap<Integer, Integer> memo) {
        if (n <= 1) return n;
        if (!memo.containsKey(n)) {
            memo.put(n, fibonacciMemo(n - 1, memo) + fibonacciMemo(n - 2, memo));
        }
        return memo.get(n);
    }

    // Call with: fibonacciMemo(n, new HashMap<>());

    public static void main(String[] args) {
        FibonacciMemo fib = new FibonacciMemo();
        int n = 10; // You can change this value or get it from args
        int result = fib.fibonacciMemo(n, new HashMap<>());
        System.out.println("Fibonacci number at position " + n + " is " + result);
    }
}