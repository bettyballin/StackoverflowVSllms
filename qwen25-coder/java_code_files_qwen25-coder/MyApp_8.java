import java.lang.String;
public class MyApp_8 {
       public static void main(String[] args) {
           try {
               // Application logic here
               doSomething();
               System.out.println("Application ran successfully.");
           } catch (SpecificException e) {
               // Handle specific errors
               handleSpecificError(e);
           } catch (Exception e) {
               // Catch all other unexpected issues
               handleGeneralError(e);
           }
       }

       private static void doSomething() throws SpecificException {
           // Do nothing
       }

       private static void handleSpecificError(Exception e) {
           System.err.println("Handled Specific Error: " + e.getMessage());
       }

       private static void handleGeneralError(Exception e) {
           System.err.println("Unhandled error occurred: " + e.getMessage());
       }
   }

class SpecificException extends Exception {
}