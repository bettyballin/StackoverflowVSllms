import java.util.Arrays;

public class RequestValidator {
    public static void main(String[] args) {
        // Assuming request is an HttpServletRequest object
        // For demonstration purposes, we will use dummy values
        String stateParam = "state1,state2,state3";
        String sizeParam = "size1,size2,size3";

        String[] states = stateParam.split(",");
        String[] sizes = sizeParam.split(",");

        // Validate and sanitize the input values
        for (String state : states) {
            // validate state value
            System.out.println("State: " + state.trim());
        }
        for (String size : sizes) {
            // validate size value
            System.out.println("Size: " + size.trim());
        }
    }
}