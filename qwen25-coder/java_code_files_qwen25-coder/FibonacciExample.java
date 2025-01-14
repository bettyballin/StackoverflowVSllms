import java.util.Stack;

public class FibonacciExample {

    public int fibonacciIterativeWithStack(int n) {
        if (n <= 1) return n;
        
        Stack<Integer> stack = new Stack<>();
        stack.push(n);
        
        int[] fib = new int[n + 1];
        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (fib[current] != 0 || current <= 1) continue;
            
            if (fib[current - 1] == 0 && current - 1 > 0) stack.push(current - 1);
            if (fib[current - 2] == 0 && current - 2 > 0) stack.push(current - 2);
            
            if (current - 1 <= 1) fib[current - 1] = 1;
            if (current - 2 <= 1) fib[current - 2] = 1;
            
            fib[current] = fib[current - 1] + fib[current - 2];
        }
        
        return fib[n];
    }

    public static void main(String[] args) {
        FibonacciExample example = new FibonacciExample();
        int n = 10; // You can change this value to compute a different term
        int result = example.fibonacciIterativeWithStack(n);
        System.out.println("Fibonacci of " + n + " is: " + result);
    }
}