import java.lang.String;
import java.lang.Integer;

public class LeadingZeroesRemover {
    public static void main(String[] args) {
        String strNumber = "00332"; //maintains leading zeroes
        int number = Integer.parseInt(strNumber); //removes leading zeroes - 332
        System.out.println(strNumber + " and " + number);
    }
}