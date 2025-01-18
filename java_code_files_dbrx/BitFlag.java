import java.math.*; // BigInteger
import java.util.BitSet;

public class BitFlag {
   private static final int maxFlags = 256; // Can use up to ~2^1023 flags theoretically (limited by hardware) with BigIntegers

   public static void main(String[] args) {
      BitSet flagSet = new BitSet();  // Bitset for convenience but will be converted later

      for(int i = maxFlags - 5; i < maxFlags; i++) // setting last five flags to true
         flagSet.set(i);

      BigInteger value = bitSetToBigInt(flagSet, maxFlags); // Converting Bitset into BigInteger form to mimic same effect
   }

   public static BigInteger bitSetToBigInt(BitSet bs, int numFlags) {  // function to convert a BitSet of NUM_FLAGS length into equivalent BigInteger value as flag bits set.
      byte[] bytes = new byte[bs.size()]; // Creating an array big enough to hold all possible flags based on size of bitset
      for(int i = 0; i < numFlags; i++) {    // iterating through each potential flag position and checking if they have been set or not using get() function from BitSet class. If it's set, corresponding byte position would be 1 else zero.
         if(bs.get(i)) {  
            bytes[i] = (byte)0b1; // setting the byte at 'i' to binary 'one' as it matches with a flag bit that is set in BitSet
         } else {
            bytes[i] = (byte)0;       // otherwise we make sure it's zeroed out
         }
      }
      return new BigInteger(bytes);     // Returning final value
   }
}