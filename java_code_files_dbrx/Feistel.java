import java.util.*;
import java.security.SecureRandom;

public class Feistel {
    private static final int ROUNDS = 16; /* tune as desired */
    private byte[] keyBytes; // some input data to choose a function

    public Feistel(String str) {
        /* initialize a simple example PRF, but DO NOT use in production because RC4 is weak */
        keyBytes = new byte[str.length()];
        for (int i = 0; i < keyBytes.length; ++i)
            keyBytes[i] = (byte) str.charAt(i); // don't cast if you want Unicode chars as a 'key'
    }

    public int encryptDecrypt(final int value) {
        byte high = (byte)((value >>> 16) & 0xFF); /* masking is equivalent to taking only the top 8 bits of the MSB and shifting it down */
        byte low =  (byte)( value       & 0xFF);     /* then take the bottom 8 bits as our two 'halves' */
        byte right;
        for (int r = ROUNDS; r > 0; --r) { /* start with round number, decrement in each iteration */
            right = low; /* assign 'right' to 'low' */
            final int tmp = feistel(right); /* then do the Feistel magic by passing one 'half' into a pseudo-random function based on keyBytes. Store returned value temporarily */
            right ^= high;    /* finally XOR and swap our two halves for next iterations */
            high = (byte)tmp;
        }
        return ((high & 0xFF) << 16) | (right & 0xFFFF); /* reassemble the int to form final encrypted value/plaintext, using bitwise OR and shift operations. Don't forget to mask properly! */
    }

    private byte feistel(final int y) {
        SecureRandom sr = new SecureRandom();
        sr.setSeed(keyBytes);
        return (byte)((sr.nextInt() & 0xFF) + y & 0x1F); /* a simple example 'round function', you can make this as complex and unique to your system requirements */
    }
}