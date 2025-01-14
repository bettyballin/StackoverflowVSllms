import java.lang.String;
public class TripleDESCBCLengthCalculator {
    public int getEncryptedStringLength(int plaintextLength) {
        // Block size for Triple DES in CBC mode
        final int BLOCK_SIZE = 8;
        
        // Calculate the number of blocks needed, including padding
        int numBlocks = (plaintextLength + BLOCK_SIZE - 1) / BLOCK_SIZE;
        
        // Total length of encrypted data (including IV)
        return numBlocks * BLOCK_SIZE + BLOCK_SIZE; // BLOCK_SIZE for IV
    }
    public static void main(String[] args) {
    }
}