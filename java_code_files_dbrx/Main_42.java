public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(arr[0]); // prints the first element of the array

        System.out.println(greeting("John")); // calls the function and prints "Hello, John"
    }

    static String greeting(String name) {
        return "Hello, " + name;
    }
}