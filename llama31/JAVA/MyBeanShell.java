import java.lang.String; // Not necessary, as String is imported by default
// Embedded BeanShell example
import bsh.Interpreter;

public class MyBeanShell {
    public static void main(String[] args) {
        Interpreter i = new Interpreter();
        try {
            i.eval("/* your Java code here */");
        } catch (bsh.EvalError e) {
            System.out.println("Error in script: " + e.getMessage());
        }
    }
}