public class ConditionalStatement {
    public static void main(String[] args) {
        boolean condition1 = false;
        boolean condition2 = false;
        boolean condition3 = false;

        if (condition1) {
            // Code to execute if condition1 is true
        } else if (condition2) {
            // Code to execute if condition1 was false and condition2 is true
        } else if (condition3) {
            // Code to execute if both condition1 and condition2 were false, but condition3 is true
        } else {
            // Code to execute if none of the previous conditions are true
        }
    }
}