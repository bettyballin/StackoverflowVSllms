import java.util.*;
import java.security.SecureRandom;  // Java's TRNG class for secure random numbers

public class RandomGenerator{
 public static void main(String[] args){
    SecureRandom sr = new SecureRandom();
    byte[] bytesArrayForRandBytesNumbers = new byte[2];
    sr.nextBytes(bytesArrayForRandBytesNumbers); // Populate an array of random bytes for a 16-bit number
    System.out.println(sr.getAlgorithm());
    short secureRandomShort = (short) (((bytesArrayForRandBytesNumbers[0] & 0xff) << 8) | (bytesArrayForRandBytesNumbers[1] & 0xff)); // Create a secure random Short number
    System.out.println("SecureRandom Number: " + secureRandomShort);
   }
}