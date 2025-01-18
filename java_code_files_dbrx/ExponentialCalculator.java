import java.lang.String;
public class ExponentialCalculator {
    public double exponential(double base, int exponent){
        if (exponent == 0 || base == 1.0) {
            return 1;
        } else if(base==0 && exponent > 0){
           // If the base is equal to zero and power is greater than one
           // then any positive real number raised to zero results in a value of 1.
            return 1.0;
        }else {
            double result = exponential(base, exponent / 2);
            if (exponent % 2 == 0) {
                return result * result;   // If the exponent is even
            } else if (exponent > 0){       // If the exponent is odd and positive.
                 return result * result  * base;
            }else{              // If the exponent negative, invert the base result by multiplying with inverse i.e., Math.pow(base,-1) or 1/Math.pow(base);
                return result * result * (1 / Math.pow(base, -exponent));
           }
        }
    }
    public static void main(String[] args) {
    }
}