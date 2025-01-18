import java.text.SimpleDateFormat; // Import the required class
import java.util.Calendar; // Import the Calendar class

public class Main_341 {
  public static void main(String[] args) {
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); // Set the format for output
    try{
      String str = "23/09/2007"; // Your date of input
      java.util.Date date; // Create an object of Date class

      date = formatter.parse(str);  // Convert String to java.util.Date
      System.out.println("Date: " + formatter.format(date)); // Print the new format for output (23/09/2007 in this case)
    } catch (Exception e){
        System.out.println("Error parsing date :" +e); // Error handling when date is not parsed correctly
      }
  }
}