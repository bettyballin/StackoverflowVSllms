import jcom.JCom;
import jcom.JComException;

public class Main_154 {
    public static void main(String[] args) {
        try {
            // Create an instance of the COM component
            JCom component = new JCom("MyComComponent");

            // Call a method on the COM component
            component.call("MyMethod");
        } catch (JComException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}