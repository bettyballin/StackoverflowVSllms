import java.lang.String;
public class Trig_functions {
    public double computeSin(double x){ //x in radians
        int i;           // loop counter (local variable)
        int n = 1; // term variable
        double temp = 0.0, sign = -1.0, term = 1.0; // local variables for summation storage
        long factorial = 2;                     // used to store the current power of x and hold its sign in (-1)^n
            /* Summing first six terms of infinite series */
        for(i=1; i<=6; i++){// n is the term number up till six (adjustable)
               temp = temp + sign*x/factorial; // update summation value by one more term
                             factorial *= ++n * (n+1);       // find next denominator and calculate x^(2n)/denominator
                sign = -sign ;        // swap the sign of each odd term (-1)^n
        }//end looping through terms to summation
         return temp;  // resultant sum is our best approximation for sin(x)
    }// end computeSin() method for class Trig_functions
    public static void main(String[] args) {
    }
}